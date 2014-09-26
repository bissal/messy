package io.github.bissal.messy.test.uncategorized;

import io.github.bissal.messy.test.pattern.ClassHasPropertiesclass;

public class PropertiesInnerClassTest {
		
	public PropertiesInnerClassTest() {
		ClassHasPropertiesclass hasProp = new ClassHasPropertiesclass();
		hasProp.properties.setName("Jessica");
		System.out.println(hasProp.properties.getName());
		
		hasProp.properties.getAge();
	}
}
