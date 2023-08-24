package com.techelevator;

import java.sql.SQLOutput;
import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter in a series of decimal values (separated by spaces): ");
		String decimalValues = scanner.nextLine();

		String[] decimalValuesAsStrings = decimalValues.split(" ");

		for (int i = 0; i < decimalValuesAsStrings.length; i++) {
			int decimal = Integer.parseInt(decimalValuesAsStrings[i]);
			String binary = "";

			while (decimal > 0) {
				int remainder = decimal % 2;
				binary = remainder + binary;
				decimal /= 2;
			}

			System.out.println(decimalValuesAsStrings[i] + " in binary is " + binary);
		}
	}
}