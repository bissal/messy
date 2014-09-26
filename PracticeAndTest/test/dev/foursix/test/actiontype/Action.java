package dev.foursix.test.actiontype;

public enum Action {
	AUTH, BYEC, KEEP, HEAD, PUSH, ADDF, DELF, DATA, TYPE, RELI, REQD, RECT, SNDG, SNDR;
	
	public byte[] getBytes() {
		return this.toString().getBytes();
	}
	
	public char[] toCharArray() {
		return this.toString().toCharArray();
	}
}
