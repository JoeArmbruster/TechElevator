package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the length: ");
		String userInput = input.nextLine();

		int length = Integer.parseInt(userInput);

		System.out.print("Is the measurement in (m)eter, or (f)eet? ");
		String measurementType = input.nextLine();

		if (measurementType.equals("m")) {
			int measurementFeet = (int) (length * 3.2808399);
			System.out.print(length + "m is " + measurementFeet + "f.");
		} else if (measurementType.equals("f")) {
			int measurementMeter = (int) (length * 0.3048);
			System.out.print(length + "f is " + measurementMeter + "m.");
				}
	}
}
