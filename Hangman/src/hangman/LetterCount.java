package hangman;

public class LetterCount {    // Row node class for MLL
	private int letterCount;
	private LetterCount down;
	private Word right;

	public LetterCount(int dataToAdd) {
		letterCount = dataToAdd;
		down = null;
		right = null;	
	}

	public int getLetterCount() {
		return letterCount;
	}

	public void setLetterCount(int LetterCount) {
		this.letterCount = LetterCount;
	}

	public LetterCount getDown() {
		return down;
	}

	public void setDown(LetterCount down) {
		this.down = down;
	}

	public Word getRight() {
		return right;
	}

	public void setRight(Word right) {
		this.right = right;
	}
}
