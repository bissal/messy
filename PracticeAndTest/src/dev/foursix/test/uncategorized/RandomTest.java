package dev.foursix.test.uncategorized;

import java.util.Date;
import java.util.Random;

public class RandomTest {
	
	public RandomTest() {
//		rangeCheck();
		Random random = new Random();
		String n = String.format("%04d", random.nextInt(10000));
		System.out.println("n=" + n);
		
		getRandomString();
		
	}

	private void getRandomString() {
		Random random = new Random();
		
		String c = String.format( "%c%c%c%c"
								, random.nextInt(26) + 65
								, random.nextInt(26) + 65
								, random.nextInt(26) + 65
								, random.nextInt(26) + 65
								);
		System.out.println("n=" + c);
	}
	
	public void rangeCheck() {
		Random random = new Random();
		for (int i = 0; i < 1000000000; i++) {
//			int n = random.nextInt(100);
			int n = random.nextInt(100) + 1;
			if (n == 100)
				System.out.println("n=" + n);
		}
	}

}
