
public class Country {
	private String name;
	private Athlete[] athletes;
	private int athleteCount, point;
	private static int count;
	
	
	public Country() {
		athleteCount = 0;
		point = 0;
		athletes = new Athlete[20];
		count++;
	}
	public int getPoint() {
		return point;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addOnePoint() {
		point++;
	}
	
	public Athlete[] getAthletes() {
		return athletes;
	}
	
	public void appendAthlete(Athlete athlete) {
		athletes[athleteCount] = athlete;
		athleteCount++;
		athlete.setCountry(this);
	}

}
