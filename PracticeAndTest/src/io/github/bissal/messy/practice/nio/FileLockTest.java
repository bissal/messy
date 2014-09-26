package io.github.bissal.messy.practice.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {
	
	public FileLockTest() {
		FileChannel channel = null;
		
		try {
			File file = new File("D:\\test.txt");
			channel = new RandomAccessFile(file, "rw").getChannel();
			
			FileLock lock = channel.lock(0, Long.MAX_VALUE, true);
			
			try {
				boolean isShared = lock.isShared();
				System.out.println("Is shared lock?: " + isShared);
				
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				lock.release();
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (channel != null) {
				try {
					channel.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}				
	}
}
