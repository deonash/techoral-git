package com.techoral.jvm.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author https://techoral.com
 * 
 * A program that creates an infinite number of objects to trigger an OutOfMemoryError.
 *
 */
public class CreateObjectsInfiniteV1 {
	
	public static List<Object> objList = new ArrayList();
	public static void main(String[] agrs) {
		System.out.println("Creating Object..");
		// infinite number of object creationS
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			createNewObject();
		}
	}

	private static void createNewObject() {

		System.out.println("creating 100 objects");
		for (int i = 0; i < 1000; i++) {
			Object obj = new Object();
			objList.add(obj);

		}
	}
}
