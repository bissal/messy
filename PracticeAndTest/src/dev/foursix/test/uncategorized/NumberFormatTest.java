package dev.foursix.test.uncategorized;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;


public class NumberFormatTest {
	
	public NumberFormatTest() {
		try {
		System.out.println();
		byte[] b = {1, 0};
//		byte[] b = {'1', '0'};
		
		System.out.printf("%d\n", b[0]);
		System.out.printf("%c\n", b[0]);
		
		NumberFormat format = new DecimalFormat("000000");
		
		String str = new String(b);
		System.out.println(str);
		
		int i = format.parse(str).intValue();			
		System.out.println(i);
		
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
