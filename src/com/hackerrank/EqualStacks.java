package com.hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class EqualStacks {

	static boolean allEqual(int a, int b, int c) {
		return a==b && b==c;
	}
	
	static int removeFromFirst(int a , int b, Deque<Integer> s) {
		if(a >b && s.size() >0) {
			int r = s.removeLast();
			a -= r;
		}
		return a;
	}
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n1 = in.nextInt();
	        int n2 = in.nextInt();
	        int n3 = in.nextInt();
	        Deque<Integer> s1 = new ArrayDeque<>();
	        Deque<Integer> s2 = new ArrayDeque<>();
	        Deque<Integer> s3 = new ArrayDeque<>();
	        int sum1 =0, sum2 =0, sum3 =0;
	        for(int h1_i=0; h1_i < n1; h1_i++){
	            int a = in.nextInt();
	            s1.push(a);
	            sum1 += a;
	        }
	        for(int h2_i=0; h2_i < n2; h2_i++){
	        	int a = in.nextInt();
	            s2.push(a);
	            sum2 += a;
	        }
	        int h3[] = new int[n3];
	        for(int h3_i=0; h3_i < n3; h3_i++){
	        	int a = in.nextInt();
	            s3.push(a);
	            sum3 += a;
	        }
	        while(!allEqual(sum1, sum2, sum3)) {
	        	sum1 = removeFromFirst(sum1, sum2, s1);
	        	sum1 = removeFromFirst(sum1, sum3, s1);
	        	
	        	sum2 = removeFromFirst(sum2, sum1, s2);
	        	sum2 = removeFromFirst(sum2, sum3, s2);
	        	
	        	sum3 = removeFromFirst(sum3, sum1, s3);
	        	sum3 = removeFromFirst(sum3, sum2, s3);
	        }
	        System.out.println(sum1);
	 }
}
