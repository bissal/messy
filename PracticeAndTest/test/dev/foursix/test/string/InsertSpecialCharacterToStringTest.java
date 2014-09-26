package dev.foursix.test.string;

import java.util.Map.Entry;

import org.junit.Test;

public class InsertSpecialCharacterToStringTest {
	
	@Test
	public void printStringWithInsertedSpecialCharacter() {
		
		String hello = "Hello";
		
		for (byte b = 0; b < 48; b++) {
			String str = String.format("%s [%d:%c]", hello, b, b);
			System.out.println(str);
		}
		System.out.println("0 ~ 47.");
		
		for (byte b = 58; b < 65; b++) {
			String str = String.format("%s [%d:%c]", hello, b, b);
			System.out.println(str);
		}
		System.out.println("58 ~ 64");
		
		for (byte b = 91; b < 97; b++) {
			String str = String.format("%s [%d:%c]", hello, b, b);
			System.out.println(str);
		}
		System.out.println("91 ~ 96");
		
		for (byte b = 123; b < 127; b++) {
			String str = String.format("%s [%d:%c]", hello, b, b);
			System.out.println(str);
		}
		System.out.println("123 ~ 126");
		
		for (byte b = 0; b < 127; b++) {
			String str = String.format("%s [%d:%c]", hello, b, b);
			System.out.println(str);
		}
		System.out.println("fin.");
		
		for (int i = 69825; i < 299999; i++) {
			String c = Character.getName(i);
			
			if (c == null) {
				continue;
			}
			
			System.out.printf("[%d:%s] ", i, c);
			if (i % 5 == 0) {
				System.out.println();
			}
		}
		System.out.println(Character.isLetterOrDigit("*".codePointAt(0)));
		
		for (int i = 0; i < 127; i++) {
			if (Character.isLetterOrDigit(i) == false) {
//			if (Character.isWhitespace(i) == false) {
				System.out.println("[" + i + ":" + Character.getName(i) + "]");
			}
		}
		
		for (byte c = 0; c < 127; c++) {
			if (Character.isLetterOrDigit(c) == false) {
//				System.out.printf("[%d:%c]\n", c, c);
				if (Character.isIdentifierIgnorable(c)) {
					String str = String.format("[%d:%c isWhitespace]", c, c);
					System.out.println(str);
				} else {
					String str = String.format("[%d:%c]", c, c);
					System.out.println(str);
				}
			}
		}
		
		for (Entry<Object, Object> entry : System.getProperties().entrySet()) {
			System.out.println(entry);
		}
	}

}
