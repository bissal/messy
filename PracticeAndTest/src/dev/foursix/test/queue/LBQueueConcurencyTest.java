package dev.foursix.test.queue;
import java.util.concurrent.LinkedBlockingQueue;


public class LBQueueConcurencyTest {
	
	public LBQueueConcurencyTest() {
		final LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<Object>();
		
		final String threadA = "[I'm Thread_A]";
		final String threadB = "[I'm Thread_B]";
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println(queue.offer(threadA + i));
				}				
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println(queue.offer(threadB + i));
				}
			}
		}).start();
		
		try {
			while (!queue.isEmpty()) {
				System.out.println(queue.take());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
