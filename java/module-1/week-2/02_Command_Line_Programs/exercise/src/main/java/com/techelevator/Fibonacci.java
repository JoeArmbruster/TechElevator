package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.print("Please enter a number: ");
	int number = scanner.nextInt();

	if (number <= 0){
		System.out.print(("0, 1"));
	} else if (number == 1){
		System.out.print("0, 1, 1");
	} else {
		System.out.print("0, 1");
		int previousNumber = 0;
		int currentNumber = 1;
		while (currentNumber <= number){
			int nextNumber = previousNumber + currentNumber;
			if (nextNumber <= number) {
				System.out.print(", " + nextNumber);
			}
			previousNumber = currentNumber;
			currentNumber = nextNumber;
		}
	}
	}
}
