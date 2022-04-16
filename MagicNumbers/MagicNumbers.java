package magicnumbers;

import java.util.Random;

public class MagicNumbers {
	//
	SingleLinkedList sll1 = new SingleLinkedList();
	SingleLinkedList sll2 = new SingleLinkedList();
	SingleLinkedList sll3 = new SingleLinkedList();
	boolean isTriple = false;

	public void fillLinkedList() { // Creating random numbers for list and number.
		Random rnd = new Random();
		int number = rnd.nextInt(5) + 1;
		int listnumber;
		do {
			listnumber = rnd.nextInt(3) + 1;
		} while ((sll1.size() == 8 && listnumber == 1) || (sll2.size() == 8 && listnumber == 2)
				|| (sll3.size() == 8 && listnumber == 3));
		switch (listnumber) {
		case 1: {
			sll1.add(number);
			break;
		}
		case 2: {
			sll2.add(number);
			break;
		}
		case 3: {
			sll3.add(number);
			break;
		}
		}
	}

	public int calculateUserTurn() { // To determine who is next
		int totalSize = sll1.size() + sll2.size() + sll3.size();
		if (totalSize % 2 == 1) {
			return 1;
		} else {
			return 2;
		}
	}

	public void print() { // For print linked lists and winner at the end of the game.
		System.out.println("User" + calculateUserTurn() + ":");
		System.out.print("Sll1: ");
		sll1.display();
		System.out.print("\nSll2: ");
		sll2.display();
		System.out.print("\nSll3: ");
		sll3.display();
		System.out.println("\n");
		checkHorizontally(sll1);
		checkHorizontally(sll2);
		checkHorizontally(sll3);
		checkVertically();
		cheackDiagonally();
	}

	public void run() { // Main function that called from the Test class
		while ((sll1.size() < 8 || sll2.size() < 8 || sll3.size() < 8) && !isTriple) {
			fillLinkedList();
			print();
		}
		if (isTriple == false) {
			System.err.println("Tie");
		}
	}

	public void checkHorizontally(SingleLinkedList sll) { // To check horizontally.
		Node temp1 = sll.getHead();
		Node temp2 = temp1;
		Node temp3 = temp2;
		if (sll.size() >= 3) {
			while (temp1 != null) {
				if (((int) temp1.getData() - 1 == (int) temp2.getData()
						&& (int) temp2.getData() - 1 == (int) temp3.getData())
						|| ((int) temp1.getData() + 1 == (int) temp2.getData()
								&& (int) temp2.getData() + 1 == (int) temp3.getData())) {
					isTriple = true;
					System.out.println("Triple consecutive sequence is created horizontally: " + temp3.getData() + " " + temp2.getData() + " " + temp1.getData());
					System.err.println("Winner: User" + calculateUserTurn());
			
				}
				temp3 = temp2;
				temp2 = temp1;
				temp1 = temp1.getLink();
			}
		}
	}

	public void checkVertically() { // To check vertically.
		Node temp1 = sll1.getHead();
		Node temp2 = sll2.getHead();
		Node temp3 = sll3.getHead();
		if (!(sll1.getHead() == null || sll2.getHead() == null || sll3.getHead() == null)) {
			while (!(temp1 == null || temp2 == null || temp3 == null)) {
				if (((int) temp1.getData() - 1 == (int) temp2.getData()
						&& (int) temp2.getData() - 1 == (int) temp3.getData())
						|| ((int) temp1.getData() + 1 == (int) temp2.getData()
								&& (int) temp2.getData() + 1 == (int) temp3.getData())) {
					isTriple = true;
					System.out.println("Triple consecutive sequence is created vertically: " + temp1.getData() + " " + temp2.getData() + " " + temp3.getData());
					System.err.println("Winner: User" + calculateUserTurn());
				}
				temp1 = temp1.getLink();
				temp2 = temp2.getLink();
				temp3 = temp3.getLink();
			}
		}
	}

	public void cheackDiagonally() { // To check diagonally. 
		Node temp1 = sll1.getHead(); // From top left to bottom right.
		Node temp2 = sll2.getHead();
		Node temp3 = sll3.getHead();
		if ((sll1.size() >= 1 && sll2.size() >= 2 && sll3.size() >= 3)) {
			temp2 = temp2.getLink();
			for (int i = 0; i < 2; i++) {
				temp3 = temp3.getLink();
			}
			while (!(temp1 == null || temp2 == null || temp3 == null)) {
				if (((int) temp1.getData() - 1 == (int) temp2.getData() && (int) temp2.getData() - 1 == (int) temp3.getData()) || 
					((int) temp1.getData() + 1 == (int) temp2.getData() && (int) temp2.getData() + 1 == (int) temp3.getData())) {
					isTriple = true;
					System.out.println("Triple consecutive sequence is created diagonally: " + temp1.getData() + " " + temp2.getData() + " " + temp3.getData());
					System.err.println("Winner: User" + calculateUserTurn());
					
				}
				temp1 = temp1.getLink();
				temp2 = temp2.getLink();
				temp3 = temp3.getLink();
			}
		}
		temp1 = sll1.getHead();     // From top right to bottom left.
		temp2 = sll2.getHead();
		temp3 = sll3.getHead();
		if (sll1.size() >= 3 && sll2.size() >= 2 && sll3.size() >= 1) {
			for (int i = 0; i < 2; i++) {
				temp1 = temp1.getLink();
			}
			temp2 = temp2.getLink();
			while (!(temp1 == null || temp2 == null || temp3 == null)) {
				if ((((int) temp1.getData() - 1 == (int) temp2.getData() && (int) temp2.getData() - 1 == (int) temp3.getData()) || 
					((int) temp1.getData() + 1 == (int) temp2.getData() && (int) temp2.getData() + 1 == (int) temp3.getData())) && !isTriple) {
					isTriple = true;
					System.out.println("Triple consecutive sequence is created diagonally: " + temp1.getData() + " " + temp2.getData() + " " + temp3.getData());
					System.err.println("Winner: User" + calculateUserTurn());
				}
				temp1 = temp1.getLink();
				temp2 = temp2.getLink();
				temp3 = temp3.getLink();
			}
		}
	}
}
