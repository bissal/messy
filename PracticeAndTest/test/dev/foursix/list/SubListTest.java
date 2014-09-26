package dev.foursix.list;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class SubListTest {

	@Test
	public void testSubList() {
		List<String> names = new ArrayList<>();
		
		for (int i = 0; i < 3500; i++) {
			names.add(RandomStringUtils.randomAlphanumeric(12));
		}
		
		List<String> sub01 = null;
		List<String> sub02 = null;
		
		if (names.size() > 1000) {
			sub01 = names.subList(0, 1000);
			sub02 = names.subList(1000, names.size());
		}
		
		assertEquals(1000, sub01.size());
		assertEquals(names.size() - 1000, sub02.size());
		
		
//		int i = 0;
//		for (String name : names) {
//			System.out.printf("[%4d]: %s\n", i++, name);
//		}
//		
//		i = 0;
//		for (String name : sub01) {
//			System.out.printf("[%4d]: %s\n", i++, name);
//		}
//		
//		i = 0;
//		for (String name : sub02) {
//			System.out.printf("[%4d]: %s\n", i++, name);
//		}
	}

	@Test
	public void testnSubList() {
		List<String> names = new ArrayList<>();
		
		for (int i = 0; i < 3500; i++) {
			names.add(RandomStringUtils.randomAlphanumeric(12));
		}
		
		List<List<String>> subs = new ArrayList<List<String>>();
		
		int quotient = names.size() / 1000;
		int remainder = names.size() % 1000;
		int nSubs = quotient + 1;
		
		System.out.printf("quotient=%d, remainder=%d, nSubs=%d", quotient, remainder, nSubs);
		
		int size = names.size();
		int offset = 0;
		
		for (int i = 0; i < nSubs; i++) {
			if ((size - offset) > 1000) {
				subs.add(names.subList(offset, offset+=1000));
			} else {
				subs.add(names.subList(offset, size));
			}
		}
		
		for (int i = 0; i < quotient; i++) {
			assertEquals(1000, subs.get(i).size());
		}
		assertEquals(remainder, subs.get(quotient).size());
		
//		int i = 0;
//		for (String name : names) {
//			System.out.printf("[%4d]: %s\n", i++, name);
//		}

//		i = 0;
//		for (List<String> sub : subs) {
//			for (String name : sub) {
//				System.out.printf("[%4d]: %s\n", i++, name);
//			}
//		}
	}
}
