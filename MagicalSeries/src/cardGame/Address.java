package cardGame;

public class Address {
	private String neighborhood; // mahalle
	private String street;       // sokak
	private int no;              // no 
	private String town;         // ilçe
	private String city;         // il 
	private String country;      // ülke
	
	public Address(String neighborhood, String street, int no, String town, String city, String country) {
		this.neighborhood = neighborhood;
		this.street = street;
		this.no = no;
		this.town = town;
		this.city = city;
		this.country = country;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
