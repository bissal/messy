package dev.foursix.test.uncategorized;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class XmlInOutTest {
	
	public XmlInOutTest() {
		
		File src = new File("build_windows.xml");
		File target = new File("target.xml");
		
		int length = (int) src.length();		
		byte[] xml = new byte[length];
		
		try {
			
			FileInputStream fis = new FileInputStream(src);
			fis.read(xml, 0, length);
			
			System.out.println(new String(xml));
			
			FileOutputStream fos = new FileOutputStream(target);
			fos.write(xml, 0, length);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
