package dev.foursix.test.uncategorized;

import java.util.Arrays;
import java.util.Random;

public class ArraysSortTest {
	
	public ArraysSortTest() {
		int[] array = new int[10];
		
		Random random = new Random();
		
		for (int i = 0; i < 10; i++) {
			array[i] = random.nextInt(100);
			System.out.printf("[%d:%d]", i, array[i]);
		}
		
		Arrays.sort(array);
		System.out.println();
		for (int i = 0; i < 10; i++) {
			System.out.printf("[%d:%d]", i, array[i]);
		}
	}
}
