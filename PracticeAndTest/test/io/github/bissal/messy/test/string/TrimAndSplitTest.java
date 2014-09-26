package io.github.bissal.messy.test.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TrimAndSplitTest {
	
	@Test
	public void testTrimAndSplit() {
		String sample = " apple   banana      ";
		String afterTrim = sample.trim();
		
		System.out.println("[" + afterTrim + "]");
		
		String[] tokens = afterTrim.split(" ");
		for (String token : tokens) {
			System.out.println("[" + token + "]");
		}
	}
}
