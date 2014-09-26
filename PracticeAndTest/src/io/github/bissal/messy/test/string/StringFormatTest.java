package io.github.bissal.messy.test.string;

public class StringFormatTest {
	
	public StringFormatTest() {
		String strLength = String.format("%06d", 10);
		byte[] byteLength = strLength.getBytes();
		
		System.out.println(strLength);
		System.out.println(new String(byteLength));
		System.out.printf(
				"\n %d %d %d %d %d %d \n",
				byteLength[0],
				byteLength[1],
				byteLength[2],
				byteLength[3],
				byteLength[4],
				byteLength[5]);
	}

}
