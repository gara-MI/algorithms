package com.algorithms.euler;

import java.util.Scanner;

public class CountingSummations {

	public static final int MOD = 1000000007;
	public static long[][] coinChange(int n) {
        long [][] a = new long[n+1][n+1];
        for(int i=0;i<=n;i++){
            a[0][i] = 1;
        }
        //a[1][1] = 0;
        for(int i=1;i<=n;i++){
        	for(int j=1;j<=n;j++){
        		int j2 = i-j;
        		long x = j2>=0 ? a[j2][j]:0;
        		long y = j>0?a[i][j-1]:0;
				a[i][j] = (x+y)%(MOD);
        	}
        }
        return a;
	}
	public static void print(long[][] coinChange) {
		int n= coinChange.length;
		for(int i=0;i<n;i++){
			int m = coinChange[i].length;
			for(int j=0;j<m;j++){
				System.out.print(coinChange[i][j]+"\t");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		String s = "abc";
		long[][] coinChange = coinChange(1000);
		while(T-- > 0){
			int n = scan.nextInt();
			
			System.out.println(coinChange[n][n]-1);
		}
	}
}
