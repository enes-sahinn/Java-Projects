
public class Tournament {
	private String name;
	private Athlete[] athletes;
	private int athleteCounter ,footsCounteri, footsCounterj;
	private Match[] matches;
	private int matchCounter;
	
	public Tournament(String name, int aCount) {
		this.name = name;
		athleteCounter = 0;
		athletes = new Athlete[aCount];
		footsCounteri = 0;
		footsCounterj = 1;
	}
	
	public Athlete[] getAthletes() {
		return athletes;
	}
	
	public Match[] getMatches(){
		return matches;
	}
	
	public int getMatchCount() {
		return matchCounter;
	}
	
	public String getName() {
		return name;
	}
	
	public void appendAthlete(Athlete athlete){
		athletes[athleteCounter] = athlete;
		athleteCounter++;
	}
	// combination of match system
	public void matchCountFind(){                            // use this before for using generator.. unless dont use that you will get null pointer error
		matchCounter = (athleteCounter*(athleteCounter-1))/2;
		matches = new Match[matchCounter];		
	}
	
	public void matchingAthlete() {
		for (int i = 0; i < matchCounter; i++) {
			matches[i] = new Match(name,athletes[footsCounteri],athletes[footsCounterj]);
			footsCounterj++;
			if(footsCounterj == athleteCounter) {
				footsCounteri++;
				footsCounterj = footsCounteri+1;
			}
		}
	}

}
