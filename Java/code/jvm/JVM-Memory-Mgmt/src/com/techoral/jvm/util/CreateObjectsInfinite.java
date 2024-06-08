package com.techoral.jvm.util;

/**
 * 
 * @author https://techoral.com
 * program may not be causing an OutOfMemoryError due to the aggressive behavior of the JVM Garbage Collector, 
 * which is freeing up memory as objects become unreachable
 */
public class CreateObjectsInfinite {

	public static void main(String[] agrs) {
		System.out.println("Creating Object..");
		// infinite number of object creationS
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			createNewObject();
		}
	}

	private static void createNewObject() {

		System.out.println("creating 1 lakh objects");
		for (int i = 0; i < 100000000; i++) {
			Object obj = new Object();
			Object obj1 = new Object();
			Object obj2 = new Object();
			Object obj3 = new Object();
			Object obj4 = new Object();
			Object obj5 = new Object();
			Object obj6 = new Object();
			Object obj7 = new Object();
			Object obj8 = new Object();
			Object obj9 = new Object();

		}

	}
}
