package dev.foursix.practice.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class ByteBufferPool {

	private static final int			MEMORY_BLOCKSIZE	= 1024;
	private static final int			FILE_BLOCKSIZE		= 2048;

	private final ArrayList<ByteBuffer>	memoryQueue;
	private final ArrayList<ByteBuffer>	fileQueue;

	private boolean						isWait				= false;

	public ByteBufferPool(int memorySize, int fileSize, File file) {

		memoryQueue = new ArrayList<ByteBuffer>();
		fileQueue = new ArrayList<ByteBuffer>();

		if (memorySize > 0) {
			initMemoryBuffer(memorySize);
		}
		if (fileSize > 0) {
			initFileBuffer(fileSize, file);
		}
	}

	private void initMemoryBuffer(int memorySize) {
		
		int bufferCount = memorySize / MEMORY_BLOCKSIZE;
		memorySize = bufferCount * MEMORY_BLOCKSIZE;
		
		ByteBuffer directBuf = ByteBuffer.allocateDirect(memorySize);
		divideBuffer(directBuf, MEMORY_BLOCKSIZE, memoryQueue);
	}

	private void initFileBuffer(int fileSize, File file) {
		
		int bufferCount = fileSize / FILE_BLOCKSIZE;
		fileSize = bufferCount * FILE_BLOCKSIZE;
		
		RandomAccessFile randomAccessFile = null;
		
		try {
			randomAccessFile = new RandomAccessFile(file, "rw");
			randomAccessFile.setLength(fileSize);
			
			ByteBuffer fileBuffer
			= randomAccessFile.getChannel().map(
												FileChannel.MapMode.READ_WRITE,
												0L,
												fileSize
												);
			
			divideBuffer(fileBuffer, FILE_BLOCKSIZE, fileQueue);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				randomAccessFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void divideBuffer(	ByteBuffer directBuf,
								int memoryBlocksize,
								ArrayList<ByteBuffer> memoryQueue	) {
		
		int bufferCount = directBuf.capacity() / memoryBlocksize;
		int position = 0;
		
		for (int i = 0; i < bufferCount; i++) {
			
			int max = position + memoryBlocksize;			
			directBuf.limit(max);			
			memoryQueue.add(directBuf.slice());
			
			position = max;			
			directBuf.position(position);
		}		
	}
	
	public ByteBuffer getMemoryBuffer() {
		return getBuffer(this.memoryQueue, this.fileQueue);
	}
	
	public ByteBuffer getFileBuffer() {
		return getBuffer(this.fileQueue, this.memoryQueue);
	}	

	private ByteBuffer getBuffer(	ArrayList<ByteBuffer> firstQueue,
									ArrayList<ByteBuffer> secondQueue		) {
		
		ByteBuffer buffer = getBuffer(firstQueue, false);
		if (buffer == null) {
			buffer = getBuffer(secondQueue, false);
			if (buffer == null) {
				if (isWait) {
					buffer = getBuffer(firstQueue, true);
				} else {
					buffer = ByteBuffer.allocate(MEMORY_BLOCKSIZE);
				}
			}
		}
		
		return buffer;
	}

	private ByteBuffer getBuffer(ArrayList<ByteBuffer> queue, boolean wait) {
		
		synchronized (queue) {
			if (queue.isEmpty()) {
				if (wait) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						return null;
					}
				} else {
					return null;
				}
			}
			return (ByteBuffer) queue.remove(0);			
		}
	}
	
	public void putBuffer(ByteBuffer buffer) {
		
		if (buffer.isDirect()) {
			
			switch (buffer.capacity()) {
			case MEMORY_BLOCKSIZE :
				putBuffer(buffer, this.memoryQueue);
				break;
			case FILE_BLOCKSIZE :
				putBuffer(buffer, this.fileQueue);
				break;
			}
		}
	}

	private void putBuffer(ByteBuffer buffer, ArrayList<ByteBuffer> memoryQueue) {
		buffer.clear();
		synchronized (memoryQueue) {
			memoryQueue.add(buffer);
			memoryQueue.notify();
		}
	}
	
	public synchronized void setWait(boolean wait) {
		this.isWait = wait;
	}
	
	public synchronized boolean isWait() {
		return isWait;
	}
}
