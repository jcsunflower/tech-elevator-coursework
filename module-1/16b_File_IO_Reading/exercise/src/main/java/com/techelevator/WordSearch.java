package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        System.out.println("What is the fully qualified name of the file that should be searched?");
        String filePath = userInput.nextLine();

        System.out.println("What is the search word you are looking for?");
        String word = userInput.nextLine();

        System.out.println("Should the search be case sensitive? (Y/N)");
        String yesOrNo = userInput.nextLine();

        boolean isCaseSensitive = false;
        if (yesOrNo.equalsIgnoreCase("y")) {
            isCaseSensitive = true;
        }

        File file = getInputFileFromUser(filePath);
        try (Scanner fileInput = new Scanner(file)) {
            int lineNumber = 1;

            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();

                if (isCaseSensitive) {
                    if (line.contains(word)) {
                        System.out.println(lineNumber + ") " + line);
                    }
                }
                else {
                    if (line.toLowerCase().contains(word.toLowerCase())) {
                        System.out.println(lineNumber + ") " + line);
                    }
                }
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(file + " does not exist.");
        }
    }

    /* This helper method allows the user to input the name of a text file
    for the scanner to read
     */
    @SuppressWarnings("resource")
    private static File getInputFileFromUser(String filePath) {

        File inputFile = new File(filePath);
        if (!inputFile.exists()) {
            System.out.println(filePath + " does not exist.");
            System.exit(1);
        } else if (!inputFile.isFile()) {
            System.out.println(filePath + " is not a file.");
            System.exit(1);
        }
        return inputFile;
    }
}
