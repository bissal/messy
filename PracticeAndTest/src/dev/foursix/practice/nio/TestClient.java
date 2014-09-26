package dev.foursix.practice.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class TestClient {
	
	public TestClient() {
		SocketChannel channel;
		try {
			channel = SocketChannel.open();
			InetSocketAddress inetSocketAddress
			= new InetSocketAddress(10086);
			
			channel.connect(inetSocketAddress);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
