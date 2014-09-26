package io.github.bissal.messy.test.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

public class LocalhostTest {

	@Test
	public void test() throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr);
	}
}
