package io.github.bissal.messy.test.uncategorized;

public class ThrowExceptionTest {
	
	public ThrowExceptionTest() {
//		try {
//			throwException();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		throwUnsupportedOperationException();
	}
	
	public void throwException() throws Exception {
		throw new Exception(); 
	}
	
	public void throwUnsupportedOperationException() {
		throw new UnsupportedOperationException(); 
	}
}
