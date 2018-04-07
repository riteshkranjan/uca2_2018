package com.chitkara.ds;

import java.io.Serializable;
import java.util.Iterator;

public class StaticArrayQueue<T extends Serializable> implements MyQueue<T>, Iterable<T> {
	private T[] a = (T[])new Object[10];
	private int tail = 0;
	private int head = 0;
	private int size = 0;

	@Override
	public void push(T i) throws MyException{
		if (size() == 10)
			throw new MyException(size());
		a[head++] = i;
		if (head == size())
			head = 0;
		size++;

	}

	@Override
	public T pop() throws MyException {
		checkForUnderFlow();
		T result = a[tail--];
		if (tail == size())
			tail = 0;
		size--;
		return result;
	}

	@Override
	public T peek() throws MyException {
		checkForUnderFlow();
		return a[tail];
	}

	private void checkForUnderFlow() throws MyException {
		if (size == 0)
			throw new MyException(0);;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int iteratorTail = tail;
			private int iteratorSize = size;

			@Override
			public boolean hasNext() {
				return iteratorSize != 0;
			}

			@Override
			public T next() {
				T result = a[iteratorTail++];
				if (iteratorTail == 10)
					iteratorTail = 0;
				iteratorSize--;
				return result;
			}
		};
	}

}
