package com.algorithms;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class AntiprimeNumbers {
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
	public static void main(String[] args) throws IOException {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		String d = "Hedlo";
		String value = "video\\test1.xml";
		System.out.println(value);
		System.out.println(value.replaceAll("\\\\", "/"));
		int f1 = d.indexOf("d");
		int l1 = d.lastIndexOf("d");
		if(f1==l1) {
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
        int l = d.length();
        for(int i=0;i<l;i++){
            for(int j=i+1;j<=l;j++){
                String ss = d.substring(i,j);
                System.out.println(ss);
            }
        }
		int [] a = {1,2,4,6,12,24,36,48,60,120,180,240,360,720,840,
				1260,1680,2520,5040,7560,10080,15120,20160,25200,
				27720,45360,50400,55440,83160,110880,166320,
				221760,277200,332640,498960,554400,665280,720720,
				1081080,1441440,2162160};
		Reader scan = new Reader();
		int q = scan.nextInt();
		while(q-- > 0){
			int i = scan.nextInt();
			int binarySearch = Arrays.binarySearch(a, i);
			if(binarySearch<0){
				binarySearch = 1-binarySearch;
			}
			System.out.println(a[binarySearch]);
			String.valueOf(a[binarySearch]);
		}

	}
}