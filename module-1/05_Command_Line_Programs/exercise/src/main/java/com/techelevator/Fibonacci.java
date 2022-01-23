package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		int numInput = in.nextInt();
		int fibonacci1 = 0;
		int fibonacci2 = 1;
		int fibonacciResult = Integer.MIN_VALUE;
		System.out.print(fibonacci1 + ", " + fibonacci2);

		while (fibonacciResult < numInput) {
			fibonacciResult = fibonacci1 + fibonacci2;
			fibonacci1 = fibonacci2;
			fibonacci2 = fibonacciResult;
			if (fibonacci2 > numInput) {
				break;
			}
			System.out.print(", " + fibonacciResult);
		}
	}

}
