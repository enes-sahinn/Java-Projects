import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Define stacks
		Stack s1 = new Stack(24);             
		Stack temps1 = new Stack (24);
		Stack s2 = new Stack(24);
		Stack temps2 = new Stack (24);
		Stack s3 = new Stack(24);
		Stack temps3 = new Stack (24);
		Stack n1 = new Stack(4);
		Stack n2 = new Stack(4);
		Stack n3 = new Stack(4);
		Stack n4 = new Stack(4);
		Stack n5 = new Stack(4);
		Stack n6 = new Stack(4);
		Random rnd = new Random(); 
		Scanner scn = new Scanner(System.in); 
		int number;
		int book1 = 0, book2 = 0, turn = 1; 
		String ask = "You ask";
		//Number stacks
		for (int i = 0; i < 4; i++)  n1.push(1); 
		for (int i = 0; i < 4; i++)  n2.push(2); 
		for (int i = 0; i < 4; i++)  n3.push(3); 
		for (int i = 0; i < 4; i++)  n4.push(4); 
		for (int i = 0; i < 4; i++)  n5.push(5); 
		for (int i = 0; i < 4; i++)  n6.push(6); 
		// Assign number randomly for table stack(s3)
		while(!(s3.isFull())) {
			number = rnd.nextInt(6) + 1;
			if (!(n1.isEmpty()) &&(number == (int)n1.peek()))   {s3.push(n1.pop());}
			if (!(n2.isEmpty()) &&(number == (int)n2.peek()))   {s3.push(n2.pop());}
			if (!(n3.isEmpty()) &&(number == (int)n3.peek()))   {s3.push(n3.pop());}
			if (!(n4.isEmpty()) &&(number == (int)n4.peek()))   {s3.push(n4.pop());}
			if (!(n5.isEmpty()) &&(number == (int)n5.peek()))   {s3.push(n5.pop());}
			if (!(n6.isEmpty()) &&(number == (int)n6.peek()))   {s3.push(n6.pop());}
		}		
		//Cards are dealt to the players
		for (int i = 0; i < 7; i++) {s1.push(s3.pop());}
		for (int i = 0; i < 7; i++) {s2.push(s3.pop());}		
		boolean isFound = true, randomcheck = true, inputcheck = true, firstcheck = true;
		int spacecount1 = 15, spacecount2 = 15;
		//GAME CIRCUIT
		while(!s1.isEmpty() && !s2.isEmpty()) {
			//  Designing the menu
			System.out.println("Turn: " + turn + "                                                     Table");		
			System.out.print("You:       ");
			while (!s1.isEmpty()) {
				System.out.print(s1.peek() + " ");
				temps1.push(s1.pop());
			}
			while (!(temps1.isEmpty())) s1.push(temps1.pop());				
			
			for (int i = 0; i < spacecount1; i++) {
				System.out.print(" ");
			}
			System.out.print("book: " + book1 + "             ");
			while(!(s3.isEmpty())) {
	 			System.out.print(s3.peek() + " ");
				temps3.push(s3.pop());			
			}
			while (!temps3.isEmpty()) s3.push(temps3.pop());
			
			System.out.println();
			System.out.print("Computer:  ");
			while (!s2.isEmpty()) {
				System.out.print(s2.peek() + " ");
				temps2.push(s2.pop());
			}
			while(!temps2.isEmpty()) s2.push(temps2.pop());
			
			for (int i = 0; i < spacecount2; i++) {
				System.out.print(" ");
			}
			System.out.println("book: " + book2);
			System.out.println();
				  
			int input = 0;
			int count = 0; 
			int checknumber = 0;
			inputcheck = true;
			if (isFound == true) {					
				//First checking for player
				while(!s1.isEmpty()) {		
					checknumber = (int)s1.peek();
					while (!s1.isEmpty()) {
						if ((int)s1.peek() == checknumber) {
							count++;
						}
						temps1.push(s1.pop());	
					}
					while (!(temps1.isEmpty())) s1.push(temps1.pop());
					
					if (count == 4) {
						System.out.print("Book is created >>  ");
						for (int i = 0; i < 4; i++) {System.out.print(checknumber + " ");}
						System.out.println();
						while (!s1.isEmpty()) {
							if ((int)s1.peek() == checknumber) {
								s1.pop();
								spacecount1+=2;
							}
							else {
								temps1.push(s1.pop());
							}				
						}
						while (!(temps1.isEmpty())) s1.push(temps1.pop());
						book1++;
						break;
					}
					temps2.push(s1.pop());
					count = 0;
					}
				while (!(temps2.isEmpty())) s1.push(temps2.pop());	
				 
				// input checking
				while(inputcheck) {
					System.out.print(ask + ":  ");
					input = scn.nextInt();				
					while(!s1.isEmpty()) {
						if (input == (int)s1.peek()) {
							inputcheck = false;
						}	
						temps1.push(s1.pop());
					}
					if (inputcheck == true) {
						System.out.println("  (You can't ask number that you do not have!)");
					}
					while(!temps1.isEmpty()) s1.push(temps1.pop());
				}	
				System.out.println();
				
				// Transferring cards after input checking
				isFound = false;
				ask = "Computer ask";
				while(!s2.isEmpty()) {
					if ((int)s2.peek() == input) {
						s1.push(s2.pop());
						spacecount1-=2;
						spacecount2+=2;
						isFound = true;
					ask = "You ask";
					}
					else {
						temps2.push(s2.pop());
					}
				}
				while(!temps2.isEmpty()) s2.push(temps2.pop());
				//Go Fish
				if (isFound == false) {
					System.out.println("Computer says “Go Fish”");
					s1.push(s3.pop());	
					spacecount1-=2;
				}
				// Check book
				count = 0;
				while(!s1.isEmpty()) {
					if ((int)s1.peek() == input) {
						count++;
					}
					temps1.push(s1.pop());
				}
				while (!(temps1.isEmpty())) s1.push(temps1.pop());
				
				if (count == 4) {
					System.out.print("Book is created >>  ");
					for (int i = 0; i < 4; i++) {System.out.print(input + " ");}
					while (!s1.isEmpty()) {
						if ((int)s1.peek() == input) {
							s1.pop();
							spacecount1+=2;
						}
						else {
							temps1.push(s1.pop());
						}				
					}
					while (!(temps1.isEmpty())) s1.push(temps1.pop());
					book1++;
				}				
				System.out.println();
				System.out.println("****************************************************************************");
				turn++;
			}
			
			else {
				//First checking for computer
				while(!s2.isEmpty()) {		
					checknumber = (int)s2.peek();
					while (!s2.isEmpty()) {
						if ((int)s2.peek() == checknumber) {
							count++;
						}
						temps2.push(s2.pop());	
					}
					while (!(temps2.isEmpty())) s2.push(temps2.pop());
					
					if (count == 4) {
						System.out.println();
						System.out.print("Book is created >>  ");
						for (int i = 0; i < 4; i++) {System.out.print(checknumber + " ");}
						System.out.println();
						while (!s2.isEmpty()) {
							if ((int)s2.peek() == checknumber) {
								s2.pop();
								spacecount2+=2;
							}
							else {
								temps2.push(s2.pop());
							}				
						}
						while (!(temps2.isEmpty())) s2.push(temps2.pop());
						book2++;
						break;
					}
					temps1.push(s2.pop());
					count = 0;
					}
				while (!(temps1.isEmpty())) s2.push(temps1.pop());	
								
				// Random number for computer
				randomcheck = true;
				input = 0;
				while(randomcheck) {
					input = rnd.nextInt(6) + 1;
					while(!s2.isEmpty()) {
						if (input == (int)s2.peek()) {
							randomcheck = false;
						}
						temps2.push(s2.pop());
					}
					while(!temps2.isEmpty()) s2.push(temps2.pop());
				}
				System.out.print(ask + ":  " + input);
				
				// Transferring cards after random number checking
				isFound = true;
				ask = "You ask";
				while(!s1.isEmpty()) {
					if ((int)s1.peek() == input) {
						s2.push(s1.pop());
						spacecount1+=2;
						spacecount2-=2;
						isFound = false;
						ask = "Computer ask";
					}
					else {
						temps1.push(s1.pop());
					}
				}
				while(!temps1.isEmpty()) s1.push(temps1.pop());				
				//Go Fish
				if (isFound == true) {
					System.out.println();
					System.out.println("You says “Go Fish”");
					s2.push(s3.pop());
					spacecount2-=2;
				}
				// Check book
				while(!s2.isEmpty()) {
					if ((int)s2.peek() == input) {
						count++;
					}
					temps2.push(s2.pop());
				}
				while (!(temps2.isEmpty())) s2.push(temps2.pop());

				if (count == 4) {
					System.out.println();
					System.out.print("Book is created >>  ");
					for (int i = 0; i < 4; i++) {System.out.print(input + " ");}
					while (!s2.isEmpty()) {
						if ((int)s2.peek() == input) {
							s2.pop();
							spacecount2+=2;
						}
						else {
							temps2.push(s2.pop());
						}				
					}
					while (!(temps2.isEmpty())) s2.push(temps2.pop());
					book2++;
				}			
				System.out.println();
				System.out.println();
				System.out.println("****************************************************************************");
				turn++;
			}			
		}
		//End of the game
		if (book1 > book2) {
			System.out.println();
			System.out.println("WINNER: YOU");	
			System.out.println("SCORE IS: " + book1 +" - " + book2);
		}
		else if (book1 < book2){
			System.out.println();
			System.out.println("WINNER: COMPUTER");
			System.out.println("SCORE IS: " + book1 +" - " + book2);
		}
		else if (book1 == book2) {
			System.out.println();
			System.out.println("THERE IS NO WINNER");
			System.out.println("SCORE IS: " + book1 +" - " + book2);
		}		
	}
}
