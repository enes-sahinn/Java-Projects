package Lab7;

public class Passenger {
	private String ID;
	private String station;
	private int age;
	private String type;
	
	public Passenger(String ID, String station, int age, String type) {
		this.ID = ID;
		this.station = station;
		this.age = age;
		this.type = type;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String display() {
		return (this.ID + " " + this.station + " " + this.age + " " + this.type);
	}
}
