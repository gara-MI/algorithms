package com.algorithms;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtremelyDangerousVirus {

	public static long MOD = 1000000007;
	public static long recPow(long a, long p){
		if(p==0) return 1;
		if(p%2==0){
			long r = recPow(a, p/2)% MOD;
			return (r*r) % MOD;
		}
		return (a*recPow(a, p-1))% MOD;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        /*BigInteger a = new BigInteger(scan.next());
        BigInteger b = new BigInteger(scan.next());
        BigInteger t = new BigInteger(scan.next());
        a = a.add(b).divide(new BigInteger("2"));
        BigInteger modPow = a.modPow(t, new BigInteger("1000000007"));
        System.out.println(modPow);*/
		
		long a = scan.nextLong();
		long b = scan.nextLong();
		long t = scan.nextLong();
        System.out.println(recPow((a+b)/2, t));
	}
}
