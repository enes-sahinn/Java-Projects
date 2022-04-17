import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainTest {
	public static void fixtureCreater(Tournament[] tournaments, int totalmatch, int totalsport) {
		Date date = new Date(24,06,2020);
		Time time = new Time();
		int counter = 0;		
		for (int i = 0; i < totalmatch/totalsport; i++) {
			for (int j = 0; j < totalsport; j++) {			
				tournaments[j].getMatches()[i].getTime().setTime(time.getTime());
				tournaments[j].getMatches()[i].getDate().setDay(date.getDay());
				tournaments[j].getMatches()[i].getDate().setMonth(date.getMonth());
				tournaments[j].getMatches()[i].getDate().setYear(date.getYear());
				counter++;
				time.addTwo();
				if(counter == 3) {
					date.dayCounter();
					counter = 0;
				}		
			}			
		}
	}	
	public static void showFixture(Tournament[] tournaments, int totalmatch , int totalsport) {
		for (int i = 0; i < totalmatch/totalsport; i++) {
			for (int j = 0; j < tournaments.length; j++) {
				System.out.println(tournaments[j].getMatches()[i].DisplayNexecuted());
			}
		}
	}
	public static void playMatces(Tournament[] tournaments, int totalmatch, int totalsport) {
		for (int i = 0; i < totalmatch/ totalsport ; i++) {
			for (int j = 0; j < tournaments.length; j++) {
				tournaments[j].getMatches()[i].buildMatch();
			}
		}
	}
	public static void showMatchConclusion(Tournament[] tournaments, int totalmatch, Sport[] sports , int totalsport) {
		for (int i = 0; i < totalmatch/totalsport; i++) {
			for (int j = 0; j < tournaments.length; j++) {
				System.out.println(tournaments[j].getMatches()[i].DisplayExecuted());
			}
		}
		System.out.println("\n");
		String mostWinner = "";
		String mostWinner2 = "";
		int mostPoint = 0;
		for (int i = 0; i < tournaments.length; i++) {
			mostWinner = "";
			
			mostPoint = 0;
			for (int j = 0; j < tournaments[i].getAthletes().length; j++) {
				if(tournaments[i].getAthletes()[j].getPoint() > mostPoint) {
					mostWinner = tournaments[i].getAthletes()[j].getCountry().getName();
					mostPoint = tournaments[i].getAthletes()[j].getPoint();
					mostWinner2 = "";
				}
				else if(tournaments[i].getAthletes()[j].getPoint() == mostPoint) {
					mostWinner2 = tournaments[i].getAthletes()[j].getCountry().getName();
				}
			}
			System.out.print(sports[i].getName() +" winner country is: "+ mostWinner +" with "+ mostPoint+" points.");
			if(!mostWinner2.equalsIgnoreCase("")) {
				System.out.println(" and second winner country is: "+ mostWinner2 +" with "+ mostPoint+" points.");
			}
			else
				System.out.println();
		}
	}
	public static String championCountry(Country[] countries , int countryCount) {
		String mostWinner = "";
		String mostWinner2 = "";
		int mostPoint = 0;
		for (int i = 0; i < countryCount ; i++) {
			if(countries[i].getPoint() > mostPoint ) {
				mostPoint = countries[i].getPoint();
				mostWinner = countries[i].getName();
				mostWinner2 = "";
			}
			else if(countries[i].getPoint() == mostPoint)
				mostWinner2 = countries[i].getName();
		}
		if(mostWinner2.equalsIgnoreCase(""))
			return mostWinner + " Score:"+ mostPoint;
		else
			return mostWinner + " and "+ mostWinner2 +" Score:"+ mostPoint;
	}
	public static String championAthlete(Athlete[] athletes , int aCount) {
		String mostWinner = "";
		String mostWinner2 = "";
		int mostPoint = 0;
		for (int i = 0; i < aCount ; i++) {
			if(athletes[i].getPoint() > mostPoint ) {
				mostPoint = athletes[i].getPoint();
				mostWinner = athletes[i].getName();
				mostWinner2 = "";
			}
			else if(athletes[i].getPoint() == mostPoint)
				mostWinner2 = athletes[i].getName();
		}
		if(mostWinner2.equalsIgnoreCase(""))
			return mostWinner + " Score:"+ mostPoint;
		else
			return mostWinner + " and "+ mostWinner2 +" Score:"+ mostPoint;
	}
	public static void findDate(Tournament[] tournaments, Scanner input) {
		System.out.print("Enter Date: ");
		String[] date = input.next().split("\\.");
		boolean flag = false;
		for (int i = 0; i < tournaments.length; i++) {
			for (int j = 0; j < tournaments[i].getMatchCount(); j++) {
				if(tournaments[i].getMatches()[j].getDate().getDay() == Integer.parseInt(date[0]) && tournaments[i].getMatches()[j].getDate().getMonth() == Integer.parseInt(date[1])&& tournaments[i].getMatches()[j].getDate().getYear() == Integer.parseInt(date[2])) {
					System.out.println(tournaments[i].getMatches()[j].DisplayNexecuted());
					flag = true;
				}
			}
		}
		if(flag == false)
			System.out.println("There isn't exist match in that time");
	}
	public static void findCountry(Tournament[] tournaments, Scanner input) {
		System.out.print("Enter Country: ");
		String country = input.next();
		boolean flag = false;
		for (int i = 0; i < tournaments.length; i++) {
			for (int j = 0; j < tournaments[i].getMatchCount(); j++) {
				if(tournaments[i].getMatches()[j].getAthleteA().getCountry().getName().equalsIgnoreCase(country) || tournaments[i].getMatches()[j].getAthleteB().getCountry().getName().equalsIgnoreCase(country)) {
					System.out.println(tournaments[i].getMatches()[j].DisplayNexecuted());
					flag = true;
				}
			}
		}
		if(!flag)
			System.out.println("Invalid country");
	}

	public static void mainMenu() {
		System.out.println("*****Menu*****");
		System.out.println("1.Genarate fixture");
		System.out.println("2.Perform tournaments");
		System.out.println("3.Show statistics");
		System.out.println();
		System.out.print(">Enter your choice:");
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);	
		System.out.print(">Enter file name to load: ");
		String fileName = input.next();
		int countryCount=0;
		int sportCount = 0;	
		//Read file		
		File f = new File(fileName);
		Scanner scn = new Scanner(f);
		int aCount = 0; // athlet number
		int infoCount = 6;// line of information
		String[] info = new String[infoCount];
		while(scn.hasNextLine()) {
			info = scn.nextLine().split(",");
			aCount++;
		}
		scn.close();
		scn = new Scanner(f);
		String[][] infoAth = new String[aCount][infoCount];		
		for (int i = 0; i < infoAth.length; i++) {
			info = scn.nextLine().split(",");
			for (int j = 0; j < infoAth[i].length  ; j++) {
				infoAth[i][j] = info[j];
			}
		}
		scn.close();
		String[] data = new String[3];
		Date[] births = new Date[aCount];
		for (int i = 0; i < aCount ; i++) {  // adding information in array for fill the class
			data = infoAth[i][4].split("\\.");
			births[i] = new Date(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]));
		}
		
		//for sports
		boolean isExist = false;		
		Sport[] sports = new Sport[20];
		for (int i = 0; i < aCount; i++) {
			sports[i] = new Sport();
		}		
		for (int i = 0; i < aCount; i++) {
			isExist = false;
			for (int j = 0; j < aCount; j++) {
				if(infoAth[i][1].equalsIgnoreCase(sports[j].getName())) {
					sports[j].counter();
					isExist = true;
				}
			}
			if(!isExist) {
				sports[sportCount].setName(infoAth[i][1]);
				sports[sportCount].counter();
				sportCount++;
			}
		}		

		
        //for countries
		Country[] countries = new Country[20];
		for (int i = 0; i < aCount; i++) {
			countries[i] = new Country();
		}
		
		for (int i = 0; i < aCount; i++) {
			isExist = false;
			for (int j = 0; j < (aCount/sportCount) ; j++) { // aCount/sportCount give countrys number
				if(infoAth[i][0].equalsIgnoreCase(countries[j].getName())){
					isExist = true;
					break;
				}
			}
			if(!isExist) {
				countries[countryCount].setName(infoAth[i][0]);
				countryCount++;
			}
		}
		
		//for athletes
		Athlete[] athletes = new Athlete[aCount];
		for (int i = 0; i < aCount; i++) {
			athletes[i]= new Athlete(infoAth[i][2],infoAth[i][1],births[i], infoAth[i][3], Double.parseDouble(infoAth[i][5]));
		}
		// for adding athlete in country 
		for (int i = 0; i < countryCount; i++) {// go around in the loop according to country number
			for (int j = 0; j < aCount; j++) {//go around in the loop according to athlete number
				if(countries[i].getName().equalsIgnoreCase(infoAth[j][0])) {// if name of country equals to country of athlete				
					countries[i].appendAthlete(athletes[j]);// add the current athlete to the current country
				}
			}
		}
		//start date can be determined here
		Date matchDate = new Date(24 , 07 , 2020);
		Time matchTime = new Time();
		//for tournaments
		Tournament[] tournaments = new Tournament[sportCount];
		for (int i = 0; i < tournaments.length; i++) {
			tournaments[i] = new Tournament(sports[i].getName() , sports[i].getaCount());
		}
		//for adding the athletes
		for (int i = 0; i < tournaments.length; i++) {
			for (int j = 0; j < aCount; j++) {
				if(tournaments[i].getName().equalsIgnoreCase(infoAth[j][1])) {
					tournaments[i].appendAthlete(athletes[j]);
				}
			}
		}
		//generate fixture	
		for (int i = 0; i < tournaments.length; i++) {
			tournaments[i].matchCountFind();
			tournaments[i].matchingAthlete();
		}
		int matchCount = 0;
		for (int i = 0; i < tournaments.length; i++) {// determine total of match
			tournaments[i].getMatchCount();
			matchCount += tournaments[i].getMatchCount();
		}		
		mainMenu();
		String choice = input.next();
		if(choice.equalsIgnoreCase("1")) {
			fixtureCreater(tournaments, matchCount , sportCount);
			showFixture(tournaments, matchCount, sportCount);
			System.out.println();
			System.out.print(">Enter your choice:");
			choice = input.next();
		}
		if(choice.equalsIgnoreCase("2")) {
			playMatces(tournaments, matchCount, sportCount);
			showMatchConclusion(tournaments, matchCount, sports, sportCount);
			System.out.println();
			System.out.print(">Enter your choice:");
			choice = input.next();
		}
		if(choice.equalsIgnoreCase("3")) {
			System.out.println("*****Statistic Menu*****");
			System.out.println("The country which won most of the matches");
			System.out.println("The athlete who won most of the matches");
			System.out.println("list of matches by date");
			System.out.println("list of matches by country");
			System.out.println();
			System.out.print(">Enter your choice: ");
			choice = input.next();
			if(choice.equalsIgnoreCase("1")) {
				System.out.println(championCountry(countries,countryCount));
				System.out.println();
				System.out.print(">Enter your choice: ");
				choice = input.next();
			}
			if(choice.equalsIgnoreCase("2")) {
				System.out.println(championAthlete(athletes, aCount));
				System.out.println();
				System.out.print(">Enter your choice: ");
				choice = input.next();
			}
			if(choice.equalsIgnoreCase("3")) {
				findDate(tournaments, input);
				System.out.print(">Enter your choice: ");
				choice = input.next();
			}
			if(choice.equalsIgnoreCase("4")) {
				findCountry(tournaments, input);
				System.out.print(">Enter your choice: ");
				choice = input.next();
			}
			else
				System.out.println("Ýnvalid Choice");
		}
		else
			System.out.println("Ýnvalid Choice");				
	}

}
