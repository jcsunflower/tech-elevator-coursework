package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Please provide a series of prices(space separated): ");
		String decimalStr = in.nextLine();
		String[] decimalInput = decimalStr.split(" ");

		for (int i = 0; i < decimalInput.length; i++) {
			int decimal = Integer.parseInt(decimalInput[i]);
			System.out.print(decimal + " in binary is ");
			decimalToBinary(decimal);
			System.out.println("");
		}
	}

	public static void decimalToBinary(int decimal) {
		int[] binary = new int[40];
		int index = 0;

		while (decimal > 0) {
			binary[index++] = decimal % 2;
			decimal /= 2;
		}
		for (int i = index - 1; i >= 0; i--) {
			System.out.print(binary[i]);
		}
	}
}
