package homework3;

import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		
		Queue q1 = new Queue(999);
		Queue q2 = new Queue(999);
		Queue Queue3 = new Queue(999);
		Queue Queue4 = new Queue(999);
		Queue q5 = new Queue(999);
		Queue q1complement = new Queue(999);
		Random rnd = new Random();
		int randomnumber, count;
		String str = "";
		
		//Randomly generated two DNA pieces
        System.out.println("Randomly generated two DNA pieces:");
		for (int i = 0; i < 21; i++) {
			randomnumber = rnd.nextInt(4) + 1;
			if      (randomnumber == 1) {q1.enqueue("A");}
			else if (randomnumber == 2) {q1.enqueue("T");}
			else if (randomnumber == 3) {q1.enqueue("G");}
			else                        {q1.enqueue("C");}
		}
		for (int i = 0; i < 21; i++) {
			randomnumber = rnd.nextInt(4) + 1;
			if      (randomnumber == 1) {q2.enqueue("A");}
			else if (randomnumber == 2) {q2.enqueue("T");}
			else if (randomnumber == 3) {q2.enqueue("G");}
			else                        {q2.enqueue("C");}
		}
		System.out.print("Queue1: ");
		for (int i = 0; i < q1.Size(); i++) {
			System.out.print(q1.peek() + " ");
			q1.enqueue(q1.dequeue());
		}		
		System.out.print("\nQueue2: ");
		for (int i = 0; i < q2.Size(); i++) {
			System.out.print(q2.peek() + " ");
			q2.enqueue(q2.dequeue());
		}
		
		//Complement of the first DNA piece
		System.out.println("\n\n*************************************************");
		System.out.println("\nComplement of the first DNA piece:");
		for (int i = 0; i < q1.Size(); i++) {
			if      (q1.peek() == "A") {q1complement.enqueue("T");}
			else if (q1.peek() == "T") {q1complement.enqueue("A");}
			else if (q1.peek() == "G") {q1complement.enqueue("C");}
			else                       {q1complement.enqueue("G");}	
			q1.enqueue(q1.dequeue());
		}		
		System.out.print("Queue1: ");
		for (int i = 0; i < q1.Size(); i++) {
			System.out.print(q1.peek() + " ");
			q1.enqueue(q1.dequeue());
		}		
		System.out.print("\nQueue3: ");
		for (int i = 0; i < q1complement.Size(); i++) {
			System.out.print(q1complement.peek() + " ");
			q1complement.enqueue(q1complement.dequeue());
		}
		
		//Amino Acids of the first DNA piece
		System.out.println("\n\n*************************************************");
		System.out.println("\nAmino Acids of the first DNA piece:");
		//amino acids are inserted into queues 
		Queue3.enqueue("AAA");  Queue4.enqueue("Lys"); 
		Queue3.enqueue("ACA");  Queue4.enqueue("Thr"); 
		Queue3.enqueue("ATA");  Queue4.enqueue("Ile"); 
		Queue3.enqueue("AGA");  Queue4.enqueue("Arg"); 
		Queue3.enqueue("CAA");  Queue4.enqueue("Gln"); 
		Queue3.enqueue("CCA");  Queue4.enqueue("Pro"); 
		Queue3.enqueue("CTA");  Queue4.enqueue("Leu"); 
		Queue3.enqueue("CGA");  Queue4.enqueue("Arg");
		Queue3.enqueue("AAC");  Queue4.enqueue("Asn");
		Queue3.enqueue("ACC");  Queue4.enqueue("Thr"); 
        Queue3.enqueue("ATC");  Queue4.enqueue("Ile"); 
        Queue3.enqueue("AGC");  Queue4.enqueue("Ser"); 
        Queue3.enqueue("CAC");  Queue4.enqueue("His"); 
        Queue3.enqueue("CCC");  Queue4.enqueue("Pro"); 
        Queue3.enqueue("CTC");  Queue4.enqueue("Leu"); 
        Queue3.enqueue("CGC");  Queue4.enqueue("Arg");
        Queue3.enqueue("AAT");  Queue4.enqueue("Asn"); 
        Queue3.enqueue("ACT");  Queue4.enqueue("Thr"); 
        Queue3.enqueue("ATT");  Queue4.enqueue("Ile"); 
        Queue3.enqueue("AGT");  Queue4.enqueue("Ser"); 
        Queue3.enqueue("CAT");  Queue4.enqueue("His"); 
        Queue3.enqueue("CCT");  Queue4.enqueue("Pro"); 
        Queue3.enqueue("CTT");  Queue4.enqueue("Leu"); 
        Queue3.enqueue("CGT");  Queue4.enqueue("Arg");
        Queue3.enqueue("AAG");  Queue4.enqueue("Lys"); 
        Queue3.enqueue("ACG");  Queue4.enqueue("Thr"); 
        Queue3.enqueue("ATG");  Queue4.enqueue("Met"); 
        Queue3.enqueue("AGG");  Queue4.enqueue("Arg"); 
        Queue3.enqueue("CAG");  Queue4.enqueue("Gln"); 
        Queue3.enqueue("CCG");  Queue4.enqueue("Pro"); 
        Queue3.enqueue("CTG");  Queue4.enqueue("Leu"); 
        Queue3.enqueue("CGG");  Queue4.enqueue("Arg");
        Queue3.enqueue("TAA");  Queue4.enqueue("STOP"); 
        Queue3.enqueue("TCA");  Queue4.enqueue("Ser"); 
        Queue3.enqueue("TTA");  Queue4.enqueue("Leu"); 
        Queue3.enqueue("TGA");  Queue4.enqueue("STOP"); 
        Queue3.enqueue("TAC");  Queue4.enqueue("Tyr"); 
        Queue3.enqueue("TAT");  Queue4.enqueue("Tyr"); 
        Queue3.enqueue("TAG");  Queue4.enqueue("STOP"); 
        Queue3.enqueue("TCC");  Queue4.enqueue("Ser");
        Queue3.enqueue("TTC");  Queue4.enqueue("Phe"); 
        Queue3.enqueue("TGC");  Queue4.enqueue("Cys"); 
        Queue3.enqueue("TCT");  Queue4.enqueue("Ser"); 
        Queue3.enqueue("TCG");  Queue4.enqueue("Ser"); 
        Queue3.enqueue("TTT");  Queue4.enqueue("Phe"); 
        Queue3.enqueue("TTG");  Queue4.enqueue("Leu"); 
        Queue3.enqueue("TGT");  Queue4.enqueue("Cys"); 
        Queue3.enqueue("TGG");  Queue4.enqueue("Trp");
        Queue3.enqueue("GAA");  Queue4.enqueue("Glu"); 
        Queue3.enqueue("GAC");  Queue4.enqueue("Asp"); 
        Queue3.enqueue("GAT");  Queue4.enqueue("Asp"); 
        Queue3.enqueue("GAG");  Queue4.enqueue("Glu"); 
        Queue3.enqueue("GCA");  Queue4.enqueue("Ala"); 
        Queue3.enqueue("GCC");  Queue4.enqueue("Ala"); 
        Queue3.enqueue("GCT");  Queue4.enqueue("Ala"); 
        Queue3.enqueue("GCG");  Queue4.enqueue("Ala");
        Queue3.enqueue("GTA");  Queue4.enqueue("Val"); 
        Queue3.enqueue("GTC");  Queue4.enqueue("Val"); 
        Queue3.enqueue("GTT");  Queue4.enqueue("Val"); 
        Queue3.enqueue("GTG");  Queue4.enqueue("Val"); 
        Queue3.enqueue("GGA");  Queue4.enqueue("Gly"); 
        Queue3.enqueue("GGC");  Queue4.enqueue("Gly"); 
        Queue3.enqueue("GGT");  Queue4.enqueue("Gly"); 
        Queue3.enqueue("GGG");  Queue4.enqueue("Gly");
		               
        for (int i = 0; i < 7; i++) {
        	str = "";  // string for combining letters
        	count = 0; //count for finding equals of amino acids in queue
        	//Finding the equal of the string in Queue3 and restoring it
			for (int j = 0; j < 3; j++) {
				str = str + q1.peek();
				q1.enqueue(q1.dequeue());
			}
			for (int j = 0; j < Queue3.Size(); j++) {
				if (str.equals(Queue3.peek())) {
					break;
				}
				else {
					Queue3.enqueue(Queue3.dequeue());
					count++;
				}
			}
			for (int j = 0; j < 64 - count; j++)  {Queue3.enqueue(Queue3.dequeue());}
			//Finding the equal of the amino acid in Queue4 and restoring it 
			for (int j = 0; j < count; j++)       {Queue4.enqueue(Queue4.dequeue());}
			q5.enqueue(Queue4.peek());
			for (int j = 0; j < 64 - count; j++)  {Queue4.enqueue(Queue4.dequeue());}			
		}       
        System.out.print("Queue1: ");
		for (int i = 0; i < q1.Size(); i++) {
			System.out.print(q1.peek() + " ");
			q1.enqueue(q1.dequeue());
		}
        System.out.print("\nQueue4: ");
        for (int i = 0; i < q5.Size(); i++) {
        	if (q5.peek().equals("STOP")) {
				System.out.print(" " + q5.peek() + "|");
				q5.enqueue(q5.dequeue());
			}
        	else {
				System.out.print(" " + q5.peek() + " |");
				q5.enqueue(q5.dequeue());
			}			
		}
        
        //Crossover of two DNA pieces
        System.out.println("\n\n*************************************************");
		System.out.println("\nCrossover of two DNA pieces:");
		System.out.print("Queue1: ");
		for (int i = 0; i < q1.Size(); i++) {
			System.out.print(q1.peek() + " ");
			q1.enqueue(q1.dequeue());
		}	
		
		System.out.print("\nQueue2: ");
		for (int i = 0; i < q2.Size(); i++) {
			System.out.print(q2.peek() + " ");
			q2.enqueue(q2.dequeue());
		}
		
		randomnumber = rnd.nextInt(20) + 1;
		System.out.println("\n\nRandomly generated crossover point: " + randomnumber);
		//All data beyond randomnumber is swapped between the two DNA sequences.
		for (int i = 0; i < randomnumber; i++) {
			q1.enqueue(q1.dequeue());
			q2.enqueue(q2.dequeue());
		}
		for (int i = 0; i < q1.Size() - randomnumber; i++) {
			q1.enqueue(q2.dequeue());
			q2.enqueue(q1.dequeue());
		}
				
		System.out.print("\nQueue1: ");
		for (int i = 0; i < q1.Size(); i++) {
			System.out.print(q1.peek() + " ");
			q1.enqueue(q1.dequeue());
		}		
		System.out.print("\nQueue2: ");
		for (int i = 0; i < q2.Size(); i++) {
			System.out.print(q2.peek() + " ");
			q2.enqueue(q2.dequeue());
		}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	}

}
