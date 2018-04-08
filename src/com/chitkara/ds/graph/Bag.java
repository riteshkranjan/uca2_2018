package com.chitkara.ds.graph;

import java.util.Iterator;

public class Bag implements Iterable<Integer> {
	private Node first;
	private Node last;
	private int size;

	public void add(int i) {
		Node current = last;
		last = new Node(i);
		if (current != null)
			current.next = last;
		if (size == 0)
			first = last;
		size++;
	}

	private class Node {
		private int data;
		private Node next = null;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return new CustomIterator();
	}

	private class CustomIterator implements Iterator<Integer> {
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Integer next() {
			Node d = current;
			current = current.next;
			return d.data;
		}

	}

}
