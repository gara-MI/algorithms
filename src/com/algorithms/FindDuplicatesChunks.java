package com.algorithms;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindDuplicatesChunks {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String st="";
		Set<String> set = new HashSet<>();
		while(!st.equals("###DONE###")) {
			st = scan.nextLine();
			String[] split = st.split(" ");
			if(set.contains(split[2])) {
				System.out.println(" duplicate found: "+split[2]);
			}
			else {
				set.add(split[2]);
			}
		}
	}
}
