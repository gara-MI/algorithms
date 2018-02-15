package com.hackerrank;

import java.util.Scanner;

public class LuckyPurchase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String lbook = "-1";
        long min = Long.MAX_VALUE;
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String name = in.next();
            String value = in.next();
            int c1=0;
            int c2=0;
            boolean valid = true;
            for(int i=0;i<value.length();i++) {
                if(value.charAt(i) == '4') {
                    c1++;
                }
                else if(value.charAt(i) =='7') {
                    c2++;
                }
                else {
                    valid=false;
                    break;
                }
            }
            if(valid && c1==c2 ) {
                long v = Long.valueOf(value);
                if(v<min ) {
                    min=v;
                    lbook = name;
                }
            }
        }
        System.out.println(lbook);
        in.close();
    }
}
