package com.daily;
import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * using iteration - most efficient
 */
public class Fibonacci {

	static HashMap<Integer, Integer> memo = new HashMap<>();

	public static void main(String[] args) {
		int n = 10;
		fibonacciIterative(10);

		// using recursive
		for (int i = 0; i < n; i++) {
			System.out.print(fibonacciRecursive(i) + " ");
		}

		// fork join

		ForkJoinPool pool = new ForkJoinPool();
		int result = pool.invoke(new FibonacciForkJoin(n));
		System.out.println("Fibonacci(" + n + ")=" + result);

	
	}

	

		

	private static int fibonacciRecursive(int n) {
		if (n <= 1)
			return n;
		if (memo.containsKey(n))
			return memo.get(n);

		int result = fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
		memo.put(n, result);
		return result;

	}

	/**
	 * fibonacci number with memoization
	 * 
	 * @param n
	 */
	private static void fibonacciIterative(int n) {

		int prev = 0, curr = 1;

		for (int i = 2; i < n; i++) {
			int next = prev + curr;
			printFibonacciNumber(next);
			prev = curr;
			curr = next;
		}

	}

	private static void printFibonacciNumber(int next) {
		System.out.println(next);
	}

}

class FibonacciForkJoin extends RecursiveTask<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int n;

	public FibonacciForkJoin(int n) {
		this.n = n;
	}

	@Override
	protected Integer compute() {
		
		if(n < 0)
			return 0;
		if (n <= 1)
			return n;
		FibonacciForkJoin task1 = new FibonacciForkJoin(n - 1);
		task1.fork();
		FibonacciForkJoin task2 = new FibonacciForkJoin(n - 2);
		int result2 = task2.compute();
		int result1 = task1.join();
		return result1 + result2;

	}

}
