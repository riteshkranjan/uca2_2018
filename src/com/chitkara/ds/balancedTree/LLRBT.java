package com.chitkara.ds.balancedTree;
public class LLRBT<K extends Comparable, V> {
	
	private Node root;
	private boolean RED = false;
	private boolean BLACK = true;
	
	public V get(K k){
		Node n =  get(root, k);
		if(n==null){
			System.out.println("Not found");
			return null;
			
		}else{
			return n.v;
		}
	}
	
	private Node get(Node n, K k){
		if(n==null) return null;
		int cmp = n.k.compareTo(k);
		if(cmp == 0) return n;
		else if(cmp == +1) return get(n.left, k);
		else return get(n.right, k);
		
	}
	
	public void insert(K k, V v){
		root = insert(root, k, v);
		root.color = BLACK;
	}
	
	public Node insert(Node n, K k, V v){
		if(n==null) return new Node(k,v);
		int cmp = n.k.compareTo(k);
		if(cmp == 0) n.v = v;
		else if(cmp == +1) n.left = insert(n.left, k, v);
		else n.right = insert(n.right, k ,v);
		
		if(colorOf(n.right) == RED && colorOf(n.left) == BLACK) 
			n = leftRotate(n);
		if(colorOf(n.left) == RED && colorOf(n.left.left) == RED)
			n = rightRotate(n);
		if(colorOf(n.left) == RED && colorOf(n.right) == RED)
			n = flipColor(n);
		return n;
	}
	
	private Node leftRotate(Node h){
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}
	
	private Node rightRotate(Node h){
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}
	private Node flipColor(Node h){
		h.left.color = h.color;
		h.right.color = h.color;
		h.color = RED;
		return h;
	}
	
	
	
	private boolean colorOf(Node n){
		if(n==null) return BLACK;
		return n.color;
	}
	
	private class Node{
		private K k;
		private V v;
		private Node left;
		private Node right;
		private boolean color;
		
	   public Node(K k, V v){
			this.k = k;
			this.v = v;
			this.left = null;
			this.right = null;
			this.color = RED;		   
		}
	}	
}