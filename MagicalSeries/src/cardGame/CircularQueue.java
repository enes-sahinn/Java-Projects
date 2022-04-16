package cardGame;

public class CircularQueue {
	private Card[] elements;
	private int rear, front;

	CircularQueue(int capacity) {
		elements = new Card[capacity];
		rear = -1;
		front = 0;
	}

	boolean isEmpty() {
		return (elements[front] == null);
	}

	boolean isFull() {
		return (front == (rear + 1) % elements.length && elements[front] != null && elements[rear] != null);
	}

	int size() {
		if (rear >= front) {
			return rear - front + 1;
		} else if (elements[front] != null) {
			return elements.length - (front - rear) + 1;
		} else {
			return 0;
		}
	}

	public void enqueue(Card data) {
		if (isFull()) {
			System.out.println("Queue overflow");
		} else {
			rear = (rear + 1) % elements.length;
			elements[rear] = data;
		}
	}

	public Card dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		} else {
			Card retData = elements[front];
			elements[front] = null;
			front = (front + 1) % elements.length;
			return retData;
		}
	}

	public Card peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		} else {
			return elements[front];
		}
	}
}
