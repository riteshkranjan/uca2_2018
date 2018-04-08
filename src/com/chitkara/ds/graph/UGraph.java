package com.chitkara.ds.graph;

public class UGraph {

	private int v;
	private Bag[] adj;
	private int e;

	public UGraph(int v) {
		this.v = v;
		adj = new Bag[v];
		for (int i = 0; i < v; i++)
			adj[i] = new Bag();
	}
	
	public int V() {
		return v;
	}
	
	public int E() {
		return e;
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		e++;
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
}
