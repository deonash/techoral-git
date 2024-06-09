package com.techoral.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * www.techoral.com
 * 
 * Given two sorted lists, write a Java program to merge them into a single
 * sorted lis using streams.
 * 
 */

public class StreamMergeSortedList {

	public static void main(String[] args) {

		List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 3, 6, 7, 9));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 4, 5, 8, 10));

		List<Integer> mergedList = new ArrayList<>();

		mergedList = Stream.concat(list1.stream(), list2.stream()).sorted().collect(Collectors.toList());

		System.out.println("Merged Sortred List : " + mergedList);

	}
}
