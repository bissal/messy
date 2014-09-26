package io.github.bissal.messy.test.etc;

import org.junit.Test;

public class HasGirlfriendTest {
	private static Man		you;
	private static Woman	girlFriend;
	private Friends			friends;

	@Test
	public void testHasGirlfriend() {
		
	}
	
	public EventListener onWeekend = new EventListener() {
		@Override
		public void OnWeekend() {
			if (you.hasGirlfriend()) {
				// FIXME 여기가 안 돈다..
				dinner(girlFriend);
			} else {
				drink(friends.remaining());
			}
		}
	}; 
	
	class Man {
		public boolean hasGirlfriend() {
			return false;
		}
		
		public Woman getGirlfriend() {
			// TODO Auto-generated method stub
			return null;
		}

		public Object her() {
			// TODO Auto-generated method stub
			return null;
		}

		public Man[] friends() {
			return null;
		}
	}
	
	class Woman {
		
	}
	
	class Friends {
		public Man[] remaining() {
			return null;
		}
	}
	
	
	interface EventListener {
		public abstract void OnWeekend();
//		public abstract void OnWeekend(Man you);
	}

	protected void drink(Man[] friends) {
		// TODO Auto-generated method stub
		
	}

	protected void dinner(Object her) {
		// TODO Auto-generated method stub
		
	}
}