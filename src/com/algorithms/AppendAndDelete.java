package com.algorithms;

import java.util.Scanner;

public class AppendAndDelete {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String t = in.next();
		int k = in.nextInt();
		int slen = s.length();
		int tlen = t.length();
		if((k>=slen+tlen)) {
			System.out.println("Yes");
		}
		else if(k<Math.abs(tlen-slen) ) {
			System.out.println("No");
		}
		else {
			int d = -1;
			for(int i=0;i<slen && i<tlen;i++) {
				if(s.charAt(i)!=t.charAt(i)) {
					d=i;
					break;
				}
			}
			if(d==-1) {
				if(slen==tlen && (k>=slen||k%2==0)) {
					System.out.println("Yes");
				}
				else{
					 int toAppend =  Math.abs(slen-tlen);
					 if((k-toAppend)%2==0){
						 System.out.println("Yes");
					 }
					 else{
						 System.out.println("No");
					 }
				}
			}
			else{
				int toDelete = slen-d;
				int toAppend = tlen-d;
				if(toAppend+toDelete <=k && (toDelete == slen || (k-toAppend-toDelete)%2==0)){
					System.out.println("Yes");
				}
				else{
					System.out.println("No");
				}
			}
		}
	}
}
