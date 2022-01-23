package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter the temperature: ");
		String temperatureStr = in.nextLine();
		int temperatureValue = Integer.parseInt(temperatureStr);

		System.out.print("Is the temperature in (C)elsius or (F)ahrenheit?: ");
		String temperatureUnit = in.nextLine();
		if (temperatureUnit.equalsIgnoreCase("c")) {
			int temperatureF = (int) (temperatureValue * 1.8 + 32);
			System.out.format("%dC is %dF%n", temperatureValue, temperatureF);
		}

		if (temperatureUnit.equalsIgnoreCase("f")) {
			int temperatureC = (int) ((temperatureValue - 32) / 1.8);
			System.out.format("%dF is %dC.%n", temperatureValue, temperatureC);
		}
	}

}
