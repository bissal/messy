package io.github.bissal.messy.test.queue;
import io.github.bissal.messy.test.uncategorized.ShowDefault;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class QueueTest {
	
	public QueueTest() {
		int round = 100000;
		
		ShowDefault[] show = new ShowDefault[round];
		ShowDefault[] show2 = new ShowDefault[round];
		
		for (int i = 0; i < round; i++) {
			show[i] = new ShowDefault();
		}		
		
		Queue<ShowDefault> queue
//		LinkedBlockingQueue<ShowDefault> queue
//		= new ConcurrentLinkedQueue<>();
//		= new LinkedTransferQueue<>();
//		= new LinkedList<>();
//		= new ArrayBlockingQueue<>(round);
		= new LinkedBlockingQueue<>();
//		= new LinkedBlockingQueue<>(round);
//		= new SynchronousQueue<>();
//		= new SynchronousQueue<>(true);
		
		List<ShowDefault> list
//		= new ArrayList<>();
		= new LinkedList<>();
		
//		int availableProcessors = Runtime.getRuntime().availableProcessors();
//		System.out.println("availableProcessors: " + availableProcessors);		
		int remain = round - 1;
		
		long startOffer = System.currentTimeMillis();		
		for (int i = 0; i < round; i++) {
			queue.offer(show[i]);
//			list.add(show[i]);
			show2[i] = queue.poll();
//			show2[i] = list.remove(0);
		}
		long endOffer = System.currentTimeMillis();
				
//		ArrayList<ShowDefault> list = new ArrayList<>();		
//		int drainto = queue.drainTo(list, round - 10000);
//		
//		System.out.println(drainto);
		
		long startPoll = System.currentTimeMillis();
		for (int i = 0; i < round; i++) {
//			show2[i] = queue.poll();
//			show2[i] = list.remove(remain  - i);
//			show2[i] = list.remove(0);
////			queue.size();
////			System.out.println(show2[i]);
		}
		long endPoll = System.currentTimeMillis();
//		
		System.out.println("Elapsed Offer: " + (endOffer - startOffer));
		System.out.println("Elapsed Poll: " + (endPoll - startPoll));
		System.out.println("Elapsed Total: " + (endPoll - startOffer));
//		
//		System.out.format("%,d", Integer.MAX_VALUE);
	}

}
