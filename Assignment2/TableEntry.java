public class TableEntry {
	//takes one new entry and sorts it out
    private int duplicateLetters;
    private int numLetterValue;
    private char letter;
    
    TableEntry(int freqLetterCount, char newLetter, int newNumLetterValue) {
        this.duplicateLetters = freqLetterCount;
        this.letter = newLetter;
        this.numLetterValue = newNumLetterValue;
    }

	//getters&setters
    public int getTableValue(){
        return this.numLetterValue;
    }
    
    public void increaseCount() {
        this.duplicateLetters++;
    }
    
    public int getTableCount() {
        return this.duplicateLetters;
    }
    
    public void resetTableCount() {
        this.duplicateLetters = 0;
    }
    
    public char getLetter() {
        return this.letter;
    }  
}