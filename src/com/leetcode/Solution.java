package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static int listSize(ListNode head) {
	    int size = 0;
        ListNode curr = head;
        while(curr != null) {
            size++;
            curr=curr.next;
        }
        return size;
	}
	
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head; 
        ListNode prev = null;
        while (fast != null && fast.next != null) {
        	prev =slow;
        	slow = slow.next;
        	fast = fast.next.next;
        }
        prev.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return mergeTwoLists(left, right);
    }
	
	public ListNode mergeTwoLists (ListNode A ,ListNode B) {
		ListNode root;
		if(A==null) return B;
		if(B==null) return A;
		if(A.val <B.val) {
			root= A;
			A=A.next;
		}
		else {
			root= B;
			B=B.next;
		}
		ListNode tail = root;
		while (A != null && B!= null) {
			if(A.val <B.val) {
				tail.next= A;
				A=A.next;
				tail = tail.next;
			}
			else {
				tail.next= B;
				B=B.next;
				tail = tail.next;
			}
		}
		if(A == null) {
			tail.next = B;
		}
		else if (B == null) {
			tail.next = A;
		}
		return root;
	}
    public ListNode mergeKLists(List<ListNode> lists) {
    	final ListNode root = new ListNode(0);
    	ListNode tail = root;
    	final Queue <ListNode> pq = new PriorityQueue<>((a,b)->{if(a.val != b.val) return a.val-b.val; else return 0;});
    	for( final ListNode node:lists) {
    		if(node != null)
    			pq.add(node);
    	}
    	while(!pq.isEmpty()) {
    		final ListNode poll = pq.poll();
    		tail.next = poll;
    		if(poll.next != null)
    			pq.add(poll.next);
    		tail = poll;
    		tail.next= null;
    	}
    	return root.next;
    }
    

    public int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int m2=0,m3=0,m5=0;
        for(int i=1;i<n;i++) {
        	int min = Math.min(Math.min(list.get(m2)*2, list.get(m3)*3),list.get(m5)*5);
        	list.add(min);
        	if(list.get(i)==list.get(m2)*2) {
        		m2++;
        	}
        	if(list.get(i)==list.get(m3)*3) {
        		m3++;
        	}
        	if(list.get(i)==list.get(m5)*5) {
        		m5++;
        	}
        }
        return list.get(n-1);
    }
    
    public boolean recursiveWordSearch(char[][] board, char [] word, int x, int y, int n) {
    	if(n==word.length) return true;
    	if(x<0||y<0||x == board.length||y == board[x].length||word[n] != board[x][y]) return false;
    	char ch  = board[x][y];
    	board[x][y] = '\0';
    	boolean found = recursiveWordSearch(board,word,x+1,y,n+1)||recursiveWordSearch(board,word,x-1,y, n+1)
    			||recursiveWordSearch(board,word,x,y-1, n+1)||recursiveWordSearch(board,word,x,y+1, n+1);
    	board[x][y] = ch;
    	return found;
    }
    public boolean exist(char[][] board, String word) {
    	int i=0;
    	for(int j=0;j<board.length;j++) {
    		for(int k=0;k<board[j].length;k++) {
    			if(recursiveWordSearch(board, word.toCharArray(), j, k, 0))
    				return true;
    		}
    	}
        return false;
    }
    public List<String> findWords(char[][] board, String[] words) {
    	List<String> list = new ArrayList<>();
    	for(int i=0;i<words.length;i++) {
    		if(exist(board, words[i])) {
    			list.add(words[i]);
    		}
    	}
    	return list;
    }
    
    
    public static void main(String[] args) {
		Solution s = new Solution();
		for (int i = 1; i < 1690; i++) {
			System.out.println(s.nthUglyNumber(i));
		}
		
	}
}
