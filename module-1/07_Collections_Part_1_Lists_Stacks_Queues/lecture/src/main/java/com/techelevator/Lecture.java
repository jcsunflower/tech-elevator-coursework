package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {

		Lecture lecture = new Lecture();
		lecture.testAutoBoxing();

		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		List<String> names = new ArrayList<>();
		names.add("Dave");
		names.add("Sarah");
		names.add("Bob");
		System.out.println(names.get(2));

		List<Integer> zipCodes = new ArrayList<>(Arrays.asList(45066, 45750, 45342));
		System.out.println(zipCodes);

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		List<String> planets = new ArrayList<>();
		planets.add("Mercury");
		planets.add("Venus");
		planets.add("Earth");

		for (int i = 0; i < planets.size(); i++) {
			System.out.println(planets.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();


	}

	public void testAutoBoxing() {
		System.out.println("In testAutoBoxing");

		Integer x = 5;
		Double PI = 3.14159;

		double dPI = PI;

		if (dPI == PI) {
			System.out.println("dPI equals PI");
		}
	}
}
