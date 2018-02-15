package com.algorithms;

import java.util.Scanner;

public class NoPrefixSet {


	public static class Node {
		boolean count;
		Node [] children;
		public Node() {
			count = false;
			children = new Node[26];
			for(int i=0;i<children.length;i++) {
				children[i] = null;
			}
		}
		public boolean insert(Node current, String s) {
			boolean flag = false;
			for( char c:s.toCharArray()) {
				int index = (int)(c-'a');
				if(current.children[index]==null) {
					current.children[index]=new Node();
					 flag=true;
				}
				//current.children[index].count++;
				if(current.children[index].count){
					System.out.println("BAD SET");
					System.out.println(s);
					return false;
				}
				current = current.children[index];
			}
			if(!flag){
				System.out.println("BAD SET");
				System.out.println(s);
				return false;
			}
			current.count=true;
			return true;
		}

	}

	public static void main(String[] args) {
		Node trie = new Node();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		while(n-->0) {
			String op = scan.next();
			if(!trie.insert(trie, op)){
				return;
			}
		}
		System.out.println("GOOD SET");
		
	}
}
