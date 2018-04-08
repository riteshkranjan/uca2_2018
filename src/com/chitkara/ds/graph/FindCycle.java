package com.chitkara.ds.graph;

import java.util.HashSet;
import java.util.Set;

public class FindCycle {
	private boolean[] marked;
	private UGraph g;
	private boolean hasCycle = false;

	public boolean hasCycle() {
		return hasCycle;
	}

	public FindCycle(UGraph g) {
		this.g = g;
		marked = new boolean[g.V()];
		hasCycle = checkLoop();
		if (!hasCycle) {
			for (int i = 0; i < g.V(); i++) {
				if (!marked[i]) {
					dfs(i, -1);
				}
			}
		}
	}

	private boolean checkLoop() {
		for (int v = 0; v < g.V(); v++) {
			Set<Integer> vertices = new HashSet<>();
			for (int w : g.adj(v)) {
				// to handle actual cycle
				if (w == v) {
					return true;
				}
				// to handle if 2 edges are present between 2 vertices
				if (vertices.contains(w))
					return true;
				else
					vertices.add(w);
			}
		}
		return false;
	}

	private void dfs(int v, int fromNode) {
		marked[v] = true;
		for (int w : g.adj(v)) {
			if (!marked[w]) {
				dfs(w, v);
			} else if (fromNode != -1 && w != fromNode) {
				hasCycle = true;
			}
		}
	}
}
