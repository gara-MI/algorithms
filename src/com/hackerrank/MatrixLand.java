package com.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MatrixLand {

    static long maxScore(int[][] A) {

        long total =0;
        for (int k = 0; k < A.length; k++) {
            final int[] array = A[k];
            final int maxSubArray = KadaneAlgorithm.maxSubArray(array);
            total += maxSubArray;
        }
        return total;
    }
    static int matrixLand(int[][] A) {
        // Complete this function
        int n = A.length;
        int m = A[0].length;
        int max = Integer.MIN_VALUE;
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] A = new int[n][m];
        for(int A_i = 0; A_i < n; A_i++){
            for(int A_j = 0; A_j < m; A_j++){
                A[A_i][A_j] = in.nextInt();
            }
        }
        boolean [][] visited= new boolean[n][m];
        int result = matrixLand(A);
        System.out.println(result);
        in.close();
    }
}
