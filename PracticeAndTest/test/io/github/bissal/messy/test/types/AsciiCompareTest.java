package io.github.bissal.messy.test.types;

import static org.junit.Assert.fail;

import java.nio.ByteBuffer;
import java.util.Arrays;

import org.junit.Test;

public class AsciiCompareTest {
	
	@Test
	public void testByteCompare() {
		byte b = (byte) '9';
		
//		if (b < 65) {
//			System.out.println(b);
//			fail();
//		}
		System.out.println(b);
		System.out.printf("%x", b);
		
		int value = -5;
		byte [] barray = ByteBuffer.allocate(4).putInt(value).array();
		System.out.println(new String(barray));
		System.out.println(Arrays.toString(barray));
	}

}
