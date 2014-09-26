package io.github.bissal.messy.test.thread;

import org.junit.Test;

public class SleepAndWaitTest {
	
	@Test
	public void testSleep() throws Exception {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println(System.currentTimeMillis());
					
					Thread.sleep(5000);
					System.out.println(System.currentTimeMillis());
				} catch (InterruptedException e) {
					System.out.println(System.currentTimeMillis());
//					e.printStackTrace();
				}
			}
		});
		
		thread.start();
		
//		thread.interrupt();
		
		thread.join();
	}

}
