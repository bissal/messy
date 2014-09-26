package io.github.bissal.messy.test.uncategorized;
import java.util.Arrays;


public class ArrayCopyTest {
	
	public ArrayCopyTest() {
		
		int amount = 1024;
		int round = 1000000;
		
//		int length = amount;
		int length = 4;
		
		byte[] src = new byte[amount];
		byte[] dst = new byte[amount];
		
		Arrays.fill(src, (byte)0x41);		
		System.out.println("# JDK Array copy");		
		
		
		long start = System.currentTimeMillis();		
		for (int i = 0; i < round; i++) {
			System.arraycopy(src, 0, dst, 0, length);
		}		
		long end = System.currentTimeMillis();
		
		
		System.out.println("Elapsed Time: " + (end - start) + "ms\n");
		
		selfmadeArraycopy(amount, round, length);
		
		
	}
	
	public void selfmadeArraycopy(int amount, int round, int length) {		
		
		byte[] src = new byte[amount];
		byte[] dst = new byte[amount];
		
		Arrays.fill(src, (byte)0x41);
		System.out.println("# Selfmade Array copy");		
		
		
		long start = System.currentTimeMillis();		
		for (int i = 0; i < round; i++) {
//			arrayCopy(src, dst);
//			for (int j = 0; j < length; j++) {
//				dst[j] = src[j];
//			}
			dst[0] = src[0];
			dst[1] = src[1];
			dst[2] = src[2];
			dst[3] = src[3];
		}		
		long end = System.currentTimeMillis();		
		
		
		System.out.println("Elapsed Time: " + (end - start) + "ms\n");		
	}
	
	public void arrayCopy(byte[] src, byte[] dst) {
		int len = src.length;
		for (int i = 0; i < len; i++) {
			dst[i] = src[i];
		}
	}

}
