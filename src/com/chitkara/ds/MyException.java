package com.chitkara.ds;

public class MyException extends Exception {
	int size;

	public MyException(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String getMessage() {
		return "size of queue is " + size;
	}
}
