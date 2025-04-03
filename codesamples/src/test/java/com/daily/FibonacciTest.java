package com.daily;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.ForkJoinPool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FibonacciTest {
	
	private ForkJoinPool pool = new ForkJoinPool();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    
    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }
	

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }
    
	@Test
	void testBaseCaseFibonacci0()
	{
		FibonacciForkJoin task = new FibonacciForkJoin(0);
		int result = pool.invoke(task);
		assertEquals(0,  result, "Fibonacci(0) should be 0");
	}
	
	@Test
	void tetBaseCaseFibonacci1()
	{
		FibonacciForkJoin task = new FibonacciForkJoin(1);
		int result = pool.invoke(task);
		assertEquals(1,  result, "Fibonacci(1) should be 1");
	}
	 @Test
	    void testFibonacci5() {
	        FibonacciForkJoin task = new FibonacciForkJoin(5);
	        int result = pool.invoke(task);
	        assertEquals(5, result, "Fibonacci(5) should be 5");
	    }

	    @Test
	    void testFibonacci10() {
	        FibonacciForkJoin task = new FibonacciForkJoin(10);
	        int result = pool.invoke(task);
	        assertEquals(55, result, "Fibonacci(10) should be 55");
	    }

	    @Test
	    void testFibonacci15() {
	        FibonacciForkJoin task = new FibonacciForkJoin(15);
	        int result = pool.invoke(task);
	        assertEquals(610, result, "Fibonacci(15) should be 610");
	    }

	    @Test
	    void testConcurrency() {
	        FibonacciForkJoin task1 = new FibonacciForkJoin(10);
	        FibonacciForkJoin task2 = new FibonacciForkJoin(15);
	        
	        int result1 = pool.invoke(task1);
	        int result2 = pool.invoke(task2);

	        assertAll(
	            () -> assertEquals(55, result1, "Fibonacci(10) should be 55"),
	            () -> assertEquals(610, result2, "Fibonacci(15) should be 610")
	        );
	    }

	    @Test
	    void testNegativeInput() {
	        FibonacciForkJoin task = new FibonacciForkJoin(-5);
	        int result = pool.invoke(task);
	        System.out.println(result);
	        assertEquals(0, result, "Negative Fibonacci numbers should return 0");
	    }
	    
	    @Test
	    void testPositiveInput() {
	        FibonacciForkJoin task = new FibonacciForkJoin(+1);
	        int result = pool.invoke(task);
	        System.out.println(result);
	        assertEquals(1, result, "Positive Fibonacci of +1 return 1");
	    }
	    
	    
	    
	    @Test
	    void testMainMethod() {
	    	 Fibonacci.main(new String[]{}); // Execute main()
	         
	         String output = outputStream.toString();
	         System.out.println("************* "+output);
	         assertTrue(output.contains("Fibonacci("), "Main method should print Fibonacci results");

	    }
}
