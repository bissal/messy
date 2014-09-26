package dev.foursix.practice.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class ViewBufferTest {
	
	public void foo() {
		
		ByteBuffer buf = ByteBuffer.allocate(10);
		
		while (buf.hasRemaining()) {
			System.out.print(buf.get() + " ");
		}
		System.out.println();
		
		System.out.println(
				"1) Position: " + buf.position()
				+ ", Limit: " + buf.limit()
				+ ", Capacity: " + buf.capacity()
				);
		
		buf.rewind();		
		
		IntBuffer ib = buf.asIntBuffer();
		
		System.out.println(
				"2) Position: " + buf.position()
				+ ", Limit: " + buf.limit()
				+ ", Capacity: " + buf.capacity()
				);
		
		ib.put(4096).put(2048);
				
		System.out.println("Index_0=" + ib.get(0) + ", Index_1=" + ib.get(1));
		
		System.out.println(
				"3) Position: " + buf.position()
				+ ", Limit: " + buf.limit()
				+ ", Capacity: " + buf.capacity()
				);
		
		while (buf.hasRemaining()) {
			System.out.print(buf.get() + " ");
		}
		
		
		
	}

}
