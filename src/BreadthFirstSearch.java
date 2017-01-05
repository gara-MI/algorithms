import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearch {
	public final static int INFINITY = Integer.MAX_VALUE; 
	private final boolean [] discovered;
	private int[] edgeTo;
	private int[] distance;
	private int count;
	private Graph graph;
	public BreadthFirstSearch(Graph g){
		count =0;
		discovered = new boolean [g.getV()];
		this.graph = g;
		edgeTo = new int[g.getV()];
		distance = new int[g.getV()];
		for(int i=0;i<=g.getV();++i){
			distance[i] = INFINITY;
		}
	}
	public void bfs_queue(int start){
		Queue<Integer> queue = new ArrayDeque();
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
		System.out.println();
		System.out.println(dfs.count);
	}
}
