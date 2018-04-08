package com.chitkara.ds.graph;

public class Test {

	public static void main(String[] args) {
		UGraph g = new UGraph(6);
		g.addEdge(0, 5);
		g.addEdge(0, 5);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		FindCycle f = new FindCycle(g);
		System.out.println("this graph has cycle = " + f.hasCycle());

	}

}
