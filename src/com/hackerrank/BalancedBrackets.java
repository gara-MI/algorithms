package com.hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedBrackets {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			String s = in.next();
			Deque<Character> stack = new ArrayDeque<>();
			char ch;
			boolean flag= false;
			for(char c:s.toCharArray()) {
				if(flag)
					break;
				switch(c) {
				case ')':
					if(stack.size() ==0){
						flag=true;
					}
					else{
						ch = stack.remove();
						if(ch != '(') {
							flag=true;
						}
					}
					break;
				case ']':
					if(stack.size() ==0){
						flag=true;
					}
					else{
						ch = stack.remove();
						if(ch!='[') {
							flag=true;
						}
					}
					break;
				case '}':
					if(stack.size() ==0){
						flag=true;
					}
					else{
						ch = stack.remove();
						if(ch!='{') {
							flag=true;
						}
					}
					break;
				default:
					stack.push(c);
					break;
				}
			}
			if(!flag && stack.size()==0)
				System.out.println("YES");
			else{
				System.out.println("NO");
			}
		}
	}

}
