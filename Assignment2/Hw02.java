/********************************************************************************
Class:		CSCI 470
Program:	Assignment 2
Student:    Carlton Hunt
ZID:		Z1772974
Date Due:  03/25/2020
Goal:		Numerology involves assigning a numerical value to a string based
on values assigned to the individual letters according to a variety of rules. 
  
Execution:
    java Hw02 [1 or more strings]

********************************************************************************/
public class Hw02 {
	
	public static void main (String[] args) {
		DataTable table = new DataTable();
        int amountOfLetters = 0;
        
		//Field Header
        System.out.println("Parm   Length   Total   String");
        System.out.println("----   ------   -----   ------");
        
		
		//If statement for argument need at least one string
        if(args.length == 0) {
            System.out.println("Error: No argument provided.");
            System.exit(0);
        }
        
		//For Loop until end of argument provided
        for(int i = 0; i < args.length; i++) {
            table.setString(args[i]);
			//Format the output
            System.out.printf("%4s%9s%8s %20s%n", (i+1), (table.numInLength()), (table.numOfTotalLetterCount()), (table.getString()) );

			//Add to the amountOfLetters
            amountOfLetters += table.countNumOfLetters();
        }
		
        System.out.printf("%n");
		//print out all of the letters 
        table.printNumOfLetters();
		
        System.out.printf("%n%s %d %n", "Total letters = ",  amountOfLetters);    //Print total letters in all args
    }
	}