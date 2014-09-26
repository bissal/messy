package dev.foursix.test.actiontype;

import java.util.Arrays;

import org.junit.Test;

public class ActionExam {
	@Test
	public void test() {
		Action action = Action.PUSH;
		System.out.println(action);
		
		action = Action.RELI;
		
		System.out.println(action);
		
		byte[] actionBytes = action.getBytes();
		System.out.println(new String(actionBytes));
		
		System.out.println(Action.AUTH);
		System.out.println(Arrays.toString(Action.AUTH.getBytes()));
	}
}
