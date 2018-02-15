package com.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumLoss {

	public static class Loss{
        public long cost;
        public int i;
        
        public Loss(int i, long cost) {
        	this.i=i;
        	this.cost=cost;
		}
    }
	
	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);
		int n = r.nextInt();
		Loss [] l = new Loss[n];
		for (int i = 0; i < l.length; i++) {
			l[i]=new Loss(i,r.nextLong());
		}
		Arrays.sort(l, (left, right)->{
			if((left.cost) > (right.cost))
				return 1;
			else
				return -1;
		});
		
		long min = Long.MAX_VALUE;
		for (int i = 0; i < l.length-1; i++) {
			if(l[i].i>l[i+1].i){
				long m = l[i+1].cost-l[i].cost;
				if(min> m){
					min = m;
				}
			}
		}
		System.out.println(min);
	}
}
