package com.algorithms;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/candies
public class Candies {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int temp = n;
		int [] a = new int[n];
		int [] b = new int[n];
		b[0] = 1;
		a[0] =  scan.nextInt();
		for (int i = 1; i < a.length; i++) {
			a[i] =  scan.nextInt();
			if(a[i]<=a[i-1]){
				b[i] = 1;
			}
			else{
				b[i] = b[i-1]+1;
			}
		}
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]+" ");
		}
		System.out.println();
		for (int i = n-1; i >=1; --i) {
			if(a[i-1]>a[i]){
				b[i-1] = b[i-1]>b[i]+1?b[i-1]:b[i]+1;
			}
		}
		long sum =0;
		for (int i = 0; i < b.length; i++) {
			sum += b[i];
			System.out.print(b[i]+" ");
		}
		System.out.println(sum);
		
	}
}

