package dev.foursix.test.name;

import org.junit.Test;

public class ClassGetNameTest {
	
	@Test
	public void getName() {
		System.out.println(this.getClass());
		System.out.println(this.getClass().getName());
		System.out.println(this.getClass().getCanonicalName());
		System.out.println(this.getClass().getSimpleName());
	}
}
