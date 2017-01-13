package com.algorithms;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TheValueOfFriendship {

	static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
	public static void main(String[] args) throws IOException{
		Reader in = new Reader();
        int t = in.nextInt();
        long sum =0;
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            List<Set<Integer>> val = new ArrayList<>();
            Map<Integer,Set<Integer>>  hashMap= new HashMap<>();
            for(int i = 0; i < m; i++){
                int x = in.nextInt();
                int y = in.nextInt();
                // your code goes here
                boolean flag1 = false;
                boolean flag2 = false;
                int index = -1;
                Set<Integer> set1 = null;
                Set<Integer> set2 = null;
                for(int j=0;j<val.size();j++){
                	Set<Integer> set = val.get(j);
                	if(set.contains(x)){
                		//set.add(y);
                		set1 = set;
                		flag1 = true;
                		if(flag2){
                			break;
                		}
                	}
                	if(set.contains(y)){
                		//set.add(x);
                		set2 = set;
                		flag2 = true;
                		index = j;
                		if(flag1){
                			break;
                		}
                	}
                }
                if(hashMap.containsKey(x)){
                	set1 = hashMap.get(x);
                	flag1 = true;
                }
                if(hashMap.containsKey(y)){
                	set1 = hashMap.get(y);
                	flag2 = true;
                }
                if(flag1 && flag2){
                	if(set1 != set2){
                		if(set1.size() < set2.size()){
                			Iterator<Integer> iterator = set1.iterator();
                    		while(iterator.hasNext()){
                    			set2.add(iterator.next());
                    		}
                    		hashMap.put(x, set2);
                		}
                		else{
                			Iterator<Integer> iterator = set2.iterator();
                    		while(iterator.hasNext()){
                    			set1.add(iterator.next());
                    		}
                    		hashMap.put(y, set1);
                		}
                		
                	}
                }
                else if(flag1 && !flag2){
                	set1.add(y);
                }
                else if(!flag1 && flag2){
                	set2.add(x);
                }
                else{
                    Set<Integer> set = new HashSet<>();
                	set.add(x);
                	set.add(y);
                	val.add(set);
                }

                for(int k=0;k<val.size();k++){
                	Set<Integer> set = val.get(k);
                	int size = set.size();
                	sum += (size*(size-1));
                	System.out.println(sum);
                }
            }
        }
	}
}
