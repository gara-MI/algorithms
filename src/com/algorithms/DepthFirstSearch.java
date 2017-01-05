package com.algorithms;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

public class DepthFirstSearch {
	final boolean [] discovered;
	int count;
	int[] edgeTo;
	Graph graph;
	public DepthFirstSearch(Graph g){
		count =0;
		discovered = new boolean [g.getV()+1];
		this.graph = g;
		edgeTo = new int[g.getV()+1];
	}
	public void dfs_rec(int pos){
		System.out.print(pos+" ");
		count++;
		this.discovered[pos]=true;
		for(int w : this.graph.getAdjList()[pos]){
			if(!discovered[w]){
				dfs_rec(w);
			}
		}
	}
	public void dfs_stack(int pos){
		Stack<Integer> s = new Stack<>();
		s.push(pos);
		this.discovered[pos]=true;
		edgeTo[pos] = pos;
		while(!s.isEmpty()){
			Integer v = s.pop();
			System.out.print(v+" ");
			this.count++;
			Iterator<Integer> iterator = graph.getAdjList()[v].iterator();
			while(iterator.hasNext()){
				Integer w = iterator.next();
				if(!this.discovered[w]){
					s.push(w);
					this.discovered[w]=true;
					edgeTo[w] = v;
				}
			}
			
		}
		System.out.println();
		System.out.println("count: "+count);
	}
	
	public boolean hasPathTo(int w){
		return discovered[w];
	}
	
	public Stack<Integer> pathTo(int start, int end){
		Stack<Integer> s = new Stack<>();
		s.push(end);
		while(edgeTo[end] != start){
			s.push(edgeTo[end]);
			end = edgeTo[end]; 
		}
		s.push(edgeTo[end]);
		return s;
	}
	
	public void reset(){
		this.count = 0;
		for(int i=0;i<this.discovered.length;++i){
			this.discovered[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		Graph graph = Graph.readGraph();
		DepthFirstSearch dfs = new DepthFirstSearch(graph);
		int start = 0;
		dfs.dfs_stack(start);
		for (int i = 0; i < dfs.edgeTo.length; i++) {
			System.out.print(dfs.edgeTo[i]+" ");
		}
		System.out.println();
		for(int i=0;i<=graph.getV();++i){
			if(dfs.hasPathTo(i)){
				System.out.print(start+" to "+i+":");
				Stack<Integer> pathTo = dfs.pathTo(start, i);
				while(!pathTo.isEmpty()){
					System.out.print(pathTo.pop()+" ");
				}
				System.out.println();
			}
		}
		//dfs.reset();
		//dfs.dfs_rec(0);
		System.out.println();
		System.out.println(dfs.count);
	}
}
