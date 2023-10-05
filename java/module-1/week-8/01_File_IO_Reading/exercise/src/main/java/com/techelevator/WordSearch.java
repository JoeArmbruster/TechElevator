package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		WordSearch wordSearch = new WordSearch();
		wordSearch.run();
	}

		public void run() {
			try (userInput) {
				System.out.print("What is the fully qualified name of the file that should be searched? ");
				String filePath = userInput.nextLine();

				System.out.print("What is the search word you are looking for? ");
				String searchWord = userInput.nextLine();

				System.out.print("Is the search case-sensitive? (Y/N) ");
				String caseSensitiveInput = userInput.nextLine();
				boolean caseSensitive = caseSensitiveInput.equals("Y");

				try (Scanner fileScanner = new Scanner(new File(filePath))) {
					int lineNumber = 0;
					while (fileScanner.hasNextLine()) {
						lineNumber++;
						String line = fileScanner.nextLine();
						if (caseSensitive) {
							if (line.contains(searchWord)) {
								System.out.println(lineNumber + ") " + line);
							}
						} else {
							if (line.toLowerCase().contains(searchWord.toLowerCase())) {
								System.out.println(lineNumber + ") " + line);
							}
						}
					}
				} catch (FileNotFoundException e) {
					System.out.println("File not found: " + e.getMessage());
				}
			}
		}

}
