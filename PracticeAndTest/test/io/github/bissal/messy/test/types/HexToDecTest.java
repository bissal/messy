package io.github.bissal.messy.test.types;

import org.junit.Test;

public class HexToDecTest {
	
	@Test
	public void testByteCompare() {
		String hex = "FF";
		System.out.println(Integer.valueOf(hex, 16));
	}
}
