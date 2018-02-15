package com.hackerrank;

import java.util.Scanner;

public class EqualizeTheArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int [] c = new int[101];
		int temp = n;
		while(temp-- > 0){
			++c[scan.nextInt()];
		}
		int max = 0;
		for (int i = 0; i < c.length; i++) {
			if(max<c[i]){
				max = c[i];
			}
		}
		System.out.println(n-max);
	}
}
