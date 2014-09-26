package io.github.bissal.messy.test.uncategorized;

public class SleepAccuracyTest {
	
	public SleepAccuracyTest() {
		try {			
			long start = System.nanoTime();
			Thread.sleep(100);
			long end = System.nanoTime();
			
			long elapsed = end - start;			
			System.out.println("Elapsed: " + elapsed + "ns");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
