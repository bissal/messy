package io.github.bissal.messy.examples.env;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.junit.Test;

public class EnvTest {

	@Test
	public void test() {
		System.setProperty("TEST_HOME", "test/test");
		
		Map<String, String> envMap = System.getenv();
		for (Map.Entry<String, String> env : envMap.entrySet()) {
			System.out.println(env);
		}
		
		Properties properties = System.getProperties();
		for (Entry<Object, Object> property : properties.entrySet()) {
			System.out.println(property);
		}
	}
}
