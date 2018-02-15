package com.algorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HShirts {

    static class Shirt{
        int smallest;
        int largest;
        Shirt(int smallest,int largest) {
            this.smallest = smallest;
            this.largest = largest;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            Integer[] sizes = new Integer[n];
            for(int sizes_i=0; sizes_i < n; sizes_i++){
                sizes[sizes_i] = in.nextInt();
            }
            Arrays.sort(sizes);
            int v = in.nextInt();
            List<Integer> ilist = Arrays.asList(sizes);
            for(int a1 = 0; a1 < v; a1++){
                int smallest = in.nextInt();
                int largest = in.nextInt();
                if(ilist.isEmpty())
                	continue;
                int start = Collections.binarySearch(ilist, smallest);
                int end = Collections.binarySearch(ilist, largest);
                /*System.out.println("Start : "+start);
                if(start<0){
                	start =-start-1;
                	System.out.println("Start is negative : "+start);
                }
                if(start>n){
                	System.out.println("Start is greater than end");
                	continue;
                }*/
                if(start != end){
                	ilist.removeIf(i-> (i>=smallest && i<=largest));
                }
            }
        }
    }
}

