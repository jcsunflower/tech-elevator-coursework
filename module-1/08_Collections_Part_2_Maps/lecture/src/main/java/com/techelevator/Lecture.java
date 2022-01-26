package com.techelevator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {
		Set<String> names = new HashSet<>();
		names.add("Dave");
		names.add("Bob");
		names.add("Dave");
		names.add("Adam");
		names.add("BOB");

		System.out.println(names.size());

		if (names.contains("Bob")) {
			System.out.println("names contains Bob");
		}

		for (String name : names) {
			System.out.println(name);
		}

		Set<Integer> randomNums = new HashSet<>();
		//for (int i = 0; i < 50; ++i) {
		while (randomNums.size() < 50) {
			double randDouble = Math.random();
			int randInt = (int) ((randDouble * 100) + 1);
			if (!randomNums.add(randInt)) {
				System.out.println("Didn't re-add " + randInt);
			}
		}
		System.out.println("randomNums size = " + randomNums.size());

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		Map<String, String> stateAbbrevs = new HashMap<>();

		stateAbbrevs.put("OH", "Ohio");
		stateAbbrevs.put("KY", "Kentucky");
		stateAbbrevs.put("WV", "West Virginia");
		stateAbbrevs.put("HI", "Hawaii");

		String kentucky = stateAbbrevs.get("KY");
		String hawaii = stateAbbrevs.get("HI");

		if (hawaii == null) {
			System.out.println("HI key not found");
		}
		System.out.println(kentucky);
		System.out.println(hawaii);

	}

}
