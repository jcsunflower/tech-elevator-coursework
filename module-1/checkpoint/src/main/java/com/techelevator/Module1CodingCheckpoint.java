package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Module1CodingCheckpoint {

	public static void main(String[] args) {
		HotelReservation test = new HotelReservation("Marriott", 3);
		System.out.println(test);
		System.out.println(test.getEstimatedTotal());
		System.out.println(test.calculateActualTotal(true, true));
		System.out.println(test.calculateActualTotal(true, false));
		System.out.println(test.calculateActualTotal(false, true));

		//This allows us to read through HotelInput.csv and put that information into an ArrayList
		ArrayList<HotelReservation> listOfReservations = new ArrayList<>();

		File reservationsFile = new File("C:\\Users\\Student\\workspace\\jay-chen-student-code\\module-1\\checkpoint\\data-files\\HotelInput.csv");
		Scanner display = null;

		try {
			display = new Scanner(reservationsFile);
			while (display.hasNextLine()) {
				String reservationLine = display.nextLine();
				String[] reservations = reservationLine.split(", ");
				HotelReservation reservationsRecord = new HotelReservation(reservations[0], Integer.parseInt(reservations[1]));
				listOfReservations.add(reservationsRecord);
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
	}

}
