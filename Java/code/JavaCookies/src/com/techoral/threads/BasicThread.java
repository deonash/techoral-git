package com.techoral.threads;

/**
 * www.techoral.com
 * 
 */

class BasicRunner implements Runnable
{

	@Override
	public void run() {

		for(int i=0;i<10;i++)
		{
			System.out.println("thread id is "+Thread.currentThread().getId());
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
public class BasicThread {

	public static void main(String[] args)
	{
		Thread t1 = new Thread(new BasicRunner());
		Thread t2 = new Thread(new BasicRunner());
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
