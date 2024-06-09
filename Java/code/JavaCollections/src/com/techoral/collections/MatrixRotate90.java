package com.techoral.collections;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MatrixRotate90 {

	public static void main(String[] agrs) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int n = matrix.length;
		System.out.println("Matrix before 90 rotate");

		printMatrix(matrix);
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(matrix[i][j] + " ");
//			}
//			System.out.println();
//		}
		
	

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < (n - 1 - i); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = temp;
			}


		}
		
		System.out.println("Matrix after 90 rotate");

		printMatrix(matrix);

//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(matrix[i][j] + " ");
//			}
//			System.out.println();
//		}

	}

	private static void printMatrix(int[][] matrix) {

		Arrays.stream(matrix).map(row -> Arrays.stream(row)
											   .mapToObj(Integer::toString)
											   .collect(Collectors.joining(" ")))
		.forEach(System.out::println);
		
	}

}
