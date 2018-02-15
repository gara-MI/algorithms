package com.algorithms;

import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/equal
public class Equal {

	public static void main(String[] args) {
		/*
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-- >0){
			int n= scan.nextInt();
			int [] a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = scan.nextInt();
			}
			Arrays.sort(a);
			int count = 0;
			while(a[0] != a[n-1]){
				int diff = a[n-1] - a[0];
				if(diff == 0){
					break;
				}
				else{
					int it =0, inc=0;
					if(diff>=5){
						it = diff/5;
						inc = it*5;
					}
					else if (diff>=2){
						it = diff/2;
						inc = it*2;
					}
					else{
						it = diff;
						inc = diff;
					}
					for (int i = 0; i < a.length-1; i++) {
						a[i] += inc;
					}
					int j= n-1;
					while(j > 0){
						if(a[j]<a[j-1]){
							int temp = a[j];
							a[j]=a[j-1];
							a[j-1]=temp;
							--j;
						}
						else{
							break;
						}
					}
					count += it;
				}
			}
			System.out.println(count);
		}
	*/
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-- >0){
			int n= scan.nextInt();
			int [] a = new int[n];
			int min =Integer.MAX_VALUE;
			for (int i = 0; i < a.length; i++) {
				a[i] = scan.nextInt();
				if(a[i]<min)
					min=a[i];
			}
			int min_itr = Integer.MAX_VALUE;
			for(int j=0;j<=2;j++){
				int m = min-j;
				int count =0;
				for(int i=0;i<n;i++){
					int k = a[i]-m;
					count += k/5;
					count += (k%5)/2;
					count += (k%5)%2;
				}
				if(count<min_itr){
					min_itr = count;
				}
			}
			System.out.println(min_itr);
		}
	}
}
