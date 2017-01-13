package com.algorithms;

import java.util.BitSet;

public class CycleDetection {

	boolean hasSelfLoop(Graph graph){
		for(int i=0;i<graph.getV();++i){
			
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		long x = 106;
		long [] l = {x};
		BitSet valueOf = BitSet.valueOf(l);
		for(int i=0;i<valueOf.length();++i){
			System.out.print(valueOf.get(i)+" " + (1<<i));
		}
		BitSet bit = new BitSet();
		int count = 0 ;
		for(int i=0;i<x;i++){
			if((i^x) > x){
				count++;
			}
		}
		System.out.println(count);
	}
}
