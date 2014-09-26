package io.github.bissal.messy.test.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringRefTest {
	
	@Test
	public void testByteArrayToString() {
		// given
		byte[] value = "foo banana".getBytes();
		
		// when 
		String strValue = new String(value);
		String replaced = strValue.replace("foo", "delicious");
		
		// then
		assertEquals(strValue, new String(value));	
		assertEquals(replaced, new String(value));	
	}
}
