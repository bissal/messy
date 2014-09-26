package io.github.bissal.messy.test.uncategorized;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class EntrySetTest {
	public EntrySetTest() {
		Map<String, String> map = new HashMap<String, String>();
		
		for (Entry<?, ?> entry : map.entrySet()) {
			entry.getKey();
			entry.getValue();
		}
	}
}
