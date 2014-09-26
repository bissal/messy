package io.github.bissal.messy.practice.nio;

import java.nio.ByteBuffer;

public class BulkReadTest {
	
	public void foo() {
		ByteBuffer buf = ByteBuffer.allocate(10);
		buf	.put( ((byte) 0) )
			.put( ((byte) 1) )
			.put( ((byte) 2) )
			.put( ((byte) 3) )
			.put( ((byte) 4) );
						
		buf.mark();
				
		buf	.put( ((byte) 5) )
			.put( ((byte) 6) )
			.put( ((byte) 7) )
			.put( ((byte) 8) )
			.put( ((byte) 9) );
				
		buf.reset();
		
		byte[] b = new byte[15];
		
		int size = buf.remaining();
		if (b.length < size) {
			size = b.length;
		}
		
		System.out.println(
				"Position: " + buf.position() + ", Limit: " + buf.limit());		
		buf.get(b, 0, size);
		System.out.println(
				"Position: " + buf.position() + ", Limit: " + buf.limit());
		
		doSomething(b, size);
		
	}

	private void doSomething(byte[] b, int size) {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			System.out.println("byte = " + b[i]);
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
