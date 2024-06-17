package com.techoral.threads;

import java.util.concurrent.Semaphore;

public class SemaphoreThread {

	public static final Semaphore semaphore = new Semaphore(3);

	public static void main(String[] args) {

		for(int i =0;i<10;i++)
		{
			new Thread( new Worker()).start();
		}
	}

	static class Worker implements Runnable {

		@Override
		public void run() {

			try {
				try {
					semaphore.acquire();
					System.out.println("Acquired lock permission " + Thread.currentThread().getName());
					Thread.sleep(3000);
					System.out.println("Released lock permission " + Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			} finally {
				semaphore.release();

			}

		}

	}

}
