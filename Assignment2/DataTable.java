public class DataTable {

	private TableEntry[] innerTable;
	private String currentString;
	private int totalLetter = 0;
	
	DataTable() {
		//constructor
		
		//initialize the table
		innerTable = new TableEntry[42];
		
		//create new tableEntry with the alphabet and special characters
		//Could've used a loop to reduce lines of code
		//add new element in this format: innerTable[element#] = new TableEntry(int freqLetterCount, char newLetter, int newNumLetterValue);
		
		innerTable[0] = new TableEntry(0,'a',1);
		innerTable[1] = new TableEntry(0,'b',2);
		innerTable[2] = new TableEntry(0,'c',3);
		innerTable[3] = new TableEntry(0,'d',4);
		innerTable[4] = new TableEntry(0,'e',5);
		innerTable[5] = new TableEntry(0,'f',6);
		innerTable[6] = new TableEntry(0,'g',7);
		innerTable[7] = new TableEntry(0,'h',8);
		innerTable[8] = new TableEntry(0,'i',9);
		innerTable[9] = new TableEntry(0,'j',0);
		innerTable[10] = new TableEntry(0,'k',10);
		innerTable[11] = new TableEntry(0,'l',20);
		innerTable[12] = new TableEntry(0,'m',30);
		innerTable[13] = new TableEntry(0,'n',40);
		innerTable[14] = new TableEntry(0,'o',50);
		innerTable[15] = new TableEntry(0,'p',60);
		innerTable[16] = new TableEntry(0,'q',70);
		innerTable[17] = new TableEntry(0,'r',80);
		innerTable[18] = new TableEntry(0,'s',90);
		innerTable[19] = new TableEntry(0,'t',100);
		innerTable[20] = new TableEntry(0,'u',110);
		innerTable[21] = new TableEntry(0,'v',120);
		innerTable[22] = new TableEntry(0,'w',130);
		innerTable[23] = new TableEntry(0,'x',140);
		innerTable[24] = new TableEntry(0,'y',150);
		innerTable[25] = new TableEntry(0,'z',160);
		innerTable[26] = new TableEntry(0,'é',1);
		innerTable[27] = new TableEntry(0,'â',2);
		innerTable[28] = new TableEntry(0,'ê',3);
		innerTable[29] = new TableEntry(0,'î',4);
		innerTable[30] = new TableEntry(0,'ô',5);
		innerTable[31] = new TableEntry(0,'û',6);
		innerTable[32] = new TableEntry(0,'à',7);
		innerTable[33] = new TableEntry(0,'è',8);
		innerTable[34] = new TableEntry(0,'ù',9);
		innerTable[35] = new TableEntry(0,'ë',10);
		innerTable[36] = new TableEntry(0,'ï',20);
		innerTable[37] = new TableEntry(0,'ÿ',30);
		innerTable[38] = new TableEntry(0,'ü',40);
		innerTable[39] = new TableEntry(0,'æ',50);
		innerTable[40] = new TableEntry(0,'œ',60);
		innerTable[41] = new TableEntry(0,'ç',70);
		
		//element 26-41 is all special characters
	}
	
	public void setString(String nextString) {
		//sets the string to sort out 
		this.currentString = nextString;
	}
	
	public String getString() {
		//Return the string we are using
		return this.currentString;
	}
	
	public void addTotal(int addToTotalValue) {
		//add to total value
		this.totalLetter += addToTotalValue;
	}
	
	public int getTotal() {
		//return totalLetter
		return this.totalLetter;
	}
	
	public int numInLength() {
		//return number of letters
		return this.getString().length();
	}
	
	public int countNumOfLetters() {
		//for loop to count the letters in the argument
		int amountOfLetters = 0;
		
		String tempLetter = this.getString();
		
		 for(int i = 0; i < tempLetter.length(); i++) {
            char stringChar = tempLetter.charAt(i);
			
            if(Character.isLetter(stringChar)) {
                amountOfLetters++;
            }
        }
        
        return amountOfLetters;
	}
	
	 public int numOfTotalLetterCount() {
		 //change into array, if dulicate add to letterCount, creates the number in array from the string
        int letterCount = 0;
        int totalInArray = 0;
		//change any upper case to lower case, change the string to char array
        char[] wordChunk = this.getString().toLowerCase().replaceAll("\\s+","").toCharArray();  
        
        while(totalInArray < wordChunk.length) {
            for(int innerTableCnt = 0; innerTableCnt < innerTable.length; innerTableCnt++) {
				
                if(wordChunk[totalInArray] == innerTable[innerTableCnt].getLetter()) {
                    innerTable[innerTableCnt].increaseCount();
                    letterCount += innerTable[innerTableCnt].getTableValue();
                }  
            }
            totalInArray++;
        }

        return letterCount;
    }
	
	 public void printNumOfLetters() {

        int j = 0;
        
        for(int i = 0; i < innerTable.length; i++) {
            System.out.printf("%s%s%-3s", (char)(i+97),": ",innerTable[i].getTableCount());
                    
            if(j % 5 == 0 && j != 0) {
                System.out.println();
            }
            
            j++;
        }  
    }
}