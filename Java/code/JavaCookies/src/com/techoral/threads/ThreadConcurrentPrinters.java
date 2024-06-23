package com.techoral.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * www.techoral.com
 * 
 * You have three threads: ThreadA, ThreadB, and ThreadC. Each thread prints a sequence of numbers in a loop. Implement these threads such that the numbers are printed in the following sequence:

ThreadA: 1, 4, 7, 10, ...
ThreadB: 2, 5, 8, 11, ...
ThreadC: 3, 6, 9, 12, ...
    
The goal is to ensure that the numbers are printed in the correct order across the threads using Java multithreading concept

 */
public class ThreadConcurrentPrinters {

	private static final int MAX_COUNT = 20;
	private static volatile int currentNumber = 1;
	private static final Object lock = new Object();

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.submit(new Printer("ThreadA", 1));
		executor.submit(new Printer("ThreadB", 2));
		executor.submit(new Printer("ThreadC", 3));
		executor.shutdown();
	}

	static class Printer implements Runnable {
		private String threadName;
		private int startNumber;

		public Printer(String threadName, int startNumber) {
			this.threadName = threadName;
			this.startNumber = startNumber;

		}

		@Override
		public void run() {

			while (true) {
				synchronized (lock) {
					while ((currentNumber % 3) != startNumber - 1) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							Thread.currentThread().interrupt();
							return;
						}
					}
					
					
					if(currentNumber > MAX_COUNT)
						return;
					
					System.out.println(threadName +" : "+ currentNumber);
					currentNumber++;
					lock.notifyAll();
				}
			}

		}

	}

}
