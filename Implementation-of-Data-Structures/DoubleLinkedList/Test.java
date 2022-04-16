package DoubleLinkedList;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.add(10);
		dll.add(20);
		dll.add(30);
		dll.add(40);
		dll.add(50);
		dll.add(60);
		dll.add(70);
		dll.add(80);
		dll.add(90);
		
		dll.display1();
		System.out.println("\n");
		dll.display2();
		System.out.println("\n");
		System.out.println("The size of the double linked list is: " + dll.size());
		
		int x = 0;
		boolean flag = true;
		Scanner scn = new Scanner(System.in);
		System.out.print("\nPlease enter a number for exchanging operation: ");
		while (flag) {
			String input = scn.nextLine();
			try {
				x = Integer.parseInt(input);
				if (x <= dll.size() && x >= 1) {
					flag = false;
				}
				else {
					System.out.print("\nplease enter a number between 1 and 9: ");
				}	
			} catch (Exception e) {
				System.out.println("Invalid input.");
				System.out.print("\nplease enter a number between 1 and 9: ");
			}
		}
		System.out.println("\nSuccessful. The " + x + ".th elements have been exchanged."); 
		dll.swap(x);
		dll.display1();
	}
}
