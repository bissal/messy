package io.github.bissal.messy.practice.nio;

import java.nio.ByteBuffer;

public class AbsoluteBufferTest {
	
	public void foo() {
		ByteBuffer buf = ByteBuffer.allocate(10);
		System.out.println("Init Position: " + buf.position());
		System.out.println("Init Limit: " + buf.limit());
		System.out.println("Init Capacity: " + buf.capacity());
		
		buf.put(3, ((byte) 6) );
		buf.put(4, ((byte) 7) );
		buf.put(5, ((byte) 8) );
		
		System.out.println("Position: " + buf.position());
		
		System.out.println("Value: " + buf.get(3) + ", Position: " + buf.position());
		System.out.println("Value: " + buf.get(4) + ", Position: " + buf.position());
		System.out.println("Value: " + buf.get(5) + ", Position: " + buf.position());
		
		System.out.println("Value: " + buf.get(9) + ", Position: " + buf.position());
		
		System.out.print("{");
		for (int i = 0; i < buf.limit(); i++) {
			System.out.print(buf.get(i) + ", ");
		}
		System.out.println("}");
		
		
		
		
	}
	
	public void printByteBuffer(ByteBuffer buf) {
		System.out.print("{");
		for (int i = 0; i < buf.limit(); i++) {
			System.out.print(buf.get(i) + ", ");
		}
		System.out.println("}");
	}

}
