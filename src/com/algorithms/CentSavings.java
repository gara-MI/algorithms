package com.algorithms;

import java.util.Scanner;

public class CentSavings {

	public static int trim(int x){
        int y =x%10;
        if( y>=5){
            x +=10;
        }
        return x-y;
    }
	
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int d = scan.nextInt();
        int [] a = new int[n+1];
        for(int i=1;i<=n;i++){
            a[i] = scan.nextInt();
        }
        int [][]dp = new int[n+1][d+1];
        int ans = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=d;j++){
                if(j==0){
                    dp[i][j] = dp[i-1][j]+a[i];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j]+a[i],trim(dp[i-1][j-1]+a[i]));
                }
            }
        }
        for(int i=0;i<=d;i++){
            ans = Math.min(ans,trim(dp[n-1][i]+a[n]));
        }
        System.out.println(ans);
    }
}
