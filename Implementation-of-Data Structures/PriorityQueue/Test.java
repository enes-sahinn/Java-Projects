package Lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		PriorityQueue pq1 = new PriorityQueue(1000);
		PriorityQueue pq2 = new PriorityQueue(1000);		
		String str;
		String[] lineToArray;
		
		File file = new File("C:\\data.txt"); 
		Scanner sc = new Scanner(file); 		
		while (sc.hasNextLine()) {
			str = sc.nextLine();
			lineToArray = str.split(" ");
			Passenger pssngr = new Passenger(lineToArray[0], lineToArray[1], Integer.parseInt(lineToArray[2]), lineToArray[3]);
			QueueElement elmnt = new QueueElement(pssngr, Integer.parseInt(lineToArray[2]));
			if (lineToArray[1].contentEquals("B1")) {
				pq1.enqueue(elmnt);
			}
			else if (lineToArray[1].contentEquals("B2")) {
				pq2.enqueue(elmnt);
			}
		}
		sc.close();
		System.out.println("Priority Queue B1");
		display(pq1);
		System.out.println("\nPriority Queue B2");
		display(pq2);
		
		int tourcounter = 0;
		int income = 0;
		int passengerCount;
		
		while (!(pq1.isEmpty() && pq2.isEmpty())) {
			passengerCount =0;
			while (!pq1.isEmpty() && passengerCount < 8) {
				Passenger pssngr = (Passenger)pq1.dequeue().getData();
				if (pssngr.getAge() < 65 && pssngr.getType().contentEquals("normal")) {
					income+=2;
				}
				else if (pssngr.getType().contentEquals("student")) {
					income++;
				}
				passengerCount++;
			}
			while (!pq2.isEmpty() && passengerCount < 8) {
				Passenger pssngr = (Passenger)pq2.dequeue().getData();
				if (pssngr.getAge() < 65 && pssngr.getType().contentEquals("normal")) {
					income+=2;
				}
				else if (pssngr.getType().contentEquals("student")) {
					income++;
				}
				passengerCount++;
			}
			tourcounter++;
			System.out.println("\n----------After tour " + tourcounter + "----------");
			System.out.println("Priority Queue B1");
			display(pq1);
			System.out.println("\nPriority Queue B2");
			display(pq2);			
		}
		System.out.println("\nOverall Income: " + income);				
	}
		
	public static void display(PriorityQueue queue) {
		for (int i = 0; i < queue.size(); i++) {
			Passenger p = (Passenger)queue.peek().getData();
			System.out.println(p.display());
			queue.simpleEnqueue(queue.dequeue());			
		}
	}
}
