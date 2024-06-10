package com.techoral.coding.challenge;

public class Palindrome {

	static boolean isPalindrome(String inputString) {
		int left = 0, size = inputString.length(), right = size - 1;

		while (left < right) {
			if (inputString.charAt(left) != inputString.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("is palindrome " + isPalindrome("racecar"));
		System.out.println("is palindrome " + isPalindrome("techoral"));

	}

}
