package dev.foursix.practice.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;

public class GatheringTest {
	
	public void foo() {
		FileOutputStream fo = null;		
		try {
			fo = new FileOutputStream("D:\\test.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GatheringByteChannel channel = fo.getChannel();
		
		ByteBuffer header = ByteBuffer.allocate(20);
		ByteBuffer body = ByteBuffer.allocate(40);
		ByteBuffer[] buffers = { header, body };
		
		header.put("Hello ".getBytes());
		body.put("World".getBytes());
		
		header.flip();
		body.flip();
		
		try {
			channel.write(buffers);
			channel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
