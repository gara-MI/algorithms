package com.algorithms;

import java.util.Scanner;

public class Trie {

	public static class Node {
		int count;
		Node [] children;
		public Node() {
			count = 0;
			children = new Node[26];
			for(int i=0;i<children.length;i++) {
				children[i] = null;
			}
		}
		public void insert(Node current, String s) {
			for( char c:s.toCharArray()) {
				int index = (int)(c-'a');
				if(current.children[index]==null) {
					current.children[index]=new Node();
				}
				current.children[index].count++;
				current = current.children[index];
			}
		}

	}

	public static void main(String[] args) {
		Node trie = new Node();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		while(n-->0) {
			String op = scan.next();
			String val = scan.next();
			if(op.equals("add")){
				trie.insert(trie, val);
			}
			else{
				Node current = trie;
				for(char c:val.toCharArray()) {
					int index = (int)(c-'a');
					current = current.children[index];
					if(null == current) {
						break;

					}
				}
				System.out.println(null == current?0:current.count);
			}
		}
	}
}
