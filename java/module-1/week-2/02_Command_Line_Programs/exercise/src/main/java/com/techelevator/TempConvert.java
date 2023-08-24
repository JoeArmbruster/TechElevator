package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a temperature ");
		String userInput = input.nextLine();

		double temperature = Double.parseDouble(userInput);

		System.out.print("Is the temperature in (F)ahrenheit or (C)elsius?");
		String temperatureType = input.nextLine();

		if (temperatureType.equals("F")) {
			double  temperatureCelsius = (temperature - 32) / 1.8;
			System.out.print(temperature + " degrees Fahrenheit = " + temperatureCelsius);
		} else if (temperatureType.equals("C")) {
			double temperatureFarenheit = temperature * 1.8 + 32;
			System.out.print(temperature + " degrees Celsius = " + temperatureFarenheit);
		} else {
			System.out.print("Invalid entry!");
		}
	}

}
