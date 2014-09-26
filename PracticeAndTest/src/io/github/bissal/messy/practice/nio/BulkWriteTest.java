package io.github.bissal.messy.practice.nio;

import java.nio.ByteBuffer;

public class BulkWriteTest {
	
	public void foo() {
		ByteBuffer buf = ByteBuffer.allocate(10);
		buf.position(5);
		buf.mark();
		
		printByteBuffer(buf);
		
		System.out.println(
				"Position: " + buf.position() + ", Limit: " + buf.limit());
		
		byte[] b = new byte[15];
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) i;
		}
		
		int size = buf.remaining();
		if (b.length < size) {
			size = b.length;
		}
				
		buf.put(b, 0, size);
		System.out.println(
				"Position: " + buf.position() + ", Limit: " + buf.limit());
		
		buf.reset();
		doSomething(buf, size);
		printByteBuffer(buf);
	}

	private void doSomething(ByteBuffer buf, int size) {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			System.out.println("byte = " + buf.get());
		}
		
	}
	
	public void printByteBuffer(ByteBuffer buf) {
		System.out.print("{");
		for (int i = 0; i < buf.limit(); i++) {
			System.out.print(buf.get(i) + ", ");
		}
		System.out.println("}");
	}

}
