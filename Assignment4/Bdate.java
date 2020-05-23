/*******************************************************************
Class: 470 Exam2 assignment
Programmer: Carlton Hunt
ZID: z1772974
Class ID: HUNT
Due Date: 5/7/2020
Program: Exam 2 Program to take string input for dates and format them
	with past/future dates

Execute: java Exam2b
********************************************************************/
public class Bdate {
	//represents the birthdates
	private int year;
	private int month;
	private int day;

	public Bdate(String mm, String dd, String yy) {
		//inputs as a string and then converts to integer
		this.month = Integer.parseInt(mm);
		this.day = Integer.parseInt(dd);
		this.year = Integer.parseInt(yy);
	}

	public Bdate(Bdate a) {
		this.month = a.month;
		this.day = a.day;
		this.year = a.year;
	}


	@Override
	public String toString() {
		//Checks if past dates to assume 1920 or 2020
		if(month >= 5 && day > 7) {
			return month + "/" + day + "/" + "19" + year;
		}else {
			return month + "/" + day + "/" + "20" + year;
		}
	}

	public boolean isNewYears() {
		//checks if newYears using boolean
		if(month == 1 && day == 1) {
			return true;
		}else {
			return false;
		}
	}

	public static boolean isNewYears(Bdate a) {
		//checks if newYears using boolean
		if(a.month == 1 && a.day == 1) {
			return true;
		}else {
			return false;
		}
	}
}
