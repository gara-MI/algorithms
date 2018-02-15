package com.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Mathmatics {

	public static int gcd(int a, int b) {
		if(a==0) return b;
		else if(b==0) return a;
		
		int r = a%b;
		while(r != 0) {
			a = b;
			b = r;
			r = a%b;
		}
		return b;
	}
	
	public static List<Integer> primeFactorsList(int n) {
		List<Integer> a = new ArrayList<>();
		while(n%2 == 0) {
			n=n/2;
			a.add(2);
		}
		int sqrt = (int)Math.sqrt(n);
		for(int i=3;i<sqrt;i++) {
			while(n%i==0) {
				a.add(i);
				n = n/i;
			}
		}
		if(n>2) {
			a.add(n);
		}
		return a;
	}
	
	public static List<Integer> printPrimeFactors(int n) {
		List<Integer> a = new ArrayList<>();
		while(n%2 == 0) {
			n=n/2;
			a.add(2);
			System.out.print("2 ");
		}
		int sqrt = (int)Math.sqrt(n);
		for(int i=3;i<sqrt;i++) {
			while(n%i==0) {
				a.add(i);
				n = n/i;
				System.out.print(i+" ");
			}
		}
		if(n>2) {
			a.add(n);
			System.out.print(n+" ");
		}
		return a;
	}
	
	public static int lcm(int a, int b) {
		if(a==0||b==0) return 0;
		return (a*b)/gcd(a,b);
	}
	
	public static int lcm(int [] a) {
		int ans = a[0];
		for (int i = 1; i < a.length; i++) {
			ans = lcm(ans,a[i]);
		}
		return ans;
	}
	
	public static int gcd(int [] a) {
		int ans = a[0];
		for (int i = 1; i < a.length; i++) {
			ans = gcd(ans,a[i]);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(gcd(21,33));
		System.out.println(lcm(21,33));
		int [] a= {2, 7, 3, 9, 4};
		System.out.println(lcm(a));
		int [] b = {2, 4, 6, 8, 16};
		System.out.println(gcd(b));
		printPrimeFactors(10323);
	}
}
