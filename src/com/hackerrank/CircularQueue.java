package com.hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class CircularQueue {

    static class Pos{
        int i;
        long w;
        int c;
        Pos(int i,long w, int c) {
            this.i =i;
            this.w=w;
            this.c=c;
        }
    }
    static int circularWalk(int n, int s, int t, int r_0, int g, int seed, int p){
        // Complete this function
        long [] a = new long[n];
        a[0] = r_0;
        for(int i=1;i<n;i++) {
            a[i] = (a[i-1]*g+seed)%p;
        }
        int [] b = new int[n];
        boolean [] v = new boolean[n];
        v[s]=true;
        Stack<Pos> stack = new Stack<>();
        stack.push(new Pos(s, a[s], 0));
        while(!stack.isEmpty()) {
        	Pos pop = stack.pop();
        	if(pop.w>0 && (n-pop.i-pop.w<=t || pop.i+pop.w>=t) ) {
        		return pop.c+1;
        	}
        	for(int i=1;i<=pop.w;i++) {
        		int k= (i+pop.i)%n;
        		if(!v[k]){
        			if(k==t)
                        return pop.c+1;
        			if(a[k] != 0)
        				stack.push(new Pos(k, a[k], pop.c+1));
        			else
        				v[k]=true;
        		}
        	}
        	for(int i=1;i<=pop.w;i++) {
        		int k= (n+pop.i-i)%n;
        		if(!v[k]) {
        			if(k==t)
                        return pop.c+1;
        			if(a[k] != 0)
        				stack.push(new Pos(k, a[k], pop.c+1));
        			else
        				v[k]=true;
        		}
        	}
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nt=9;
        int ii=0;
//        System.out.println((nt-ii)%nt);
        int n = in.nextInt();
        int s = in.nextInt();
        int t = in.nextInt();
        int r_0 = in.nextInt();
        int g = in.nextInt();
        int seed = in.nextInt();
        int p = in.nextInt();
        int result = circularWalk(n, s, t, r_0, g, seed, p);
        System.out.println(result);
    }
}
