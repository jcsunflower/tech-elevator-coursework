package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {
		int[] nums = new int[] {1, 5, 7};
		int sum = 0;

		try {
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				sum += nums[i];
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("fucker");
		}

		System.out.println("sum = " + sum);
	}

}
