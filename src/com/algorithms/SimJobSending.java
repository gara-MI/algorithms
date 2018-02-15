package com.algorithms;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ThreadLocalRandom;


public class SimJobSending {
	
	static void startThreads(final Queue<Chunk> cq, final Path dest) {
		int n = 5;
		Instant start = Instant.now();
		Map<String, Long> max = new ConcurrentHashMap<>();
		Set<Chunk> pq = new ConcurrentSkipListSet<>((a,b) -> {return a.chunkId-b.chunkId;});
		max.putIfAbsent("test", 0L);
		long diff=Instant.now().getNano() - start.getNano();
		for(int i=0;i<n;i++) {
			new Thread(() -> {
				final int threadId = ThreadLocalRandom.current().nextInt()%31;
				while(!cq.isEmpty()) {
					try {
						final RandomAccessFile out = new RandomAccessFile(dest.toFile(), "rw");
						final Chunk chunk = cq.poll();
						if(chunk != null) {
							final RandomAccessFile in = new RandomAccessFile(dest.toFile(), "r");
							out.seek(chunk.pos);
							final FileChannel channel = in.getChannel();
							final FileChannel outChannel = out.getChannel();
							
							channel.transferTo(chunk.pos, chunk.size, outChannel);
							pq.add(chunk);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Instant.now().getEpochSecond() - start.getEpochSecond());
			}).start();;
		}
		
	}
	
	
	static void startThreadChunks(final Queue<Chunk> cq, final Path dest) {
		int n = 5;
		Instant start = Instant.now();
		Map<String, Long> max = new ConcurrentHashMap<>();
		Set<Chunk> pq = new ConcurrentSkipListSet<>((a,b) -> {return a.chunkId-b.chunkId;});
		max.putIfAbsent("test", 0L);
		long diff=Instant.now().getNano() - start.getNano();
		for(int i=0;i<n;i++) {
			new Thread(() -> {
				final int threadId = ThreadLocalRandom.current().nextInt()%31;
				while(!cq.isEmpty()) {
					try {
						final RandomAccessFile out = new RandomAccessFile(dest.toFile(), "rw");
						final Chunk chunk = cq.poll();
						if(chunk != null) {
							final RandomAccessFile in = new RandomAccessFile(dest.toFile(), "r");
							final FileChannel channel = in.getChannel();
							final FileChannel outChannel = out.getChannel();
							outChannel.position(chunk.pos);
							channel.transferTo(chunk.pos, chunk.size, outChannel);
							pq.add(chunk);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Instant.now().getEpochSecond() - start.getEpochSecond());
			}).start();
		}
		
		new Thread(() -> {
			
			
		}).start();
		
	}
	
	static class Chunk {
		final Path filePath;
		final long pos;
		final long size;
		final int chunkId;

		public Chunk(Path filePath, long pos, long size, int chunkId) {
			super();
			this.filePath = filePath;
			this.pos = pos;
			this.size = size;
			this.chunkId = chunkId;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + chunkId;
			result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
			result = prime * result + (int) (pos ^ (pos >>> 32));
			result = prime * result + (int) (size ^ (size >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Chunk other = (Chunk) obj;
			if (chunkId != other.chunkId)
				return false;
			if (filePath == null) {
				if (other.filePath != null)
					return false;
			} else if (!filePath.equals(other.filePath))
				return false;
			if (pos != other.pos)
				return false;
			if (size != other.size)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Chunk [filePath=" + filePath + ", pos=" + pos + ", size=" + size + ", chunkId=" + chunkId + "]";
		}

		
	}
	public static  void generateSegements(long fileSize, long segementSize) {
		long seg =  fileSize/segementSize;
		Object o = new Object();
		synchronized (o) {
			for (long i = 0; i < seg; i+=1) {
				if(i%5==4) {
					long pos = ThreadLocalRandom.current().nextLong(0, i*segementSize);
					System.out.println(pos +" "+(1024000));
				}
				System.out.println(i*segementSize +" "+(segementSize));
			}

			long rem = fileSize%segementSize;
			if(rem != 0) {
				System.out.println(seg*segementSize +" "+rem);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		Queue<Chunk> cq = new ConcurrentLinkedQueue<>();
		final Path filePath = Paths.get("T:\\gara\\MediaOutput\\FTVLG2\\FTVLG2.mxf");
		final Path dest     = Paths.get("T:\\gara\\MediaOutput\\FTVLG2\\FTVLG2.mxf.start1");
		boolean flag = true;
		long fileSize = 6221150872L;
		long segmentSize = 4194304;
		generateSegements(fileSize, segmentSize);

		
	}
}
