package hangman;  

public class Player {       // For high score table(SLL) and current player.
	private String name;
	private int Score;
	private Player next;
	
	public Player(String dataToAdd) {
		String[] highScore = dataToAdd.split(";");
		name = highScore[0];
		Score = Integer.parseInt(highScore[1]);
		next = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public Player getNext() {
		return next;
	}

	public void setNext(Player next) {
		this.next = next;
	}
}
