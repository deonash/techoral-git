package techoral.java21;

import java.util.concurrent.Executors;

public class VirtualThreads {

	public static void main(String[] args) {
		try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
			for (int i = 0; i < 100; i++) {
				int taskid = i;
				executor.submit(() -> processRequest(taskid));
			}
		}
	}

	private static void processRequest(int i) {
		try {
			System.out.println("mythread "+i);
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
