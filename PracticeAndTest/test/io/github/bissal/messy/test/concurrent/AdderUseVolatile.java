package io.github.bissal.messy.test.concurrent;

public class AdderUseVolatile implements Runnable {
	private volatile long value;

	@Override
	public void run() {
		for (int i = 0; i < 1000000; i++) {
			add(i);
		}
	}
	
	public void add(int i) {
		setValue(getValue() + i);
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}
}
