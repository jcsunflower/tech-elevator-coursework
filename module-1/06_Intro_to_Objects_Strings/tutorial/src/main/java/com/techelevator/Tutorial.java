package com.techelevator;

import java.util.Scanner;

public class Tutorial {

    public static void main(String[] args) {

        String greeting = "Hello";
        System.out.println(greeting.charAt(2) == greeting.charAt(3));

        // ***********  Step 1: Use the *new* operator to create Strings on the Heap  *************
        char[] helloChars = new char[] {'h','e', 'l', 'l', 'o', '!'};
        String greeting = new String(helloChars);
        System.out.println(greeting);




        // ***********  Step 2: Try out some String methods  *************





        // ***********  Step 3: Compare Strings  *************





    }
}
