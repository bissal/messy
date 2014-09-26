package io.github.bissal.messy.test.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import junit.framework.TestCase;

import org.junit.Test;

public class FileCompareTest extends TestCase {
	
	@Test
	public void testFileCompareUseCompareTo() {
		File file1 = new File("append1.txt");
//		File file2 = new File("Copy of append.txt");
		File file3 = new File("append2.txt");
		
		int result = file1.compareTo(file3);
		
		assertEquals(0, result);		
	}
	
	@Test
	public void testFileCompareDirectly() {
		File file01 = new File("banana1.txt");
//		File file02 = new File("banana2.txt");
		File file02 = new File("tomato.txt");
		
		boolean isSame = compare(file01, file02);
		
		assertTrue(isSame);
	}
	
	public boolean compare(File file01, File file02) {
		FileInputStream fis01 = null;
		FileInputStream fis02 = null;
		
		try {
			fis01 = new FileInputStream(file01);
			fis02 = new FileInputStream(file02);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		long file01length = file01.length();
		long file02length = file02.length();
		
		byte[] fileData01 = new byte[(int) file01length];
		byte[] fileData02 = new byte[(int) file02length];
		
		try {
			fis01.read(fileData01);
			fis02.read(fileData02);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Arrays.equals(fileData01, fileData02);
	}
}
