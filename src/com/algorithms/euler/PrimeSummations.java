package com.algorithms.euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeSummations {

	public static final int [] primeSummations = new int[1001]; 
	public static void simpleSieve(int n, List prime) {
		boolean [] num = new boolean[n+1];
		for(int i=2;i<=n;i++) {
			if(!num[i]){
				prime.add(i);
				for(int j=i*2;j<=n;j+=i) {
					num[j] = true;
				}
			}
		}
	}
	
	public static int coinChange(int n, Integer[] prime, int m) {
		if(n==0) return 1;
		if(n<0||m<=0) return 0;
		if(m<=0 && n>0) return 0;
		return coinChange(n,prime,m-1)+coinChange(n-prime[m-1],prime,m);
	}
	public static long[][] coinChange(int n, Integer[] prime) {
        int m = prime.length;
        long [][] a = new long[n+1][m];
        for(int i=0;i<m;i++){
            a[0][i] = 1;
        }
        for(int i=1;i<=n;i++){
        	for(int j=0;j<m;j++){
        		int j2 = i-prime[j];
        		long x = j2>=0 ? a[j2][j]:0;
        		long y = j>0?a[i][j-1]:0;
				a[i][j] = x+y;
        	}
        }
        return a;
	}
	
	public static void main(String[] args) {
		List<Integer> primes = new ArrayList<>();
		simpleSieve(1000, primes);
		Integer[] prime = primes.toArray(new Integer[primes.size()]);
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		long[][] coinChange = coinChange(1000, prime);
		while(T-- > 0){
			int n = scan.nextInt();
			System.out.println(coinChange[n][prime.length-1]);
		}
	}
}
