package com.techoral.utils;

/**
 * https://techoral.com
 * 
 * The double-checked locking pattern is used to ensure that the singleton
 * instance is created only once and in a thread-safe manner, without the
 * overhead of acquiring a lock every time the getInstance() method is called.
 * 
 */
public class JavaSingleton {

    // private static variable to hold the single instance of the class
	private static JavaSingleton singleton = null;
	// private constructor to prevent instantiation from other classes
	private JavaSingleton() {

	}

	public static JavaSingleton getInstance() {
		if (singleton == null) {
			 // synchronized block to remove overhead
			synchronized (JavaSingleton.class) {

				if (singleton == null) {
					singleton = new JavaSingleton();
				}

			}

		}

		return singleton;

	}

	public static void main(String[] args) {
		JavaSingleton singleton = JavaSingleton.getInstance();
        singleton.displayMessage();
    }
	
	// other methods of the singleton class
    public void displayMessage() {
        System.out.println("Hello from Singleton class!");
    }
}
