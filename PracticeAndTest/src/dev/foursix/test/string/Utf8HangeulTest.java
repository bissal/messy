package dev.foursix.test.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Utf8HangeulTest {
	
	public Utf8HangeulTest() {
		try {
			FileReader freader = new FileReader("D:\\aaa.txt");
			BufferedReader reader = new BufferedReader(freader);
			
//			System.out.print("asdf");
			String str = reader.readLine();
//			System.out.println(reader.readLine());
//			System.out.println(" " + str);
			
			System.out.println(str);
			System.out.println(new String(str.getBytes("UTF-8"), "UTF-8"));
			System.out.println(str.substring(1));
			
//			System.out.printf("%s", str.charAt(16));
//			System.out.printf("%s", str.substring(1));
			
			System.out.println(freader.getEncoding());
			
			byte[] barray = str.getBytes("UTF-8");
			
			
//			System.out.println(new String(barray, "EUC-KR"));
			
//			System.out.println("한글");
			
//			System.out.println(str.length());
//			System.out.println(str.getBytes().length);
//			System.out.println(str.getBytes("UTF-8").length);
//			
//			System.out.println("가".getBytes().length);
//			System.out.println("가".getBytes("UTF-8").length);
//			
//
//			System.out.println("가나".getBytes().length);
//			System.out.println("가나".getBytes("UTF-8").length);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
