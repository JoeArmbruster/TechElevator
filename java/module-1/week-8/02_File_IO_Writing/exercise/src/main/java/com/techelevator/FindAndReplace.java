package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.run();
    }

    public void run() {
        System.out.println("What is the search word? ");
        String searchWord = userInput.nextLine();
        System.out.println("What is the replacement word? ");
        String replacementWord = userInput.nextLine();
        System.out.println("What is the source file? ");
        String sourceFile = userInput.nextLine();
        System.out.println("What is the destination file? ");
        String destinationFile = userInput.nextLine();

        File search = new File(sourceFile);
        File output = new File(destinationFile);

        try {
            Scanner scanner = new Scanner(search);
            PrintWriter printWriter = new PrintWriter(output);

            while (scanner.hasNextLine()) {
                String lineOfInput = scanner.nextLine();
                lineOfInput = lineOfInput.replace(searchWord, replacementWord);
                printWriter.println(lineOfInput);
            }

            scanner.close();
            printWriter.close();

            System.out.println("Replacement completed successfully.");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}
