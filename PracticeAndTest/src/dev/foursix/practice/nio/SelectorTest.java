package dev.foursix.practice.nio;

import java.io.IOException;

public class SelectorTest {
	
	public SelectorTest() {
		RunnableSelector rs = new RunnableSelector();
		try {
			rs.init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		
		Thread selectorThread = new Thread(rs);
		selectorThread.start();
	}

}
