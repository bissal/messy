package dev.foursix.practice.nio;

import java.nio.ByteBuffer;

public class DuplicateTest {
	
	public void foo() {	
		ByteBuffer buf = ByteBuffer.allocate(10);
		buf .put( ((byte) 0) )
			.put( ((byte) 1) )
			.put( ((byte) 2) )
			.put( ((byte) 3) )
			.put( ((byte) 4) )
			.put( ((byte) 5) )
			.put( ((byte) 6) )
			.put( ((byte) 7) )
			.put( ((byte) 8) )
			.put( ((byte) 9) );
		
		buf.position(3);
		
		buf.limit(9);
		
		buf.mark();
		
		ByteBuffer buf2 = buf.duplicate();
		
		System.out.println(
				"1) Position: " + buf.position()
				+ ", Limit: " + buf.limit()
				+ ", Capacity: " + buf.capacity()
				);
		
		buf2.position(7);
		buf2.reset();
		System.out.println("reset() ȣ�� �� Position: " + buf2.position());
		
		buf2.clear();
		
		System.out.println(
				"2) Position: " + buf2.position()
				+ ", Limit: " + buf2.limit()
				+ ", Capacity: " + buf2.capacity()
				);
		
		while (buf2.hasRemaining()) {
			System.out.print(buf2.get() + " ");
		}
		
		buf.put(0, ((byte) 10) );
		System.out.println("\n=> buf�� 0 ���� 10���� �ٲ�");
		
		System.out.println("Original Buffer Value: " + buf.get(0));
		System.out.println("Duplicated Buffer Value: " + buf2.get(0));
		
		buf.rewind();
		buf2.rewind();
		
		while (buf.hasRemaining()) {
			System.out.print(buf.get() + " ");
		}
		System.out.println();		
		while (buf2.hasRemaining()) {
			System.out.print(buf2.get() + " ");
		}		
		System.out.println();
		
		buf2.put(1, ((byte) 11) );
		System.out.println("=> buf2�� 1 ���� 11���� �ٲ�");
		
		System.out.println("Original Buffer Value: " + buf.get(1));
		System.out.println("Duplicated Buffer Value: " + buf2.get(1));
		
		while (buf.hasRemaining()) {
			System.out.print(buf.get() + " ");
		}
		
		while (buf2.hasRemaining()) {
			System.out.print(buf2.get() + " ");
		}
		
//		buf.clear();
		buf.rewind();
		buf2.rewind();
		
		while (buf.hasRemaining()) {
			System.out.print(buf.get() + " ");
		}
		System.out.println();		
		while (buf2.hasRemaining()) {
			System.out.print(buf2.get() + " ");
		}		
		System.out.println();
		
	}
	
	

}
