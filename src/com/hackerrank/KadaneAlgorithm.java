package com.hackerrank;

public class KadaneAlgorithm {
    static int maxSubArray(int [] A) {
        int maxSoFar = A[0];
        int maxEndingHere = A[0];
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 1; i < A.length; i++) {
            maxEndingHere = Math.max(A[i], maxEndingHere+A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
    public static void main( String[] args ) {

    }
}
