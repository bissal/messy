package io.github.bissal.messy.test.string;

public class StringCopyTest {
	
	private String	string;

	public StringCopyTest() {
		String src = "banana";
		
		String dest = src;
		
		String replace = dest.replace('a', 'o');
		
		System.out.println(src);
		System.out.println(dest);
		System.out.println(replace);
		
		setString(src);
		System.out.println(getString());
		String dd = getString();
		dd = "aaaa";
		System.out.println(dd);
		System.out.println(src);
		
		String stri =  getString().replace('a', 'i');
		System.out.println(stri);
		System.out.println(getString());
	}

	private String getString() {
		return string;		
	}

	private void setString(String src) {
		string = src;		
	}

}
