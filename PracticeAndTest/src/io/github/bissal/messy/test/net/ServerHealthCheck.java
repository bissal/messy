package io.github.bissal.messy.test.net;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;



public class ServerHealthCheck {
		
	public ServerHealthCheck() {
//		try {
//			SocketChannel channel = SocketChannel.open();
//			channel.configureBlocking(true);
//			
//			String host = "172.10.13.14";
//			int port = 10083;			
//			
//			InetSocketAddress remote = new InetSocketAddress(host, port);
//			channel.connect(remote);
//			
//			if (channel.isConnected()) {
//				System.out.println(channel);
//			}
//			
//			channel.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Socket sock = null;
		try {
			sock = new Socket("172.10.13.52", 10083);
//			sock = new Socket("192.168.101.133", 10083);
			System.out.println(sock + ": 연결됨");
			sock.close();
			
//			sock = new Socket("172.10.13.14", 10082);
//			System.out.println(sock + ": 연결됨");
//			sock.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}	
}
