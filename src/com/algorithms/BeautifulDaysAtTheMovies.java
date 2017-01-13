package com.algorithms;

import java.util.Scanner;

public class BeautifulDaysAtTheMovies {

	public static int reverse(int x){
		int y=0;
		while(x!=0){
			y=y*10+x%10;
			x=x/10;
		}
		return y;

	}
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int k = scan.nextInt();

		int count = 0;
		for(int x=n;x<=m;++x){
			if(Math.abs(x-reverse(x))%k==0){
				count++;
			}
		}
		System.out.println(count);
	}
}
