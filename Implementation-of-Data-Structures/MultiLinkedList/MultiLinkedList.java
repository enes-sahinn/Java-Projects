package lab10;

public class MultiLinkedList {
	private RowNode head;
	
	public MultiLinkedList() {
		head = null;
	}
	
	public void addRowNumber(Object dataToAdd) {
		if (head == null) {
			RowNode newNode = new RowNode(dataToAdd);
			head = newNode;
		}
		else {
			RowNode newNode = new RowNode(dataToAdd);
			RowNode temp = head;
			while (temp.getDown() != null) {
				temp = temp.getDown();
			}
			temp.setDown(newNode);
		}
	}
	
	public void addRowElement(Object rowNumber, Object rowElement) {
		if (head == null) {
			System.out.println("Add a row number before add row element!");
		}
		else {
			RowNode temp = head;
			while (temp != null) {
				if (temp.getRowNumber() == rowNumber) {
					RowElement newNode = new RowElement(rowElement);
					if (temp.getRight() == null) {
						temp.setRight(newNode);
					}
					else {
						RowElement temp2 = temp.getRight(); 
						while (temp2.getNext() != null) {
							temp2 = temp2.getNext();
						}
						temp2.setNext(newNode);
					}
				}
				temp = temp.getDown();
			}
		}
	}
	
	public void display() {
		if (head == null) {
			System.out.println("Linked list is empty!");
		}
		else {
			RowNode temp = head;
			while (temp != null) {
				System.out.print(temp.getRowNumber() + " --> ");
				if (temp.getRight() == null) {
					System.out.println();
				}
				else {
					RowElement temp2 = temp.getRight();
					while (temp2 != null) {
						System.out.print(temp2.getNumber() + " ");
						temp2 = temp2.getNext();
					}
					System.out.println();
				}
				temp = temp.getDown();
			}
		}
	}
	
	public int rowSize() {
		int count = 0;
		RowNode temp = head;
		while (temp != null) {
			count++;
			temp = temp.getDown();
		}
		return count;
	}
	
	public boolean isSquareMatrix() {
		boolean isSquareMatrix = true; 
		if (head == null) {
			System.out.println("Linked list is empty!");
		}
		else {
			RowNode temp = head;
			while (temp != null) {
				if (temp.getRight() != null) {
					RowElement temp2 = temp.getRight();
					int count = 0;
					while (temp2 != null) {
						count++;
						temp2 = temp2.getNext();
					}
					if (count != rowSize()) {
						isSquareMatrix = false;
					}
				}
				temp = temp.getDown();
			}
		}
		return isSquareMatrix;
	}
		
	public boolean isScalarMatrix() {
		boolean isScalarMatrix = true;
		if (isSquareMatrix()) {			
			RowNode temp = head;
			Object number = temp.getRight().getNumber();
			while (temp != null) {
				RowElement temp2 = temp.getRight();
				int count = 0;
				while (temp2 != null) {
					if (count == (int)temp.getRowNumber()) {
						if (temp2.getNumber() != number) {           
							isScalarMatrix = false;
						}
					}
					else {
						if ((int)temp2.getNumber() != 0) {
							isScalarMatrix = false;
						}
					}
					temp2 = temp2.getNext();
					count++;
				}
				temp = temp.getDown();
			}		
		}
		else {
			isScalarMatrix = false;
		}
		return isScalarMatrix;
	}
}
