package dev.foursix.test.net;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.UUID;


public class AddressView {
	
	public AddressView() {
		try {
			InetAddress localhost = InetAddress.getLocalHost();
			String ip = localhost.getHostAddress();			
			System.out.println(ip);
			
			NetworkInterface ni = NetworkInterface.getByInetAddress((localhost));
			byte[] mac = ni.getHardwareAddress();
			
			System.out.println("mamamamam: " + mac.length);
			
//			System.out.println(new String(mac));
			String macaddr = "";
			for (int i = 0; i < mac.length; i++) {
				macaddr += String.format("%02X%s", mac[i], (i < mac.length - 1)?"-":"");				
			}
			System.out.println(macaddr);
			
			System.out.println(UUID.randomUUID());
			System.out.println(ip + UUID.randomUUID());			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
