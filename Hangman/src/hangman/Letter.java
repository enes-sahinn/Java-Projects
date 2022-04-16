package hangman;

public class Letter {            // Common node class for DLL and CSLL. 
	private String letter;
	private Letter next;
	private Letter prev;
	
	public Letter(String dataToAdd) {
		letter = dataToAdd;
		next = null;
		prev = null;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public Letter getNext() {
		return next;
	}

	public void setNext(Letter next) {
		this.next = next;
	}

	public Letter getPrev() {
		return prev;
	}

	public void setPrev(Letter prev) {
		this.prev = prev;
	}
}
