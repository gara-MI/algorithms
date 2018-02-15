package com.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SegmentedSieve {

	public static void simpleSieve(int n, List prime) {
		boolean [] num = new boolean[n+1];
		for(int i=2;i<=n;i++) {
			if(!num[i]){
				prime.add(i);
				System.out.println(i);
				for(int j=i*2;j<=n;j+=i) {
					num[j] = true;
				}
			}
		}
	}
	
	public static int segmentedSieve(long first, long last, List<Integer> prime) {
		int diff = (int) (last-first+1);
		long k,mod,s;
		int count =0;
		boolean [] p = new boolean[diff];
		for (int i = 0; i < prime.size(); i++) {
			k =prime.get(i);
			mod = first%k;
			s = mod==0?first:first-mod+k;
			for(long j=s;j<=last;j+=k) {
				p[(int) (j-first)]=true;
			}
		}
		for(int i=0;i<diff;i++) {
			if(!p[i]){
				//System.out.print(first+i+" ");
				if(isPrimeDigit(first+i)) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static boolean isPrimeD(long d) {
        if(d==1||d==4||d==6||d==8||d==9||d==0)
            return false;
        return true;
    }
	public static boolean isPrimeDigit(long n) {
        while(n != 0 ){
            long d =(n%10);
            if(!isPrimeD(d)){
                return false;
            }
            n=n/10;
        }
        return true;
    }
	
	public static void segmentedSieve(long first, long last) {
		int n = (int) (Math.floor(Math.sqrt(last))+1);
		ArrayList<Integer> prime = new ArrayList<>();
		simpleSieve(n, prime);
		int diff = (int) (last-first+1);
		long k,mod,s;
		int count =0;
		boolean [] p = new boolean[diff];
		for (int i = 0; i < prime.size(); i++) {
			k =prime.get(i);
			mod = first%k;
			s = mod==0?first:first-mod+k;
			for(long j=s;j<=last;j+=k) {
				p[(int) (j-first)]=true;
			}
		}
		for(int i=0;i<diff;i++) {
			if(!p[i]){
				//System.out.print(first+i+" ");
				if(isPrimeDigit(first+i)) {
					count++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int first = scan.nextInt();
		int last = scan.nextInt();
		segmentedSieve(first, last);
		
	}
}
