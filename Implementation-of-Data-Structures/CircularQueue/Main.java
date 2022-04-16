package lab6;

public class Main {

	public static void main(String[] args) {
		CircularQueue cq1 = new CircularQueue(10);
		CircularQueue cq2 = new CircularQueue(10);
		int step = 1;
		int number1 = 0; 
		int number2 = 0;
		int result;
		int size;
		cq1.enqueue(14);  cq1.enqueue(20);   cq1.enqueue(13);  cq1.enqueue(7);    cq1.enqueue(8);   
		cq1.enqueue(6);   cq1.enqueue(11);   cq1.enqueue(9);   cq1.enqueue(3);    cq1.enqueue(5);   

		cq2.enqueue("+"); cq2.enqueue("+"); cq2.enqueue("-"); cq2.enqueue("*");   cq2.enqueue("+");   
		cq2.enqueue("-"); cq2.enqueue("*"); cq2.enqueue("+"); cq2.enqueue("+");
		
		System.out.println("\tfront\t\t\t" + "    " + "rear");		
		System.out.print("Queue1: ");
		for (int i = 0; i < cq1.Size(); i++) {
			System.out.print(cq1.peek() + "  ");
			cq1.enqueue(cq1.dequeue());
		}
		
		System.out.print("\nQueue2: ");
		for (int i = 0; i < cq2.Size(); i++) {
			System.out.print(cq2.peek() + "  ");
			cq2.enqueue(cq2.dequeue());
		}
		System.out.print("\n----------------------------------------");
		
		size = cq2.Size();
		for (int i = 0; i < size; i++) {
			System.out.println("\n\nStep " + step + ":");
			number1 = (int)cq1.peek();
			cq1.dequeue();
			number2 = (int)cq1.peek();
			cq1.dequeue();
			
			if (cq2.peek().equals("+"))      {result = number1 + number2;}
			else if (cq2.peek().equals("-")) {result = number1 - number2;}
			else                            {result = number1 * number2;}
			cq2.dequeue();
			cq1.enqueue(result);
			step++;
			
			System.out.print("Queue1: ");
			for (int j = 0; j < cq1.Size(); j++) {
				System.out.print(cq1.peek() + "  ");
				cq1.enqueue(cq1.dequeue());
			}
			
			System.out.print("\nQueue2: ");
			for (int j = 0; j < cq2.Size(); j++) {
				System.out.print(cq2.peek() + "  ");
				cq2.enqueue(cq2.dequeue());
			}			
		}
	}
}

