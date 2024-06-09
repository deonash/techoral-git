package com.techoral.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * www.techoral.com
 * 
 * Given two sorted lists, write a Java program to merge them into a single
 * sorted list.
 * 
 */

public class MergeSortedList {

	public static void main(String[] args) {

		List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 3, 6, 7, 9));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 4, 5, 8, 10));

		List<Integer> mergedList = new ArrayList<>();

		int i = 0, j = 0;

		while (i < list1.size() && j < list2.size()) {
			if (list1.get(i) < list2.get(j)) {
				mergedList.add(list1.get(i));
				i++;
			} else {
				mergedList.add(list2.get(j));
				j++;
			}

		}

		while (i < list1.size()) {
			mergedList.add(list1.get(i));
			i++;
		}

		while (j < list2.size()) {
			mergedList.add(list2.get(j));
			j++;
		}

		System.out.println("Merged Sortred List : " + mergedList);

	}
}
