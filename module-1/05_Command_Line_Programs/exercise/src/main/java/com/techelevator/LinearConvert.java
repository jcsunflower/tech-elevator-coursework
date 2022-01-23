package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter the length: ");
		String lengthStr = in.nextLine();
		int length = Integer.parseInt(lengthStr);

		System.out.print("Is the measurement in (m)eters or (f)eet?:");
		String measurementUnit = in.nextLine();
		if (measurementUnit.equalsIgnoreCase("m")) {
			int measurementM = (int) (length * 3.2808399);
			System.out.format("%dm is %df.%n", length, measurementM);
		}
		if (measurementUnit.equalsIgnoreCase("f")) {
			int measurementF = (int) (length * 0.3048);
			System.out.format("%df is %dm.%n", length, measurementF);
		}
	}

}
