package hangman;

public class CircularSingleLinkedList {
	private Letter head;
	
	public CircularSingleLinkedList() {
		head = null;
	}
	
	public void add(String dataToAdd) {
		if (head == null) {
			Letter newNode = new Letter(dataToAdd);
			head = newNode;
			head.setNext(head);
		}
		else {
			Letter temp = head;
			do {
				temp = temp.getNext();
			} while (temp.getNext() != head);
			Letter newNode = new Letter(dataToAdd);
			newNode.setNext(head);
			temp.setNext(newNode);
		}
	}
	
	public void display() {
		if (head == null) {
			System.out.println("Linked list is empty!");
		}
		else {
			Letter temp = head;
			do {
				if (temp.getLetter().equalsIgnoreCase("i")  ) { // Convert "Ý" to "I" while displaying
					System.out.print("I ");
				} else {
					System.out.print(temp.getLetter().toUpperCase() + " ");
				}
				temp = temp.getNext();
			} while (temp != head);
		}
	}
	
	public int size() {
		int count = 0;
		Letter temp = head;
		if (head != null) {
			do {
				count++;
				temp = temp.getNext();
			} while (temp != head);
		}
		return count;
	}
	
	public boolean isLetterExist(String letter) {  
		Letter temp = head;
		boolean isLetterExist = false;
		do {
			if (temp.getLetter().equalsIgnoreCase(letter)) {
				isLetterExist = true;
			}
			temp = temp.getNext();
		} while (temp != head);
		return isLetterExist;
	}
	
	public void putLetter(String letter, int order) {  // To write correct guess in all its correct positions
		Letter temp = head;
		for (int i = 0; i < order - 1; i++) {
			temp = temp.getNext();
		}
		temp.setLetter(letter);
	}

	public Letter getHead() {
		return head;
	}

	public void setHead(Letter head) {
		this.head = head;
	}
}
