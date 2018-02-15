package com.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnakesAndLadders {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int [][] cost = new int[101][101];
		while(t-- > 0){
			for(int i=0;i<=100;i++){
				for(int j=0;j<=100;j++){
					cost[i][j]=1;
				}
			}
			Graph graph = new Graph(101);
			int l = scan.nextInt();
			List<Integer> ladders = new ArrayList<>();
			while(l-- > 0){
				int x =scan.nextInt();
				int y = scan.nextInt();
				ladders.add(y);
				cost[x][y]=0;
				graph.addOneDirectionalEdge(x, y);
			}
			int s = scan.nextInt();
			List<Integer> snakes = new ArrayList<>();
			while(s-- > 0){
				int x =scan.nextInt();
				int y = scan.nextInt();
				snakes.add(x);
				cost[x][y]=0;
				graph.addOneDirectionalEdge(x, y);
			}
			for(int i=0;i<=100;i++){
				for(int j=1;j<=6 && (i+j)<=100;j++){
					if(!snakes.contains(i))
						graph.addOneDirectionalEdge(i, i+j);
				}
			}
			BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph);
			breadthFirstSearch.bfs_queue_with_cost(1, cost);
			
			System.out.println(breadthFirstSearch.distance[100]==Integer.MAX_VALUE?-1:breadthFirstSearch.distance[100]);
		}

	}
}
