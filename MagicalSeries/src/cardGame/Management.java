package cardGame;

import java.util.Random;

public class Management {
	Random rnd = new Random();
	Stack As = new Stack(4);
	Stack n2 = new Stack(4);
	Stack n3 = new Stack(4);
	Stack n4 = new Stack(4);
	Stack n5 = new Stack(4);
	Stack n6 = new Stack(4);
	Stack n7 = new Stack(4);
	Stack n8 = new Stack(4);
	Stack n9 = new Stack(4);
	Stack n10 = new Stack(4);
	Stack J = new Stack(4);
	Stack O = new Stack(4);
	Stack K = new Stack(4);
	
	CircularQueue deck = new CircularQueue(52);
	Stack turnedOverCards = new Stack(52);
	Stack temp = new Stack(52);	
	
	// User1 Attributes
	Date bd1 = new Date(25, 01, 2000); 
	Address adr1 = new Address("Suluntepe mah.", "Mevlana cad.", 12, "Pendik", "Istanbul", "Turkey");
	Phone phone1 = new Phone("+90", 216, 3780873);
	User user1 = new User("Enes", "Sahin", bd1, "man", adr1, phone1, 0);
	// User2 Attributes
	Date bd2 = new Date(10, 15, 2000); 
	Address adr2 = new Address("Çamlýk mah.", "Kýbrýs cad.", 20, "Buca", "Izmir", "Turkey");
	Phone phone2 = new Phone("+90", 232, 3788855);
	User user2 = new User("Ahmet", "Topçu", bd2, "man", adr2, phone2, 0);
	
	User currentPlayer = user1;  // User1 starts first. 
	int step = 0;
	
	public void createCards() {  // Creation of cards
		String suits;  // String likes "HDCS", "DCSH".	 
		suits = createSuitRandomly();
		for (int i = 0; i < 4; i++) {           //letter of suits 
			Card newCard = new Card(suits.substring(0 + i, 1 + i), "A"); 
			As.push(newCard);	
		}
		suits = createSuitRandomly();
		for (int i = 0; i < 4; i++) {
			Card newCard = new Card(suits.substring(0 + i, 1 + i), "2");
			n2.push(newCard);
		}
		suits = createSuitRandomly();
		for (int i = 0; i < 4; i++) {
			Card newCard = new Card(suits.substring(0 + i, 1 + i), "3");
			n3.push(newCard);
		}
		suits = createSuitRandomly();
		for (int i = 0; i < 4; i++) {
			Card newCard = new Card(suits.substring(0 + i, 1 + i), "4");
			n4.push(newCard);
		}
		suits = createSuitRandomly();
		for (int i = 0; i < 4; i++) {
			Card newCard = new Card(suits.substring(0 + i, 1 + i), "5");
			n5.push(newCard);
		}
		suits = createSuitRandomly();
		for (int i = 0; i < 4; i++) {
			Card newCard = new Card(suits.substring(0 + i, 1 + i), "6");
			n6.push(newCard);
		}
		suits = createSuitRandomly();
		for (int i = 0; i < 4; i++) {
			Card newCard = new Card(suits.substring(0 + i, 1 + i), "7");
			n7.push(newCard);
		}
		suits = createSuitRandomly();
		for (int i = 0; i < 4; i++) {
			Card newCard = new Card(suits.substring(0 + i, 1 + i), "8");
			n8.push(newCard);
		}
		suits = createSuitRandomly();
		for (int i = 0; i < 4; i++) {
			Card newCard = new Card(suits.substring(0 + i, 1 + i), "9");
			n9.push(newCard);
		}
		suits = createSuitRandomly();
		for (int i = 0; i < 4; i++) {
			Card newCard = new Card(suits.substring(0 + i, 1 + i), "10");
			n10.push(newCard);
		}
		suits = createSuitRandomly();
		for (int i = 0; i < 4; i++) {
			Card newCard = new Card(suits.substring(0 + i, 1 + i), "J");
			J.push(newCard);
		}
		suits = createSuitRandomly();
		for (int i = 0; i < 4; i++) {
			Card newCard = new Card(suits.substring(0 + i, 1 + i), "O");
			O.push(newCard);
		}
		suits = createSuitRandomly();
		for (int i = 0; i < 4; i++)	{
			Card newCard = new Card(suits.substring(0 + i, 1 + i), "K");
			K.push(newCard);
		}
	}
	
	public String createSuitRandomly() { // returns string that includes suits randomly such as "CDSH", "HCSD".
		boolean isHAdded = false;
		boolean isDAdded = false;
		boolean isSAdded = false;
		boolean isCAdded = false;
		String randomsuits = "";
		while (randomsuits.length() != 4) {
			int number = rnd.nextInt(4) + 1;
			if (number == 1 && isHAdded == false) {
				randomsuits += "H";
				isHAdded = true;
			} else if (number == 2 && isDAdded == false) {
				randomsuits += "D";
				isDAdded = true;
			} else if (number == 3 && isSAdded == false) {
				randomsuits += "S";
				isSAdded = true;
			} else if (number == 4 && isCAdded == false) {
				randomsuits += "C";
				isCAdded = true;
			}
		}
		return randomsuits;
	}
	
	public void createDeckOfCards() { // Creation of deck with shuffled cards.
		while (!deck.isFull()) {
			int number = rnd.nextInt(13) + 1;
			if      (number == 1 && !As.isEmpty())    {deck.enqueue(As.pop());} 
			else if (number == 2 && !n2.isEmpty())    {deck.enqueue(n2.pop());}  
			else if (number == 3 && !n3.isEmpty())    {deck.enqueue(n3.pop());}
			else if (number == 4 && !n4.isEmpty())    {deck.enqueue(n4.pop());}
			else if (number == 5 && !n5.isEmpty())    {deck.enqueue(n5.pop());}
			else if (number == 6 && !n6.isEmpty())    {deck.enqueue(n6.pop());}
			else if (number == 7 && !n7.isEmpty())    {deck.enqueue(n7.pop());}
			else if (number == 8 && !n8.isEmpty())    {deck.enqueue(n8.pop());}
			else if (number == 9 && !n9.isEmpty())    {deck.enqueue(n9.pop());}
			else if (number == 10 && !n10.isEmpty()) {deck.enqueue(n10.pop());} 
			else if (number == 11 && !J.isEmpty())     {deck.enqueue(J.pop());} 
			else if (number == 12 && !O.isEmpty())     {deck.enqueue(O.pop());}
			else if (number == 13 && !K.isEmpty())     {deck.enqueue(K.pop());}
		}
	}
	
	public boolean isThereRelation(Stack stack) {  // To see if there is a relation between topcard and previos one.
		boolean isThereRelation = true;
		if (stack.size() > 1) {  // condition to ensure that the player turns over a card when he has 1 card.
			Card topCard = stack.pop();
			if (!(topCard.getSuit().equals(stack.peek().getSuit()) || topCard.getRank().equals(stack.peek().getRank()))) {
				isThereRelation = false; // If there is NO relation make boolean false.
			}
			stack.push(topCard);
		}
		return isThereRelation;	
	}
	
	public int calculateScore(Stack stack) { // Calculation of score
		int score = 0;
		while (!stack.isEmpty()) {
			temp.push(stack.pop());
			if (stack.size() > 0) {
				if (temp.peek().getSuit().equals(turnedOverCards.peek().getSuit())) {
					score++;     // If there is a same suit
				} else if (temp.peek().getRank().equals(turnedOverCards.peek().getRank())) {
					score += 3;  // If there is a same rank
				}
			}
		}
		while (!temp.isEmpty()) {
			temp.pop();
		}
		return score;
	}
	
	public void update() {
		if (!isThereRelation(turnedOverCards)) { // If there is no relation change the current player.
			if (currentPlayer == user1) {
				user1.setScore(user1.getScore() + calculateScore(turnedOverCards));
				currentPlayer = user2;
			} else {
				user2.setScore(user2.getScore() + calculateScore(turnedOverCards));
				currentPlayer = user1;
			}
		} 
		turnedOverCards.push(deck.dequeue());  // Turn over card from deck to user stack.
		step++;
	}
	
	public void draw() {   // Print part of the game.
		System.out.println("Step: " + step);
		if (currentPlayer.getName().equals("Enes")) {
			System.out.print(currentPlayer.getName() + ":  Stack - ");
		} else {
			System.out.print(currentPlayer.getName() + ": Stack - ");
		}
		while (!turnedOverCards.isEmpty()) {
			System.out.print(turnedOverCards.peek().getSuit() + turnedOverCards.peek().getRank() + " ");
			temp.push(turnedOverCards.pop());
		}
		while (!temp.isEmpty()) {
			turnedOverCards.push(temp.pop());
		}
		for (int i = 0; i < 25 - turnedOverCards.size() * 2 - (turnedOverCards.size() - 1); i++) {
			System.out.print(" ");
		}
		System.out.print(user1.getName() + " Score: " + user1.getScore() + "        " + user2.getName() + " Score: " + user2.getScore() + "\n\n");
	}
	
	public void printScores() {  
		System.out.println(user1.getName() + " (User1) Score: " + user1.getScore());
		System.out.println(user2.getName() + "(User2) Score: " + user2.getScore());
		if      (user1.getScore() > user2.getScore()) {System.out.println("Winner: " +  user1.getName());}
		else if (user1.getScore() < user2.getScore()) {System.out.println("Winner: " +  user2.getName());}
		else                                          {System.out.println("The game is a draw.");}
		
	}
	
	public void run() {
		createCards();
		createDeckOfCards();
		while (!deck.isEmpty() && user1.getScore() < 10 && user2.getScore() < 10) {
			update();
			draw();
		}
		printScores();
	}
}
