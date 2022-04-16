package hangman;

public class MultiLinkedList {
	private LetterCount head;
	
	public MultiLinkedList() {
		head = null;
	}
	
	public void add(String dataToAdd) {
		if (head == null) {
			LetterCount newNode = new LetterCount(dataToAdd.length());
			head = newNode;
			Word newNode2 = new Word(dataToAdd);
			head.setRight(newNode2);
		}
		else {
			boolean isLetterCountFound = false;  // Boolean to check the existence of the letter count(row node).
			LetterCount temp = head;
			while (temp != null && !isLetterCountFound) { 
				if (temp.getLetterCount() == dataToAdd.length()) {
					isLetterCountFound = true;  // If the letter count exist, make boolean true.							
					break;
				}			
					temp = temp.getDown();
			}
			if (isLetterCountFound) {          // If the letter count exist, add word to MLL
				Word newWord = new Word(dataToAdd);
				if (temp.getRight() == null) {                    
					temp.setRight(newWord);
				} 
				else {
					Word temp2 = temp.getRight();
					if (dataToAdd.compareTo(temp2.getWord()) < 0) { // If the right of the row is null, add word to there.
						newWord.setNext(temp2);
						temp.setRight(newWord);
					}
					else {                                          // If the right of the row is filled, add word to appropriate position.
						while (temp2.getNext() != null && dataToAdd.compareTo(temp2.getNext().getWord()) > 0) {
							temp2 = temp2.getNext();   
						}
						if (temp2.getNext() != null) {
							newWord.setNext(temp2.getNext());    
							temp2.setNext(newWord);		
						}
						else {
							temp2.setNext(newWord);
						}	 	
					}		
				}
			}
			else {    // If the letter count does not exist, add letter count and word to MLL.
				LetterCount newLetterCount = new LetterCount(dataToAdd.length());
				temp = head;
				if (dataToAdd.length() < temp.getLetterCount()) { // To check the head of MLL
					newLetterCount.setDown(temp);
					head = newLetterCount;
				}
				else {
					while (temp.getDown() != null && dataToAdd.length() > temp.getDown().getLetterCount()) { // To search appropriate position for letter count(row)
						temp = temp.getDown();
					}
					if (temp.getDown() != null) {
						newLetterCount.setDown(temp.getDown());
						temp.setDown(newLetterCount);
					}
					else {
						temp.setDown(newLetterCount);
					}
				}
				Word newWord = new Word(dataToAdd);  // In the end, add new word to the right of the new letter count.           
				newLetterCount.setRight(newWord);
			}		
		}
	}
	
	public void display() {
		if (head == null) {
			System.out.println("Linked list is empty!");
		} else {
			LetterCount temp = head;
			while (temp != null) {
				System.out.print(temp.getLetterCount() + " --> ");
				if (temp.getRight() == null) {
					System.out.println();
				} else {
					Word temp2 = temp.getRight();
					while (temp2 != null) {
						System.out.print(temp2.getWord() + ", ");
						temp2 = temp2.getNext();
					}
					System.out.println();
				}
				temp = temp.getDown();
			}
		}
	}
	
	public int size() {
		int count = 0;
		LetterCount temp = head;
		while (temp != null) {
			if (temp.getRight() != null) {
				Word temp2 = temp.getRight();
				while (temp2 != null) {
					count++;
					temp2 = temp2.getNext();
				}
			}
			temp = temp.getDown();
		}
		return count;
	}
	
	public String randomCountry(int randomNumber) {  // Returns a country randomly
		LetterCount temp = head;
		Word temp2 = temp.getRight();
		for (int i = 0; i < randomNumber; i++) {
			temp2 = temp2.getNext();
			if (temp2 == null) {
				temp = temp.getDown();
				temp2 = temp.getRight();
			}
		}
		return temp2.getWord();
	}
}
