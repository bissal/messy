package dev.foursix.test.concurrent;

import java.util.concurrent.atomic.AtomicLong;

public class AdderUseAtomicLong implements Runnable {
	private AtomicLong value;
	
	public AdderUseAtomicLong() {
		this.value = new AtomicLong(0L);
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000000; i++) {
			add(i);
		}
	}
	
	public void add(int i) {
		value.addAndGet(i);
	}

	public long getValue() {
		return value.get();
	}

	public void setValue(long value) {
		this.value.set(value);
	}
}
