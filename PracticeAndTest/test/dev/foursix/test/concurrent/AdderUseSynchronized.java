package dev.foursix.test.concurrent;

public class AdderUseSynchronized implements Runnable {
	private long value;

	@Override
	public void run() {
		for (int i = 0; i < 1000000; i++) {
			add(i);
		}
	}
	
	public synchronized void add(int i) {
		setValue(getValue() + i);
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}
}
