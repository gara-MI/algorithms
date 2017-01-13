package com.algorithms;

import java.util.Scanner;

public class BetweenTwoSets {

	public static long gcd(long a, long b){
        if(a%b==0) return b;
        else return gcd(b,a%b);
    }
    public static long lcm(long a, long b){
        return (a/gcd(a,b))*b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] a = new long[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        long g=a[0];
        long lcma = 1;
        for(int i=0;i<n;i++){
            lcma = lcm(lcma,a[i]);
        }
        long[] b = new long[m];
        long g_b = 0;
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
            g_b = gcd(g_b,b[b_i]);
        }
        int count =0;
        for(long i=lcma;i<=g_b;i += lcma){
            if(i%lcma==0 && g_b%i==0){
                count++;
            }
        }
        System.out.println(count);
    }
    
}
