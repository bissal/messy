package dev.foursix.test.uncategorized;

import java.io.IOException;
import java.io.InputStream;

public class ConsoleExecTest {
	
	public ConsoleExecTest() {
		try {
//			Process process = Runtime.getRuntime().exec("C:\\Windows\\System32\\cmd.exe");
			Process process = new ProcessBuilder("cmd", "/c", "dir").start();
//			Process process = new ProcessBuilder("notepad.exe").start();
//			Process process = new ProcessBuilder("cmd", "/c", "rmiregistry", "2099").start();
//			InputStream isr = process.getInputStream();
//			
//			while (true) {
//				System.out.write(isr.read());
//			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
