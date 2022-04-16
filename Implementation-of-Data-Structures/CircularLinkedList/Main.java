package lab11;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Enter number of men stand in the circle: ");
		int X = scn.nextInt();
		System.out.print("\nEnter number to assign value to eliminated men's order: ");
		int Y = scn.nextInt();
		
		for (int i = X; i > 0; i--) {
			cll.add(i);
		}
		System.out.println();
		cll.display();
		System.out.println("\n");	
		System.out.println(cll.Josephus(X, Y));
	}

}
