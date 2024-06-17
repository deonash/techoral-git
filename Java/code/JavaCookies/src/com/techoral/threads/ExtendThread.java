package com.techoral.threads;

public class ExtendThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("thread id is " + Thread.currentThread().getId());

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {

		ExtendThread t1 = new ExtendThread();
		t1.start();
		
		ExtendThread t2 = new ExtendThread();
		t2.start();
		
	}
}
