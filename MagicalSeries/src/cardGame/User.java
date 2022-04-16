package cardGame;

public class User {
	private String name;
	private String surname;
	private Date birthdate;
	private String gender;
	private Address contactAdress;
	private Phone phoneNumber;
	private int score;
	
	public User(String name, String surname, Date birthdate, String gender, Address contactAdress, Phone phoneNumber, int score) {	
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.gender = gender;
		this.contactAdress = contactAdress;
		this.phoneNumber = phoneNumber;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getContactAdress() {
		return contactAdress;
	}

	public void setContactAdress(Address contactAdress) {
		this.contactAdress = contactAdress;
	}

	public Phone getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Phone phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}	
}
