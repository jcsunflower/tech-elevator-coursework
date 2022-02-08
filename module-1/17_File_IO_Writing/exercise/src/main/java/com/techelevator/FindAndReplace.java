package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {
        //Initializing scanner object to take in user input
        Scanner userInput = new Scanner(System.in);

        //Obtaining information from user
        System.out.println("What is the search word?");
        String wordToBeReplaced = userInput.nextLine();

        System.out.println("What is the replacement word?");
        String wordToReplace = userInput.nextLine();

        System.out.println("What is the source file?");
        String sourcePath = userInput.nextLine();

        System.out.println("What is the destination file?");
        String destinationPath = userInput.nextLine();

        userInput.close();

        try (PrintWriter fileOut = new PrintWriter(destinationPath)) {

            // Creating scanner object to scan through our text file
            Scanner fileReader = new Scanner(new File(sourcePath));

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();

                if (line.contains(wordToBeReplaced)) {
                    fileOut.println(line.replace(wordToBeReplaced, wordToReplace));
                }
                else {
                    fileOut.println(line);
                }
            }
            fileOut.close();
            fileReader.close();
        }  catch (FileNotFoundException e) {
            System.err.println("Cannot open the file for writing");
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
