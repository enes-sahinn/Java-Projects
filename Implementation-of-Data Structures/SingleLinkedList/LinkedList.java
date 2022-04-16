package lab8;

public class LinkedList {
	
	private Node head = null;
	public void add(Object dataToAdd) {
		if (head == null) {
			Node newnode = new Node(dataToAdd);
			head = newnode;
		}
		else {
			Node temp = head;
			while(temp.getLink() != null) {
				temp = temp.getLink();
			}
			Node newnode = new Node(dataToAdd);
			temp.setLink(newnode);
		}
	}
	
	public void delete(Object dataToDelete) {
		if (head == null) {
			System.out.println("Linked List is empty");
		}
		else {
			while((int)head.getData() == (int)dataToDelete) {
				head = head.getLink();
			}
		}
		Node temp = head;
		Node previous = null;
		while(temp != null) {
			if ((int) temp.getData() == (int)dataToDelete) {
				previous.setLink(temp.getLink());
				temp = previous;
			}
			previous = temp;
			temp = temp.getLink();
		}
	}
	
	public void display() {
		if (head == null) {
			System.out.println("Linked List is empty");
		}
		else {
			System.out.print("Randomly generated single linked list:\t");
			Node temp = head;
			while(temp != null) {
				System.out.print(" " + temp.getData());
				temp = temp.getLink();
			}
		}
	}
	
	public void barGraph() {
		if (head == null) {
			System.out.println("Linked List is empty");
		}
		else {
			int counta = 0;		
			int countb = 0;
			int countc = 0;
			int countd = 0;
			int counte = 0;
			Node temp = head;
			while (temp != null) {
				Object result = temp.getData();
				switch ((char) result) {
				case 'A': {
					counta++;
					break;
				}
				case 'B': {
					countb++;
					break;
				}
				case 'C': {
					countc++;
					break;
				}
				case 'D': {
					countd++;
					break;
				}
				case 'E': {
					counte++;
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + result);
				}
				temp = temp.getLink();
			}
			System.out.println("\nBar Graph");
			System.out.print("A ");
			for (int i = 0; i < counta; i++) {
				System.out.print("*");
			}
			System.out.print("\nB ");
			for (int i = 0; i < countb; i++) {
				System.out.print("*");
			}
			System.out.print("\nC ");
			for (int i = 0; i < countc; i++) {
				System.out.print("*");
			}
			System.out.print("\nD ");
			for (int i = 0; i < countd; i++) {
				System.out.print("*");
			}
			System.out.print("\nE ");
			for (int i = 0; i < counte; i++) {
				System.out.print("*");
			}		 
		}	 
	}	
}
