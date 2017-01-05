package com.algorithms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Graph {
	private final List<Integer> [] adjList;
	private final int V;
	public Graph(){
		this(0);
	}
	public Graph(int V){
		this.V = V;
		this.adjList= new ArrayList[V+1];
		for(int i=0;i<=V;i++){
			getAdjList()[i] = new ArrayList<>();
		}
		
	}
	
	public void addVertex(int V, int W){
		getAdjList()[V].add(W);
		getAdjList()[W].add(V);
	}
	
	public void printGraph(){
		for (int i = 0; i < getAdjList().length; i++) {
			System.out.print(i+": ");
			for (final Iterator iterator = this.getAdjList()[i].iterator(); iterator.hasNext();) {
				Integer integer = (Integer) iterator.next();
				System.out.print(integer+" ");
			}
			System.out.println();
		}
	}

	public static Graph readGraph() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(bf.readLine());
		Graph g = new Graph(V);
		
		int E = Integer.parseInt(bf.readLine());
		while(E-- > 0){
			final String[] split = bf.readLine().split(" ");
			int v = Integer.parseInt(split[0]);
			int w = Integer.parseInt(split[1]);
			g.addVertex(v, w);
		}
		//g.printGraph();
		return g;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(bf.readLine());
		Graph g = new Graph(V);
		
		int E = Integer.parseInt(bf.readLine());
		while(E-- > 0){
			final String[] split = bf.readLine().split(" ");
			int v = Integer.parseInt(split[0]);
			int w = Integer.parseInt(split[1]);
			g.addVertex(v, w);
		}
		g.printGraph();
	}
	public int getV() {
		return V;
	}
	public List<Integer> [] getAdjList() {
		return adjList;
	}
}
