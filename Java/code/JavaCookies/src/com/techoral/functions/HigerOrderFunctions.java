package com.techoral.functions;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * www.techoral.com
 * 
 */
public class HigerOrderFunctions {

	public static void main(String[] args) {
		calculateSquare();
		calculateSum();

	}

	// function returns function
	private static void calculateSum() {

		Function<Integer, Function<Integer, Integer>> add = x -> y -> x + y;
		Function<Integer, Integer> addFive = add.apply(5);
		int result = addFive.apply(3);

		System.out.println(result);

	}

	// using map, function takes an argument

	private static void calculateSquare() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
		List<Integer> squareNumbers = numbers.stream().map(x -> x * x).collect(Collectors.toList());
		System.out.println(squareNumbers);

	}

}
