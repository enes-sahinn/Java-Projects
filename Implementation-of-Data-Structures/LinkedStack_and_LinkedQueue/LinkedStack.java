package lab12;

public class LinkedStack {
	private Node top;
	private int numberElements;
	
	public LinkedStack() {
		top = null;
		numberElements = 0;
	}
	
	public void push(Object dataToAdd) {
		Node newNode = new Node(dataToAdd);
		newNode.setLink(top);
		top = newNode;
		numberElements++;
	}
	
	public Object pop() {
		if (isEmpty()) {
			System.out.println("LinkedStack is empty!");
			return null;
		}
		else {
			Object retData = top.getData();
			top = top.getLink();
			numberElements--;
			return retData;
		}
	}
	
	public Object peek() {
		if (isEmpty()) {
			//System.out.println("LinkedStack is empty!");
			return null;
		}
		else {
			return top.getData();
		}
	}
		
	public boolean isEmpty() {
		return (top == null);
	}
	
	public int size() {
		return numberElements;
	}	
}
