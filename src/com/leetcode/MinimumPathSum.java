package com.leetcode;

import java.util.Arrays;

public class MinimumPathSum {
    static int minPathSum(int [][]g) {
        int m = g.length;
        int n= g[0].length;
        int sum [][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(sum[i],g[0][0]);
        }
        System.out.println(Arrays.deepToString(sum));
        for (int i = 1; i <m ; i++) {
            sum[i][0] = sum[i-1][0] + g[i][0];
        }
        for (int i = 1; i <n ; i++) {
            sum[0][i] = sum[0][i-1] + g[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = Math.min(sum[i-1][j],sum[i][j-1])+g[i][j];
            }
        }

        return sum[m-1][n-1];
    }

    public static void main( String[] args ) {

        int [][] g = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(MinimumPathSum.minPathSum(g));
    }
}
