package io.github.bissal.messy.examples.exec;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class ExecTest {

	@Test
	public void test() {
		try {
			for (int i = 0; i < 5; i++) {
				Process process = Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
