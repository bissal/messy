package io.github.bissal.messy.test.uncategorized;

public class LoopContinueTest {
	
	public LoopContinueTest() {
		for (int i = 0; i < 10; i++) {
			if (i < 5) {
				continue;
			}
			if (i % 2 == 0) {
				continue;
			}
			System.out.println(i);
			
		}
	}
}
