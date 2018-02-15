package com.hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class GameofTwoStacks {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        Deque<Integer> a = new ArrayDeque<>();
        Deque<Integer> b = new ArrayDeque<>();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int c;
            for(int a_i=0; a_i < n; a_i++){
                c = in.nextInt();
                a.push(c);
            }
            for(int b_i=0; b_i < m; b_i++){
                c = in.nextInt();
                b.push(c);
            }
            int count  = 0;
            while(x > 0 && !(a.isEmpty() && b.isEmpty())) {
            	
            	int n1 = a.peekLast();
            	int n2 = b.peekLast();
            	if(n1>n2) {
            		if(!b.isEmpty()){
            			b.removeLast();
            			x -= n2;
            			++count;
            		}
            	}
            	else{
            		if(!a.isEmpty()){
            			a.removeLast();
            			x -= n1;
            			++count;
            		}
            	}
            }
            if(x<0) {
            	--count;
            }
            System.out.println(count);
            // your code goes here
        }
    }
	
}
