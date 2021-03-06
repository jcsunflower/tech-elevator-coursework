package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");
        String discountStr = scanner.nextLine();
        System.out.println(discountStr);
        double discount = Double.parseDouble(discountStr);
        System.out.format("%5.3f%n", discount);


        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String priceStr = scanner.nextLine();
        String[] prices = priceStr.split(" ");

        for (int i = 0; i < prices.length; i++) {
            double price = Double.parseDouble(prices[i]);
            double discountAmt = price * (discount / 100);
            System.out.format("%10.2f %10.2f %10.2f%n", discount, price, discountAmt);
        }









    }

}