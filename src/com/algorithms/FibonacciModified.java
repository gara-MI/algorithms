package com.algorithms;

import java.io.IOException;
import java.math.BigInteger;

import com.algorithms.TheValueOfFriendship.Reader;

public class FibonacciModified {

	public static void main(String[] args) throws IOException{
		Reader scan = new Reader();
		int t1 =scan.nextInt();
		int t2 =scan.nextInt();
		int n =scan.nextInt();
		BigInteger bigInteger1 = new BigInteger(""+t1);
		BigInteger bigInteger2 = new BigInteger(""+t2);
		BigInteger bigInteger3 = new BigInteger("0");
		for(int i=2;i<n;i++){
			bigInteger3 = bigInteger2.multiply(bigInteger2).add(bigInteger1);
			bigInteger1 = bigInteger2;
			bigInteger2 = bigInteger3;
		}
		System.out.println(bigInteger3.toString());
	}
}
