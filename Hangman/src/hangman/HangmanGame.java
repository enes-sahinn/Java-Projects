package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
	
	int randomNumber; 			// For random country
	int lives = 6; 				// Lives of player
	String inputLetter; 		// For input from the player
	Player player; 			    // Current player
	boolean isInputLetterTrue;  // For check the correctness of input letter
	
	private File file;
	private Scanner scn;
	
	private SingleLinkedList sll = new SingleLinkedList();
	private DoubleLinkedList dll = new DoubleLinkedList();
	private MultiLinkedList mll = new MultiLinkedList();
	private CircularSingleLinkedList csll1 = new CircularSingleLinkedList();
	private CircularSingleLinkedList csll2 = new CircularSingleLinkedList();
	
	public void readInputFile() throws FileNotFoundException {
		file = new File("input.txt");
		scn = new Scanner(file);
		while (scn.hasNextLine()) {
			mll.add(scn.nextLine()); // Add to MLL alphabetical
		}
		scn.close();
	}
	
	public void createLetters() {
		for (int i = 65; i <= 90; i++) {
			char letterCode = (char)i;
			String letter = String.valueOf(letterCode);
			dll.add(letter);        // Add all letters to DLL sequentially
		}
	}
	
	public void readHighScoreTable() throws FileNotFoundException {
		file = new File("HighScoreTable.txt");
		scn = new Scanner(file);
		while (scn.hasNextLine()) {
			sll.add(scn.nextLine()); // To store all high scores in the text file sequentially
		}
		scn.close();
	}
	
	public void addScore(String letter) {
		if (letter.equals("A") ||letter.equals("E") || letter.equalsIgnoreCase("Ý") ||letter.equals("O") || letter.equals("U")) {
			player.setScore(player.getScore() + 5);  // The user gets 5 points for each vowel he/she knows
		}
		else {
			player.setScore(player.getScore() + 10); // The user gets 10 points for each consonant he/she knows
		}
	}
	
	public void update() {
		if (isInputLetterTrue) { // If the input entered correctly, update
			if (csll1.isLetterExist(inputLetter)) {  // First look for existence of input letter in CSLL.
				Letter temp = csll1.getHead();
				int order = 1; // Save order of input letter to write correct positions in other CSLL.
				do {
					if (temp.getLetter().equalsIgnoreCase(inputLetter)) {
						csll2.putLetter(inputLetter, order);
					}
					temp = temp.getNext();
					order++;
				} while (temp != csll1.getHead());
				if (dll.isLetterExist(inputLetter)) { // To not add points 2 times for one letter
					addScore(inputLetter.toUpperCase());
				}
			} 
			else {
				if (dll.isLetterExist(inputLetter)) { // To not decrease lives for wrong letter that guessed before.
					lives--;
				}
			}
			dll.delete(inputLetter); // For deleting input letter exist in DLL
		}
		else {   // If the input entered wrong
			System.out.println("\nPlease enter a appropriate letter!");
		}
	}
	
	public void draw() {
		if (lives > 0) {
			System.out.print("\nWord:  ");
			csll2.display();
			System.out.print("\t\tLives: " + lives + "\tScore: " + player.getScore() + "\t");
			dll.display();
			if (!isGameOver()) {				
				System.out.print("\nGuess: ");
				scn = new Scanner(System.in);
				inputLetter = scn.next();
				isInputLetterTrue = false;
				if (inputLetter.length() == 1) {  // To check the correctness of input letter 
					char letter = inputLetter.toUpperCase().charAt(0);
					if ((letter >= 65 && letter <= 90) || letter == 304 ) {
						isInputLetterTrue = true;
					}
				}
			}
		}
	}
	
	public void beginningOfTheGame() {
		System.out.println("------------------------------------WELCOME TO HANGMAN------------------------------------");
		System.out.print("\nPlease enter your name: ");
		scn = new Scanner(System.in);
		String name = scn.next();
	    player = new Player(name + ";0");  // Creating of the player
		Random rnd = new Random();
		randomNumber = rnd.nextInt(mll.size()) + 1;  
		String country = mll.randomCountry(randomNumber);  // Creating of the random country
		for (int i = 0; i < country.length(); i++) {
			csll1.add(country.substring(i, i + 1));    // Adding letter and dash at the same time
			csll2.add("-");
		}
		System.out.println("\nRandomly generated number: " + randomNumber);
		draw();
	}
	
	public boolean isGameOver() {
		Letter temp = csll2.getHead();
		boolean isGameOver = true;
		do {
			if (temp.getLetter().equals("-")) { // If any dash exist in CSLL
				isGameOver = false;
			}
			temp = temp.getNext();
		} while (temp != csll2.getHead());
		return isGameOver;
	}
	
	public void endOfTheGameScreen() {
		if (lives == 0) {
			System.out.println("\nYOU LOST!!!\n");
		}
		else {
			System.out.println("\n\nYOU WIN!!!\n");
			sll.add(player.getName() + ";" + Integer.toString(player.getScore())); 
		}
		sll.displayTop10Scores(); 								  // Writing of the top 10 scores to console
		try {  // Updating of the "HighScoreTable.txt" file 
			WriteFile data = new WriteFile("D://HighScoreTable.txt");         // To overwrite to text file
			WriteFile data2 = new WriteFile("D://HighScoreTable.txt", true);  // To append to text file
			Player temp = sll.getHead();
			data.writeToFile(temp.getName() + ";" + temp.getScore()); // Writing of the top 10 scores to text file
			for (int i = 1; i <= 9; i++) {  
				temp = temp.getNext();
				data2.writeToFile(temp.getName() + ";" + temp.getScore());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void run() throws FileNotFoundException {		
		readInputFile();
		createLetters();
		readHighScoreTable();
		beginningOfTheGame();
		while (lives > 0 && !isGameOver()) {
			update();
			draw();
		}
		endOfTheGameScreen();
	}
}
