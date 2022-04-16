package lab12;

public class LinkedQueue {
	private Node front;
	private Node rear;
	private int numberElements;;
	
	public LinkedQueue() {
		front = null;
		rear = null;
		numberElements = 0;
	}
	
	public void enqueue(Object dataToAdd) {
		if (front == null) {
			Node newNode = new Node(dataToAdd);
			front = newNode;
			rear = newNode;
		}
		else {
			Node newNode = new Node(dataToAdd);
			rear.setLink(newNode);
			rear = newNode;
		}
		numberElements++;
	}
	
	public Object dequeue() {
		if (isEmpty()) {
			System.out.println("LinedQueue is empty!");
			return null;
		}
		else {
			Object retData = front.getData();
			front = front.getLink();
			numberElements--;
			return retData;
		}
	}
	
	public Object peek() {
		if (isEmpty()) {
			System.out.println("LinkedQueue is empty!");
			return null;
		}
		else {
			return front.getData();
		}
	}
	
	public boolean isEmpty() {
		return (front == null);
	}
	
	public int size() {
		return numberElements;
	}
	
	public int median() {
		return (((int)rear.getData() - (int)front.getData()) / 2) + (int)front.getData();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
