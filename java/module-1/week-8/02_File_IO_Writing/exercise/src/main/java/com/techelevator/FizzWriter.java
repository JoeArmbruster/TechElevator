package com.techelevator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FizzWriter {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FizzWriter fizzWriter = new FizzWriter();
        fizzWriter.run();
    }

    public void run() {
        /* Your code goes here */
        System.out.println("Enter the destination file path: ");
        String destinationFile = userInput.nextLine();

        try (FileWriter writer = new FileWriter(destinationFile)) {
            for (int i = 1; i <= 300; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    writer.write("FizzBuzz\n");
                } else if (i % 3 == 0) {
                    writer.write("Fizz\n");
                } else if (i % 5 == 0) {
                    writer.write("Buzz\n");
                } else {
                    writer.write(i + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
