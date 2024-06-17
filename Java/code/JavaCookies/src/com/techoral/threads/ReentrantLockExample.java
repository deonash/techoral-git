package com.techoral.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

	public static final Lock lock = new ReentrantLock();

	public static int count = 0;

	public static void main(String[] args) {

		for(int i=0;i<10;i++)
			new Thread(new Worker()).start();
	}

	public static class Worker implements Runnable {

		@Override
		public void run() {
			lock.lock();
			try {
				count++;
				System.out.println(Thread.currentThread().getName() + "Incremented the count to " + count);
			} finally {
				lock.unlock();
			}

		}

	}

}
