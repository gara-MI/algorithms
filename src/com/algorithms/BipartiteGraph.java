package com.algorithms;

import java.io.IOException;
import java.util.Stack;

public class BipartiteGraph {

	final Graph graph;
	final boolean [] color;
	private Stack<Integer> cycle;
	boolean isBipartiteGraph = true;
	public BipartiteGraph(Graph graph) {
		// TODO Auto-generated constructor stub
		this.graph = graph;
		color = new boolean[graph.V+1];
		dfs(0);
		assert check();
	}

	public void dfs(int v){
		graph.visited[v] = true;
		for(int w:graph.adjList[v]){
			if(null != cycle) return;
			if(!graph.visited[w]){
				graph.edgeTo[w]=v;
				dfs(w);
			}
			else if(color[w]==color[v]){
				isBipartiteGraph = false;
				cycle = new Stack<>();
				for(int x=v; x!=w;x=graph.edgeTo[v]){
					cycle.push(x);
				}
				cycle.push(w);
			}
		}
	}

	boolean check() {
		if(isBipartiteGraph){
			for(int i=0;i<=graph.V;++i){
				for(int w:graph.adjList[i]){
					if(color[i] == color[w]){
						System.out.println("Error: This grpah is not Bipartite as edges have the same color: "+i+" "+w);
						return false;
					}
				}
			}
		}
		else{
			int first = -1, last = -1;
			for (int v : cycle) {
				if (first == -1) first = v;
				last = v;
			}
			if(first != last){
				System.out.printf("Cycle begins with %d and ends with %d ",first,last);
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		try {
			Graph graph = Graph.readGraph();
			BipartiteGraph bipartiteGraph = new BipartiteGraph(graph);
			System.out.println(bipartiteGraph.isBipartiteGraph);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
