package com.wangjs.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 把一组Collection(list,set/不包括map)转成流，然后套用Stream中的api处理
 * 重要方法
 * (前三个是连续性的,后三个是结束性的)
 *	filter
 *	sorted
 *	map
 *
 *	match/anyMatch/allMatch
 *	count
 *	reduce
 *	
 *	Stream有 Stream 和ParallelStream
 *	ParallelStream使用一个ForkJoinPool来执行并行任务
 *http://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html
 */
public class StreamTest {
	public static void main(String[] args) {
		
		for(int i = 1;i < 1000;i++){
			singleStream();
			parallelStream();
		}
		

	}
	
	public static void singleStream(){
		int max = 1000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
		    UUID uuid = UUID.randomUUID();
		    values.add(uuid.toString());
		}

		long t0 = System.nanoTime();

		long count = values.stream().sorted().count();
		System.out.println(count);

		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("sequential sort took: %d ms", millis));
	}
	
	public static void parallelStream(){
		int max = 1000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
		    UUID uuid = UUID.randomUUID();
		    values.add(uuid.toString());
		}

		long t0 = System.nanoTime();

		long count = values.parallelStream().sorted().count();
		System.out.println(count);

		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("parallel sort took: %d ms",millis));
	}

}
