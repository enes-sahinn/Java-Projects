package homework3;

public class Queue {
	private int rear, front;
	private Object[] elements;
	
	Queue(int capacity){
		elements = new Object[capacity];
		rear = -1;
		front = 0;
	}
	
	boolean isFull() {
		return (rear + 1 == elements.length);
	}
	
	boolean isEmpty() {
		return (rear < front);
	}
	
	int Size() {
		return (rear - front + 1);
	}
	
	void enqueue(Object data) {
		if (isFull()) {
			System.out.println("Queue overflow");
		}
		else {
			rear++;
			elements[rear] = data;
		}
	}
	
	Object dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return null;
		}
		else {
			Object retData = elements[front];
			elements[front] = null;
			front++;
			return retData;
		}
	}
	
	Object peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		else {
			return elements[front];
		}
	}
}
