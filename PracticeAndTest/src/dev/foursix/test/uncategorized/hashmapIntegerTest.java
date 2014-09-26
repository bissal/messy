package dev.foursix.test.uncategorized;
import java.util.HashMap;
import java.util.Map;


public class hashmapIntegerTest {
	
	public hashmapIntegerTest() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(44, "44");
		map.put(55, "55");
		
		System.out.println(map.containsKey(new Integer(44)));	
	}

}
