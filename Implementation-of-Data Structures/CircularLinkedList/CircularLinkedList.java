package lab11;

public class CircularLinkedList {
	private Node head;
	
	public CircularLinkedList() {
		head = null;
	}
	
	public void add(Object dataToAdd) {
		if (head == null) {
			Node newNode = new Node(dataToAdd);
			head = newNode;
			head.setNext(head);
		}
		else {
			Node temp = head;
			do {
				temp = temp.getNext();
			} while (temp.getNext() != head);
			Node newNode = new Node(dataToAdd);
			newNode.setNext(head);
			temp.setNext(newNode);
			head = newNode;
		}
	}
	
	public void display() {
		if (head == null) {
			System.out.println("Linked list is empty!");
		}
		else {
			Node temp = head;
			do {
				System.out.print(temp.getData() + " ");
				temp = temp.getNext();
			} while (temp != head);
		}
	}
	
	public int size() {
		int count = 0;
		Node temp = head;
		if (head != null) {
			do {
				count++;
				temp = temp.getNext();
			} while (temp != head);
		}
		return count;
	}
	
	public void delete(Object dataToDelete) {
		if (head == null) {
			System.out.println("Linked list is empty!");
		}
		else if (head == dataToDelete && head.getNext() == head) {
			head = null;
		}
		else if (head == dataToDelete && head.getNext() != head) {
			Node temp = head;
			do {
				temp = temp.getNext();
			} while (temp.getNext() != head);
			head = head.getNext();
			temp.setNext(head);
		}
		else {
			Node prev = null;
			Node temp = head;
			do {
				if (temp == dataToDelete) {
					prev.setNext(temp.getNext());
					temp = prev;
				}
				prev = temp;
				temp = temp.getNext();
			} while (temp != head);
		}	
	}
	
	public int Josephus(int X, int Y) {
		int lastMan = 0;
		Node temp = head;                     
		do {
			temp = temp.getNext();
		} while (temp.getNext() != head);
		
		for (int i = 0; i < X - 1; i++) {    
			for (int j = 0; j < Y; j++) {
				temp = temp.getNext();
			}
			delete(temp);
		}
		lastMan = (int)head.getData();
		
		return lastMan;
	}
}
