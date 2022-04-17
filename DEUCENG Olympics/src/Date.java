
public class Date {
private int day,month,year;
	
	public Date(int day, int month, int year) 
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
	public void dayCounter() {
		day++;
		if((month == 4 || month == 6 || month == 9 || month == 11)&& day == 31) {
			month++;
			day -= 30;
		}
		else if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day == 32) {
			if(month == 12) {
				year++;
				month -=11;
				day -= 31;
			}
			else {
				month++;
				day -= 31;
			}
		}
		else if (month == 2) {
			if(year % 4 == 0 && day == 30) {
				month++;
				day -= 29;
			}
			else if(day == 29) {
				month++;
				day -=28;
			}
		}
	}
	public String Display() {
		return day+"/"+month+"/"+year;
	}

}
