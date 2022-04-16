package DoubleLinkedList;

public class DoubleLinkedList {
	private Node head;
	private Node tail;
	
	public DoubleLinkedList() {
		head= null;
		tail = null;
	}
	
	public void add(Object dataToAdd) {
		if (head == null && tail == null) {
			Node newNode = new Node(dataToAdd);
			head = newNode;
			tail = newNode;
		}
		else {
			Node newNode = new Node(dataToAdd);
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}
	}
	
	public int size() {
		int counter = 0;
		Node temp = head;
		while (temp != null) {
			counter++;
			temp = temp.getNext();
		}
		return counter;
	}
	
	public void display1() {
		System.out.println("From head to tail:");
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
	}
	
	public void display2() {
		System.out.println("From tail to head:");
		Node temp = tail;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getPrev();
		}
	}
	
	public void swap(int x) {
		Object obj;
		Node temp = head;
		Node temp2 = tail; 
		for (int i = 0; i < x - 1; i++) {
			temp = temp.getNext();
			temp2 = temp2.getPrev();
		}
		obj = temp.getData();
		temp.setData(temp2.getData());
		temp2.setData(obj);		
	}	
}
