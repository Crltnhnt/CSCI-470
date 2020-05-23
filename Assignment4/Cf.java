public class Cf {
	public static String cf (String a, String b) {
/*******************************************************
	Checks if string a and b are the same length,
	If different lengths, set the string to empty
******************************************************/
	if (a.length() != b.length()) {
		a = "";
		b = "";
	}
	else {
	//Return * anywhere b = a
		for(int i = 0; i < a.length(); i++) {
			char testA = a.charAt(i); //used Char to get the char in a string
			char testB = b.charAt(i); //same as TestA
			if (testA == testB) {
				a = a.replace(testA, '*');
				b = b.replace(testB, '*');
			}
			else {
				//Return - anywhere b != a
				a = a.replace(testA,'-');
				b = b.replace(testB,'-');
			}
		}
	}
	return a;
}
}