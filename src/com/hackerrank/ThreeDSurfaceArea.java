package com.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ThreeDSurfaceArea {
    static int countLeftSide(int[][] A, int H, int W, int i, int j, int level) {
        if(i==0)
            return level;
        int d = level-A[i-1][j];
        if(d<0)
            d = 0;
        return d;
    }

    static int countRightSide(int[][] A, int H, int W, int i, int j, int level) {
        if(i==W-1)
            return level;
        int d = level-A[i+1][j];
        if(d<0)
            d = 0;
        return d;
    }

    static int countDownSide(int[][] A, int H, int W, int i, int j, int level) {
        return 1;
    }

    static int countUpSide(int[][] A, int H, int W, int i, int j, int level) {
        return 1;
    }

    static int countFrontSide(int[][] A, int H, int W, int i, int j, int level) {
        if(j==0)
            return level;
        int d = level-A[i][j-1];
        if(d<0)
            d = 0;
        return d;
    }

    static int countBackSide(int[][] A, int H, int W, int i, int j, int level) {
        if(j==H-1)
            return level;
        int d = level-A[i][j+1];
        if(d<0)
            d = 0;
        return d;
    }

    static int surfaceArea(int[][] A) {
        // Complete this function
        int total = 0;
        int W = A.length;
        int H=A[0].length;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                total += countLeftSide(A,H,W,i,j,A[i][j]) +countRightSide(A,H,W,i,j,A[i][j])
                        +countUpSide(A,H,W,i,j,A[i][j]) +countDownSide(A,H,W,i,j,A[i][j])
                        +countFrontSide(A,H,W,i,j,A[i][j]) +countBackSide(A,H,W,i,j,A[i][j]);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int H = in.nextInt();
        int W = in.nextInt();
        int[][] A = new int[H][W];
        for(int A_i = 0; A_i < H; A_i++){
            for(int A_j = 0; A_j < W; A_j++){
                A[A_i][A_j] = in.nextInt();
            }
        }
        int result = surfaceArea(A);
        System.out.println(result);
        in.close();
    }
}
