package com.hackerrank;

import java.util.regex.Pattern;

public class SuperReducedString {
    public static String superReducedString(String s) {
        int prev_len=s.length();
        int current_len=0;
        Pattern p = Pattern.compile("(.)\\1");
        StringBuilder sb = new StringBuilder(s);
        boolean flag=true;
        while(flag) {
            flag = false;
            for(int i=0;i<sb.length()-1;i++) {
                if(sb.charAt(i)==sb.charAt(i+1)) {
                    sb.delete(i,i+2);
                    flag=true;
                    break;
                }
            }
        }
        final String out = sb.toString();
        String finalOut = out.equals("")?"Empty String": out;
        return finalOut;
    }

    public static String superReducedStringRegularExpression(String s) {

        Pattern p = Pattern.compile("(.)\\1");
        int prev_len,current_len;
        boolean flag=true;
        while(flag) {
            prev_len=s.length();
            s=s.replaceAll("(.)\\1","");
            if(s.length()==prev_len)
                break;
        }
        return s.isEmpty()?"Empty String":s;
    }


    public static void main( String[] args ) {
        String s = "baab";
        System.out.println(s.replaceAll("(.)\\1",""));
        final String out = superReducedString("baab");
        System.out.println(superReducedStringRegularExpression(s));
    }
}
