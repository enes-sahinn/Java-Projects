package lab12;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		LinkedStack LS = new LinkedStack();
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter expression with using \"(\" and \")\": ");
		boolean isTrue = true;
		String expression = scn.nextLine();
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '(') {
				LS.push('(');
			}	
			else if (expression.charAt(i) == ')') {
				if (LS.peek() == null) {
					isTrue = false;
				}
				else if ((char)LS.peek() == '(') {
					LS.pop();
				}
			}
		} 
		scn.close();
		if (LS.peek() != null) {
			isTrue = false;
		}
		System.out.println(isTrue);
		
		System.out.println("\n----------------------------------");
		LinkedQueue LQ = new LinkedQueue();
		LQ.enqueue(10);
		LQ.enqueue(20);
		LQ.enqueue(30);
		LQ.enqueue(40);
		LQ.enqueue(50);
		LQ.enqueue(60);
		System.out.println("The median of the linked queue is:");
		System.out.println(LQ.median());
	}
}
