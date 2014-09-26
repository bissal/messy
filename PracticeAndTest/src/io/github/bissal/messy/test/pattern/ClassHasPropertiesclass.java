package io.github.bissal.messy.test.pattern;

public class ClassHasPropertiesclass {	
	public Properties properties;
	
	public class Properties {
		private String	name;
		private int		age;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
	}
	
	public ClassHasPropertiesclass() {
		properties = new Properties();
	}
	
	public void doSomething() {
		properties.getName();
	}
	
}
