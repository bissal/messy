package dev.foursix.test.string;

public class StringOperationVSnthPrintStringTest {
	
	public StringOperationVSnthPrintStringTest() {
		long start = System.nanoTime();		
		System.out.println("ccccconnected from "					
				+ "ccccconnected from "
				+ "ccccconnected from "
				);		
		long end = System.nanoTime();
		
		long start2 = System.nanoTime();		
		System.out.println("ccccconnected from ");
		System.out.println("ccccconnected from ");
		System.out.println("ccccconnected from ");		
		long end2 = System.nanoTime();
		
		System.out.println("Str opr: " + (end - start));
		System.out.println("Prt nth: " + (end2 - start2));
	}

}
