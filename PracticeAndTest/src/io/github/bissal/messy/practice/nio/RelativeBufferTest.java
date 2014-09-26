package io.github.bissal.messy.practice.nio;

import java.nio.ByteBuffer;

public class RelativeBufferTest {
	
	public void foo() {
		ByteBuffer buf = ByteBuffer.allocate(10);
		System.out.println("Init Position: " + buf.position());
		System.out.println("Init Limit: " + buf.limit());
		System.out.println("Init Capacity: " + buf.capacity());
		
		buf.mark();
		
		buf.put( ((byte)10) ).put( ((byte)11) ).put( ((byte)12) );
		
		buf.reset();
		
		System.out.println("Value: " + buf.get() + ", Position: " + buf.position());
		System.out.println("Value: " + buf.get() + ", Position: " + buf.position());
		System.out.println("Value: " + buf.get() + ", Position: " + buf.position());
		
		System.out.println("Value: " + buf.get() + ", Position: " + buf.position());
		
		
	}
	

}
