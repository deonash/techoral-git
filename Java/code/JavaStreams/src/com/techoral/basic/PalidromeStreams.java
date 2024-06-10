package com.techoral.basic;

import java.util.stream.IntStream;

public class PalidromeStreams {

	static boolean isPalindrome(String ispalindrome) {
		ispalindrome.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		return IntStream.range(0, ispalindrome.length() / 2)
				.allMatch(i -> ispalindrome.charAt(i) == ispalindrome.charAt(ispalindrome.length() - i - 1));
	}
	

	public static void main(String[] args) {
		System.out.println("is palindrome " + isPalindrome("racecar"));
		System.out.println("is palindrome " + isPalindrome("techoral"));

	}

}
