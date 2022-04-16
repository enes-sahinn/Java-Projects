package lab8;

import java.util.Random;

public class Main {
	
	private Node head = null;
	 
	public static void main(String[] args) {
		LinkedList sll = new LinkedList();
		Random rnd = new Random();
		for (int i = 0; i < 16; i++) {
			int number = rnd.nextInt(7) - 1;
			if (number == 1) {
				sll.add('A');
			}
			else if (number == 2) {
				sll.add('B');	
			}
			else if (number == 3) {
				sll.add('C');	
			}
			else if (number == 4) {
				sll.add('D');	
			}
			else {
				sll.add('E');
			}
		}		 
		sll.display();
		sll.barGraph();
	}
	

}
