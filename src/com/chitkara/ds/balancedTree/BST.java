package com.chitkara.ds.balancedTree;
public class BST<K extends Comparable, V> {
	
	private Node root;
	
	
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
	}
	
	public Node insert(Node n, K k, V v){
		if(n==null) return new Node(k,v);
		int cmp = n.k.compareTo(k);
		if(cmp == 0) n.v = v;
		else if(cmp == +1) n.left = insert(n.left, k, v);
		else n.right = insert(n.right, k ,v);
		return n;
	}
	
	private class Node{
		private K k;
		private V v;
		private Node left;
		private Node right;
		
	   public Node(K k, V v){
			this.k = k;
			this.v = v;
			this.left = null;
			this.right = null;
		}
	}	
}