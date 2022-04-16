package magicnumbers;

public class SingleLinkedList {
	private Node head;

	public SingleLinkedList() {
		head = null;
	}

	public void add(Object dataToAdd) {
		if (head == null) {
			Node newNode = new Node(dataToAdd);
			head = newNode;
		} else {
			Node newNode = new Node(dataToAdd);
			Node temp = head;
			while (temp.getLink() != null) {
				temp = temp.getLink();
			}
			temp.setLink(newNode);
		}
	}

	public void delete(Object dataToDelete) {
		if (head == null) {
			System.out.println("Linked List is empty.");
		}
		else {
			while ((int)head.getData() == (int)dataToDelete) {
				head = head.getLink();
			}
			Node temp = head;
			Node prev = temp;
			while (temp != null) {
				if ((int)temp.getData() == (int)dataToDelete) {
					prev.setLink(temp.getLink());
					temp = prev;
				}
				prev = temp;
				temp = temp.getLink();
			}
		}
	}
	
	public void display() {
		if (head == null) {
			System.out.print(" ");
		}
		else {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getLink();
			}
		}
	}
	
	public int size() {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			count++;
			temp = temp.getLink();
		}
		return count;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
}
