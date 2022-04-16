package cardGame;

public class Phone {
	private String countryCode;
	private int cityCode;
	private int number;
	
	public Phone(String countryCode, int cityCode, int number) {
		this.countryCode = countryCode;
		this.cityCode = cityCode;
		this.number = number;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getCityCode() {
		return cityCode;
	}

	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}	
}
