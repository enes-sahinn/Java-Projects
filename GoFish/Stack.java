
public class Stack {
	private int top;
	private Object[] elements;
	
	Stack(int capacity){
		elements = new Object [capacity];
		top = -1;
	}
	
	boolean isFull() {
		return (top + 1 == elements.length);
	}
	
	boolean isEmpty() {
		return ( top == -1);
	}
	
	int size() {
		return top + 1;
	}
	
	void push (Object data) {
		if (isFull()) {
			System.out.println("stack is overflow");
		}
		else {
			top++;
			elements[top] = data;						
		}		
	}
	
	Object pop() {
		if (isEmpty()) {
			System.out.println("stack is empty");
			return null;			
		}
		else {
			Object retData = elements[top];
			top--;
			return retData;
		}
	}
	
	Object peek() {
		if (isEmpty()) {
			System.out.println("stack is overflow");
			return null;
		}
		else {
			return elements[top];
		}
	}
}
