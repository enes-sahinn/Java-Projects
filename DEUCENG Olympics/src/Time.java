
public class Time {
private String time;
	
	public Time() {
		time = "11:00";
	}
	
	public void addTwo() {
		if (time.equals("11:00")) {
			time = "13:00";
		}
		else if(time.equals("13:00")) {
			time = "15:00";
		}
		else
			time = "11:00";
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String str) {
		while(true) {
			if(str.equals("11:00") || str.equals("13:00") || str.equals("15:00")) {
				time = str;
				break;
			}
			else
				System.out.println("Wrong Time !!Try Again");
		}
	}	

}
