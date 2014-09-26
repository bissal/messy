package dev.foursix.test.types;

import java.util.ArrayList;

import org.junit.Test;

public class PassingListTest {
	
//	@Test
//	public void testPassingList() {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("a");
		al.add("b");
		
		accept(al);
	}

//	public void accept(ArrayList<String> al) {
	public static void accept(ArrayList<String> al) {
		for (Object o: al) {
			System.out.println(o);
		}
		
	}
}