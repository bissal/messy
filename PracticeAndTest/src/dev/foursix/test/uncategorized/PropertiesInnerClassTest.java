package dev.foursix.test.uncategorized;

import dev.foursix.test.pattern.ClassHasPropertiesclass;

public class PropertiesInnerClassTest {
		
	public PropertiesInnerClassTest() {
		ClassHasPropertiesclass hasProp = new ClassHasPropertiesclass();
		hasProp.properties.setName("Jessica");
		System.out.println(hasProp.properties.getName());
		
		hasProp.properties.getAge();
	}
}
