package hangman;

public class SingleLinkedList {
	private Player head;
	
	public SingleLinkedList() {
		head = null;
	}
	
	public void add(String dataToAdd) {
		Player newPlayer = new Player(dataToAdd);
		if (head == null) {
			head = newPlayer;	
		}
		else if (newPlayer.getScore() > head.getScore()) { // To check the head
			newPlayer.setNext(head);
			head = newPlayer;
		}
		else {
			Player temp = head;	      
			while (temp.getNext() != null && newPlayer.getScore() <= temp.getNext().getScore()) { // To add player sequentially
				temp = temp.getNext();
			}
			newPlayer.setNext(temp.getNext());
			temp.setNext(newPlayer);
		}		 
	}
	
	public void displayTop10Scores() {
		if (head == null) {
			System.out.println("Linked List is empty");
		}
		else {
			System.out.println("HIGH SCORE TABLE");
			Player temp = head;
			for (int i = 1; i <= 10; i++) {
				System.out.println(i + "-) " + temp.getName() + " -> " + temp.getScore());
				temp = temp.getNext();
			}
		}
	}

	public Player getHead() {
		return head;
	}

	public void setHead(Player head) {
		this.head = head;
	}	
}
