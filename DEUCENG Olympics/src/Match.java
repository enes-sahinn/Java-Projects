
public class Match {
	private String sport;
	private Athlete athleteA, athleteB, athleteWinner;
	private Time time;
	private Date date;
	
	public Match(String sport, Athlete athleteA, Athlete athleteB) {
		this.sport = sport;
		this.athleteA = athleteA;
		this.athleteB = athleteB;
		athleteWinner = null;
		time = new Time();
		date = new Date(1,1,1);
	}
	
	
	public Athlete getAthleteA() {
		return athleteA;
	}


	public Athlete getAthleteB() {
		return athleteB;
	}


	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setTime(Time time) {
		this.time = time;
	}
	
	public Time getTime() {
		return time;
	}
	
	public Athlete buildMatch() {
		double scala = athleteA.getSkill() + athleteB.getSkill();
		double result = Math.random()*(scala);
		athleteWinner = null;
		if(result < athleteA.getSkill())
			athleteWinner = athleteA;
		else
			athleteWinner = athleteB;
		
		athleteWinner.addOnePoint();// increase the athlete points
		athleteWinner.getCountry().addOnePoint();// increase the score of his country
		return athleteWinner;
	}

	public String DisplayExecuted() {
		String str = "";
		if(athleteWinner != null) {
			str = date.Display() + " " + time.getTime() +" " + sport +" " + athleteA.getCountry().getName() + "-" + athleteA.getName()+"["+athleteA.getSkill()+"]"+" "+ athleteB.getCountry().getName() + "-" + athleteB.getName()+"["+athleteB.getSkill()+"]\n";
			str+= "                 "+ "Winner: " + athleteWinner.getName();
		}
		else {
			str = "This match hasn't executed yet.";
		}
		return str;
	}
	
	public String DisplayNexecuted() {
		return date.Display() + " " + time.getTime() + " " + sport + " "+ athleteA.getCountry().getName() + "-" + athleteA.getName() +" " + athleteB.getCountry().getName() + "-" + athleteB.getName();
	}

}
