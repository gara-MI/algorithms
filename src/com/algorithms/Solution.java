package com.algorithms;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

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
	
    static class Query{
        int x;
        int y;
        Query(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    static class Range {
        int left;
        int right;
        int y;
        int q;
        Range(int left, int right, int y, int q) {
            this.left=left;
            this.right=right;
            this.y=y;
            this.q=q;
        }
    }
    public static void main(String[] args) throws IOException {
        Reader in = new Reader();
        int n = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        Map<Integer,List<Range>> map = new HashMap<>();
        
        for(int a0 = 0; a0 < q; a0++){
            int left = in.nextInt();
            int right = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            Range rg = new Range(left,right,y,a0);
            if(map.containsKey(x)){
                final List<Range> lr = map.get(x);
                lr.add(rg);
            }
            else{
                final List<Range> lr = new ArrayList<>();
                lr.add(rg);
                map.put(x,lr);
            }
        }
        int [] index = new int[q];
        for (Entry<Integer, List<Range>> m : map.entrySet()) {
        	int x = m.getKey();
        	final List<Range> r = m.getValue();
        	Collections.sort(r, (c,d)->{
        		return c.y-d.y;
        	});
        	Range max = Collections.max(r, (c,d)->{
        		return c.left-d.left;
        	});
        	Range min = Collections.min(r, (c,d)->{
        		return -(c.right-d.right);
        	});
        	
        	
        	/*for (Iterator iterator = r.iterator(); iterator.hasNext();) {
        		Range ra = (Range)iterator.next();
				
				
			}*/
        	
        }
        
        
    }
}
