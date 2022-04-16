package hangman;

public class DoubleLinkedList {
	private Letter head;
	private Letter tail;
	
	public DoubleLinkedList() {
		head = null;
		tail = null;
	}
	
	public void add(String dataToAdd) {
		Letter newLetter = new Letter(dataToAdd);
		if (head == null && tail == null) {
			head = newLetter;
			tail = newLetter;
		}
		else {
			tail.setNext(newLetter);
			newLetter.setPrev(tail);
			tail = newLetter;
		}
	}
	
	public void display() {
		Letter temp = head;
		while (temp != null) {
			System.out.print(temp.getLetter());
			temp = temp.getNext();
		}
	}
	
	public void delete(String dataToDelete) {
		if (head == null && tail == null) {
			System.out.println("Linked list is empty!");
		}
		else {
			if (dataToDelete.toUpperCase().compareTo("M") <= 0) {   // If the given letter is smaller than or equal to “M”
				Letter temp = head;
				while (temp != null && !temp.getLetter().equalsIgnoreCase(dataToDelete)) {
					temp = temp.getNext();
				}
				if (temp != null) {
					if (temp == head) {
						temp.getNext().setPrev(null);
						head = temp.getNext();
					}
					else {
						temp.getPrev().setNext(temp.getNext());
						temp.getNext().setPrev(temp.getPrev());
					}	
				} else {
					System.out.println("\nYou entered the same letter before!");  // If estimated letter cannot be found in the DLL.
				}
			}
			else {            										// If the given letter is greater than “M”
				Letter temp = tail;
				while (temp != null && !temp.getLetter().equalsIgnoreCase(dataToDelete)) {
					temp = temp.getPrev();
				}
				if (temp != null) {
					if (temp == tail) {		
						temp.getPrev().setNext(null);
						tail = temp.getPrev();
					}
					else {
						temp.getPrev().setNext(temp.getNext());
						temp.getNext().setPrev(temp.getPrev());
					}	
				} else {
					System.out.println("\nYou entered the same letter before!");  // If estimated letter cannot be found in the DLL.
				}
			}	
		}
	}
	
	public boolean isLetterExist(String letter) {
		boolean isLetterExist = false;		
		if (letter.toUpperCase().compareTo("M") <= 0) {  // If the given letter is smaller than or equal to “M”.
			Letter temp = head;
			while (temp != null) {
				if (temp.getLetter().equalsIgnoreCase(letter)) {
					isLetterExist = true;
				}
				temp = temp.getNext();
			} 
		} else {                                        // If the given letter is greater than “M”.
			Letter temp = tail;
			while (temp != null) {
				if (temp.getLetter().equalsIgnoreCase(letter)) {
					isLetterExist = true;
				}
				temp = temp.getPrev();
			} 
		}		
		return isLetterExist;
	}
}
