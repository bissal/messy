package dev.foursix.test.convert;

import java.nio.ByteBuffer;

public class ConvertBetweenIntegernnByteArrayTest {
	
	public ConvertBetweenIntegernnByteArrayTest() {
		 byte[] b = intToBytes(127);
		 
		 System.out.println(b[0]);
		 System.out.println(b[1]);
		 System.out.println(b[2]);
		 System.out.println(b[3]);
		 
		 int i = bytesToInt(b);
		 System.out.println(i);
		 
		 
	}

	private int bytesToInt(byte[] bytes) {
//		ByteBuffer buffer = ByteBuffer.allocate(4).put(bytes);
//		buffer.rewind();
//		return buffer.getInt();
//		return buffer.asIntBuffer().get();		
//		return ((ByteBuffer) ByteBuffer.allocate(4).put(bytes).rewind()).getInt();
		return ByteBuffer.wrap(bytes).getInt();
	}

	private byte[] intToBytes(int value) {
		return ByteBuffer.allocate(4).putInt(value).array();		
	}
}
