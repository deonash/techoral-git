package com.techoral.threads;

public class FIThread {

	public static void main(String[] args) {
		Thread t1 = new Thread(

				() -> {

					for (int i = 0; i < 5; i++)
						System.out.println("run thread - " + i);
				}

		);
		t1.start();

	}
}
