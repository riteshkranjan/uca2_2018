package com.chitkara.ds;

public class BST<K extends Comparable<K>, V> {
	private Node root;
	
	public void insert(K key, V value) {
		root = insert(root, key, value);
	}
	
	private Node insert(Node n, K key, V value) {
		if(n==null) return new Node(key,value);
		int cmp = n.key.compareTo(key);
		if(cmp==0) n.value = value;
		else if(cmp>0) n.left = insert(n.left, key, value);
		else n.right = insert(n.right, key, value);
		return n;
	}
	
	public void inorder() {
		inorder(root);
	}
	
	private void inorder(Node n) {
		if(n==null) return;
		inorder(n.left);
		System.out.println(n.key + " : "+n.value);
		inorder(n.right);
	}
	
	private class Node{
		private K key;
		private V value;
		private Node left;
		private Node right;
		public Node(K key, V value) {
			this.key=key;
			this.value=value;
			this.left = null;
			this.right = null;
		}
	}

}
