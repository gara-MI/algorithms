package com.algorithms;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearch {
	public final static int INFINITY = Integer.MAX_VALUE; 
	final boolean [] discovered;
	int[] edgeTo;
	int[] distance;
	int count;
	Graph graph;
	public BreadthFirstSearch(Graph g){
		count =0;
		discovered = new boolean [g.getV()+1];
		this.graph = g;
		edgeTo = new int[g.getV()+1];
		distance = new int[g.getV()+1];
		for(int i=0;i<=g.getV();++i){
			distance[i] = INFINITY;
		}
	}
	public void bfs_queue(int start){
		Queue<Integer> queue = new ArrayDeque();
		distance[start] = 0;
		queue.offer(start);
		this.discovered[start]=true;
		edgeTo[start] = start;
		while(!queue.isEmpty()){
			Integer v = queue.remove();
			System.out.print(v+" ");
			this.count++;
			Iterator<Integer> iterator = graph.getAdjList()[v].iterator();
			while(iterator.hasNext()){
				Integer w = iterator.next();
				if(!this.discovered[w]){
					queue.offer(w);
					this.discovered[w]=true;
					edgeTo[w] = v;
				}
			}

		}
		System.out.println();
		System.out.println("count: "+count);
	}

	public void bfs_queue_minimum_cost(int start){
		Queue<Integer> queue = new ArrayDeque();
		distance[start] = 0;
		queue.offer(start);
		this.discovered[start]=true;
		edgeTo[start] = start;
		while(!queue.isEmpty()){
			Integer v = queue.remove();
			System.out.print(v+" ");
			this.count++;
			Iterator<Integer> iterator = graph.getAdjList()[v].iterator();
			while(iterator.hasNext()){
				Integer w = iterator.next();
				if(this.distance[w]==INFINITY){
					queue.offer(w);
					this.discovered[w]=true;
					edgeTo[w] = v;
					this.distance[w] = this.distance[v]+1;
				}
				else if(this.distance[w] > this.distance[v]+1){
					edgeTo[w] = v;
					this.distance[w] = this.distance[v]+1;
				}
			}
		}
		System.out.println();
		System.out.println("count: "+count);
	}


	public void bfs_queue_with_ladder(int start, List<Integer> ladder, List<Integer> snakes){
		Queue<Integer> queue = new ArrayDeque();
		distance[start] = 0;
		queue.offer(start);
		this.discovered[start]=true;
		edgeTo[start] = start;
		while(!queue.isEmpty()){
			Integer v = queue.remove();
			//System.out.print(v+" ");
			this.count++;
			Iterator<Integer> iterator = graph.getAdjList()[v].iterator();
			while(iterator.hasNext()){
				Integer w = iterator.next();
				if(this.distance[w]==INFINITY){
					queue.offer(w);
					this.discovered[w]=true;
					edgeTo[w] = v;
					if(ladder.contains(w)||snakes.contains(w)){
						this.distance[w] = this.distance[v];
					}
					else{
						this.distance[w] = this.distance[v]+1;
					}
				}
				else if(this.distance[w] > this.distance[v]+1){
					edgeTo[w] = v;
					this.distance[w] = this.distance[v]+1;
				}
			}

		}
		//System.out.println();
		System.out.println("count: "+count);
	}
	
	public void bfs_queue_with_cost(int start, int[][]cost){
		Queue<Integer> queue = new ArrayDeque();
		distance[start] = 0;
		queue.offer(start);
		this.discovered[start]=true;
		edgeTo[start] = start;
		while(!queue.isEmpty()){
			Integer v = queue.remove();
			//System.out.print(v+" ");
			this.count++;
			Iterator<Integer> iterator = graph.getAdjList()[v].iterator();
			while(iterator.hasNext()){
				Integer w = iterator.next();
				if(this.distance[w]==INFINITY){
					queue.offer(w);
					this.discovered[w]=true;
					edgeTo[w] = v;
					this.distance[w] = this.distance[v]+cost[v][w];
				}
				else if(this.distance[w] > this.distance[v]+cost[v][w]){
					edgeTo[w] = v;
					this.distance[w] = this.distance[v]+cost[v][w];
				}
			}

		}
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
		BreadthFirstSearch dfs = new BreadthFirstSearch(graph);
		int start = 0;
		dfs.bfs_queue(start);
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
//		System.out.println();
//		System.out.println(dfs.count);
	}
}
