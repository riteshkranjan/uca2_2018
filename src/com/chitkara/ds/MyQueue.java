package com.chitkara.ds;

public interface MyQueue<T> extends Iterable<T> {

	public void push(T i) throws MyException;

	public T pop() throws MyException;

	public T peek() throws MyException;

	public int size();

}
