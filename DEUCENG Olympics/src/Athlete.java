
public class Athlete {
	private String name ,gender ,sport;
	private Country country;
	private Date birthDate;
	private double skill;
	private int point;
	
	public Athlete(String name, String sport, Date birthDate, String gender, double skill) {
		this.birthDate = birthDate;
		this.gender = gender;
		this.skill = skill;
		this.name = name;
		this.point = 0;
		this.sport = sport;
	}
	public void addOnePoint() {
		point++;
	}
	public String getName() {
		return name;
	}
	
	public double getSkill() {
		return skill;
	}
	
	public int getPoint() {
		return point;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}


