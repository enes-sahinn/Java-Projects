package cardGame;

public class Stack {
	private int top;
	private Card[] elements;
	
	Stack(int capacity) {
		elements = new Card[capacity];
		top = -1;
	}
	
	boolean isFull() {
		return (top + 1 == elements.length);
	}
	
	boolean isEmpty() {
		return (top == -1);
	}
	
	int size() {
		return top + 1;
	}
	
	void push (Card data) {
		if (isFull()) {
			System.out.println("Stack is overflow!");
		}
		else {
			top++;
			elements[top] = data;						
		}		
	}
	
	public Card pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty!");
			return null;			
		}
		else {
			Card retData = elements[top];
			top--;
			return retData;
		}
	}
	
	public Card peek() {
		if (isEmpty()) {
			System.out.println("Stack is overflow");
			return null;
		}
		else {
			return elements[top];
		}
	}
}
