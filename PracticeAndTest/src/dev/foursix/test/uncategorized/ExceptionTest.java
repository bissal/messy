package dev.foursix.test.uncategorized;
import java.io.IOException;


public class ExceptionTest {
	
	public ExceptionTest() {
		try {
			
			throw new IOException("this is a test");
			
		} catch (Exception e) {
//			e.printStackTrace();
			
//			System.out.println(e.getStackTrace()[0]);
//			System.out.println(e.getStackTrace()[1]);
			
			if (e instanceof IOException) {
				System.out.println("sss");
			}
			
			
			System.out.println(e.fillInStackTrace().getClass().getName());
			
//			System.out.println(e.getStackTrace()[0]);
//			System.out.println(e.getStackTrace()[1]);
		}
	}

}
