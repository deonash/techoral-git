package com.techoral.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author: www.techoral.com
 * 
 * Given a list of integers, write a Java program to remove all duplicate
 * elements from the list.
 * 
 */
public class RemoveListDuplicates {

	public static void main(String[] args) {
		//List<Integer> numberList = Arrays.asList(1,2,3,4,4,2,5,6,5,7,8,9);
		//or
		List<Integer> numberList = new ArrayList<>(List.of(1, 2, 3, 4, 4, 2, 5, 6, 5, 7, 8, 9));
		
		Set<Integer> numbers = new HashSet<>(numberList);
		
		numberList.clear();
		numberList.addAll(numbers);
		System.out.println("list after removing duplicates : "+ numberList);
	}
}
