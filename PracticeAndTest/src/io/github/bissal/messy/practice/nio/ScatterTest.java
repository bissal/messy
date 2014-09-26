package io.github.bissal.messy.practice.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ScatteringByteChannel;

public class ScatterTest {
	
	public void foo() {
		
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("src\\PracMain.java");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ScatteringByteChannel channel = fin.getChannel();
		
		ByteBuffer header = ByteBuffer.allocateDirect(100);
		ByteBuffer body = ByteBuffer.allocateDirect(200);
		ByteBuffer[] buffers = { header, body };
		
		int readCount = 0;
		try {
			readCount = (int) channel.read(buffers);
			channel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Read count: " + readCount);
		
		System.out.println(
				"\n//-----------------------------------------------------//");
		
		header.flip();		
		byte[] b = new byte[100];
		header.get(b);
		System.out.println("Header: " + new String(b));
		
		System.out.println(
				"\n//-----------------------------------------------------//");

		body.flip();		
		byte[] bb = new byte[200];
		body.get(bb);
		System.out.println("Body: " + new String(bb));
		
		
	}

}
