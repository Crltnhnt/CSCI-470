/********************************************************************************
Class:		CSCI 470
Program:	
Student:    	Carlton Hunt
ZID:		Z1772974
Date Due:  	05/05/2020
Goal:		This program checks if the number is even/odd and then calculates
	and prints the power all the way until the 9th power or reaches 1000000.

Execution:
    java Exam1c [an integer less than 1000000]

**************************************************************************************/
import java.lang.Math;

class Exam1c {

/**********************************************************
* Executes the power function to the 9th power.
* The function quits once it reaches 9th power or 1000000
**********************************************************/
	public static void Power (int firstArg, int limit) {
		//execute the power function
		for (int i = 1; i <= 9; i++) {
			result = Math.pow(firstArg, i);
			if (result > limit) {
				//quit if the number is greater than the max limit
				System.exit(0);
			}
			//Format right-aligned, no decimals just like the sample output
			System.out.format("%8d%n", (int)(result));
		}
	}

/************************************************************
* This method checks to see if the arg is even/odd and prints.
*
*************************************************************/
	public static void Check (int firstArg) {
		int isEven = firstArg % 2;	//Test if its even or odd

		if (isEven == 0) {
			//IF even print even
		System.out.println(firstArg + " is an even number.");
		}
		else {
		System.out.println(firstArg + " is an odd number.");
		}
	}

	public static void main(String args[]) {

		int firstArg = 0;	//variable for the arg[0]
		double result = 0;	//variable for the power function
		int limit = 1000000; //variable for the max integer

		//Check if no args
		if(args.length == 0) {
			System.out.println("Error: No argument provided.");
			System.exit(0);
		}
		else if (args.length > 0) {
			//Check if args is a numeric value
			try {
				firstArg = Integer.parseInt(args[0]);
				//System.out.println(firstArg);
			} catch (NumberFormatException e) {
				System.err.println("Error: Argument " + args[0] + " must be an integer");
				System.exit(0);
			}
		}
		if(firstArg > limit) {
			//Check if args is within the limit
			System.out.println("Argument " + firstArg + " is too large.");
			System.exit(0);
		}

		Exam1c.Check(firstArg);		//Calls Check method for even/odd
		Exam1c.Power(firstArg, limit); //Calls the Power method to execute POW function
	}
}
