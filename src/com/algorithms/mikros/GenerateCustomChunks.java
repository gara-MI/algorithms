package com.algorithms.mikros;

import java.io.IOException;

public class GenerateCustomChunks {
    public static final long MAX_FILE_SIZE = 42969970820L;
    public static final long MAX_CHUNK_SIZE=1*1024*1000;


    public static void main(String[] args) throws IOException {
        long i;
        for(i=0;i<MAX_FILE_SIZE;i+=MAX_CHUNK_SIZE) {
            System.out.println(i+" "+MAX_CHUNK_SIZE);
        }
        i=i-MAX_CHUNK_SIZE;
        System.out.println(i+" "+(MAX_FILE_SIZE-i));
    }
}
