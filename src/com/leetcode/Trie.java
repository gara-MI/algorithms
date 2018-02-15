package com.leetcode;

public class Trie {
	static class TrieNode {
		public TrieNode[] children = new TrieNode[26];
	    public String item = "";
	    public TrieNode() {
	    }
	}
	private TrieNode root;
	public Trie() {
		root = new TrieNode();
	}
	
	void insert(String word) {
		TrieNode curr = root; 
		for(char c: word.toCharArray()) {
			int ch = c-'a';
			if(curr.children[ch] == null) {
				curr.children[ch] = new TrieNode();
			}
			curr = curr.children[ch];
		}
		curr.item = word;
	}
	
	public boolean search(String word) {
		TrieNode curr = root; 
		for(char c: word.toCharArray()) {
			int ch = c-'a';
			if(curr.children[ch] == null) return false;
			curr = curr.children[ch];
		}
		return curr.item.equals(word);
	}
	public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(cur.children[c-'a'] == null) return false;
            cur = cur.children[c-'a'];
        }
        return true;
    }

}
