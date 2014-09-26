package io.github.bissal.messy.practice.nio;

import java.nio.ByteBuffer;

public class SliceTest {
	
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
		
		ByteBuffer buf2 = buf.slice();
		
/////////////////////////////////////////
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
/////////////////////////////////////////
		
		System.out.println(
				"1) Position: " + buf2.position()
				+ ", Limit: " + buf2.limit()
				+ ", Capacity: " + buf2.capacity()
				);
		
		while (buf2.hasRemaining()) {
			System.out.print(buf2.get() + " ");
		}
		
		buf.put(3, ((byte) 10) );
		System.out.println("\n=> buf�� 3 ���� 10���� �ٲ�");
		
/////////////////////////////////////////
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
/////////////////////////////////////////
		
		System.out.println("Original Buffer Value: " + buf.get(3));
		System.out.println("Sliced Buffer Value: " + buf2.get(3));
		
		buf.put(4, ((byte) 11) );
		System.out.println("\n=> buf�� 4 ���� 11���� �ٲ�");
		
/////////////////////////////////////////
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
/////////////////////////////////////////
		
		System.out.println("Original Buffer Value: " + buf.get(4));
		System.out.println("Sliced Buffer Value: " + buf2.get(4));
		
		
		
		
		
		
	}

}
