package dev.foursix.test.concurrent;

import static org.junit.Assert.*;

import org.junit.Test;

public class AtomicTest {

	@Test
	public void testUsingVolatile() {		
		AdderUseVolatile useVolatile = new AdderUseVolatile();
		
		long elapsedTime = runAdderThreads(useVolatile);
				
		System.out.println("Volatile >");
		System.out.println("Value: " + useVolatile.getValue());
		System.out.println("Elapsed time: " + elapsedTime + "ms");
		System.out.println();
		
		assertEquals(999999000000L, useVolatile.getValue());
	}
	
	@Test
	public void testUsingSynchronized() {
		AdderUseSynchronized useSynchronized = new AdderUseSynchronized();
		
		long elapsedTime = runAdderThreads(useSynchronized);
		
		System.out.println("Synchronized >");
		System.out.println("Value: " + useSynchronized.getValue());
		System.out.println("Elapsed time: " + elapsedTime + "ms");
		System.out.println();
		
		assertEquals(999999000000L, useSynchronized.getValue());
	}
	
	@Test
	public void testUsingAtomicLong() {
		AdderUseAtomicLong useAtomicLong = new AdderUseAtomicLong();
		
		long elapsedTime = runAdderThreads(useAtomicLong);
		
		System.out.println("Atomic >");
		System.out.println("Value: " + useAtomicLong.getValue());
		System.out.println("Elapsed time: " + elapsedTime + "ms");
		System.out.println();
		
		assertEquals(999999000000L, useAtomicLong.getValue());
	}
	
	public long runAdderThreads(Runnable target) {
		Thread thread = new Thread(target);
		Thread thread2 = new Thread(target);
		
		long start = System.currentTimeMillis();
		
		thread.start();		
		thread2.start();
		
		try {
			thread.join();	
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		return end - start;
	}
}
