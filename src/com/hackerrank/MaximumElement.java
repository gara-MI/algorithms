package com.hackerrank;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();
        int N =scan.nextInt();
        int max=-1;
        while(N-->0) {
        	int a=scan.nextInt();
        	if(a==1){
        		int x=scan.nextInt();
        		stack.push(x);
        		if(max<x) {
        			max = x;
        		}
        	}
        	else if (a==3) {
        		System.out.println(max);
        	}
        	else {
        		System.out.println(stack.size());
        		int n = stack.remove();
        		if(max==n) {
        			if(stack.size() != 0)
        				max = Collections.max(stack);
        			else{
        				max = -1;
        			}
        		}
        	}
        	
        }
    }
}
