package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {

		//Initializing scanner to allow for user input
		Scanner userInput = new Scanner(System.in);

		//Prompt the user to provide the destination file
		System.out.print("Please enter the destination file: ");
		String destinationPath = userInput.nextLine();

		try (PrintWriter writer = new PrintWriter(new File(destinationPath))) {
			for (int i = 1; i <= 300; i++) {
				String output = "";
				if (i % 3 == 0 && i % 5 == 0) {
					output = "FizzBuzz";
				}
				else if (i % 3 == 0) {
					output = "Fizz";
				}
				else if (i % 5 == 0) {
					output = "Buzz";
				}
				else {
					output = Integer.toString(i);
				}
				writer.println(output);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

}
