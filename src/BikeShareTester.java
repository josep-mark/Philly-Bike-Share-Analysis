import java.util.ArrayList;
import java.util.Scanner;

public class BikeShareTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CollectData bikeShare = new CollectData();
		ArrayList<StationTable> stationTable = bikeShare.getStationTable();
		ArrayList<TripData> tripData = bikeShare.getTripData();
		tripData.remove(0);
		stationTable.remove(0);
		QuestionSet bikeQuestions = new QuestionSet(tripData, stationTable);
		Scanner in = new Scanner(System.in);
		
		
		System.out.println("Welcome to analyzing your data sets!");
		System.out.println("Determine how many trip-types are in the data set");
		System.out.println("Enter the trip type(Round trip, one way): ");
		String input = in.nextLine();
		int tripCount = bikeQuestions.countTripTypes(input);
		System.out.println(tripCount);
		System.out.println("=================");
		System.out.println();
		
		System.out.println("We will determine Stations and their Go-Live Dates and if they are still active");
		System.out.println("Enter a year: ");
		String year = in.nextLine();
		System.out.println("Enter Active or not active");
		String active = in.nextLine();
		int activeCount = bikeQuestions.goLiveActive(year, active);
		System.out.println(activeCount);
		System.out.println("=================");
		System.out.println();
		
		System.out.println("We will determine the percent of trips starting from a certain station");
		System.out.println("Enter a station: ");
		String station = in.nextLine();
		double percentage = bikeQuestions.startPercentage(station);
		percentage = percentage * 100;
		System.out.println(percentage + "%");
		System.out.println("=================");
		System.out.println();
	
		System.out.println("We will determine the percentage of trips by a given pass types are of a given trip type");
		System.out.println("Enter a pass type: ");
		String passType = in.nextLine();
		System.out.println("Enter a trip type: ");
		String tripType = in.nextLine();
		double percentage2 = bikeQuestions.passTripTypePercentage(passType, tripType);
		percentage2 = percentage2 * 100;
		System.out.println(percentage2 + "%");
		System.out.println("=================");
		System.out.println();
		
		System.out.println("We will find the bike with the longest duration trip");
		String id = bikeQuestions.bikeWithLongestDuration();
		System.out.println(id);
		System.out.println("=================");
		System.out.println();
		
		System.out.println("We will find the number of bikes out on a given date and time");
		System.out.println("Please enter a date (m/d/yyyy): ");
		String dateQ6 = in.nextLine();
		System.out.println("Please enter a time (military with a :)");
		String timeQ6 = in.nextLine();
		System.out.println(bikeQuestions.bikesInUse(dateQ6, timeQ6));
		System.out.println("=================");
		System.out.println();
		
		System.out.println("We'll print out the trip information for the longest trip");
		bikeQuestions.longestTripInfo();
		System.out.println("=================");
		System.out.println();
		
//		System.out.println("We'll print a list of trip ids which involved a station which was the only station to go live on its respective go live date");
//		bikeQuestions.tripsOnGoLiveDates();
//		System.out.println("uncomment this for the list, it interrupts the flow");
//		System.out.println("=================");
//		System.out.println();
		
		System.out.println("Here is my interesting question: ");
		System.out.println("What percentage of plans are yearly, daily, or monthly? (0,30,365)");
		System.out.println("Please enter a plan type: ");
		String duration = in.nextLine();
		System.out.println(bikeQuestions.getPlanDurationPercentage(duration) + "%");
		System.out.println("=================");
		System.out.println();

		
//		System.out.println("Lets find pairs of stations close to one another");
//		bikeQuestions.getStationPairs();
//		System.out.println("=================");
//		System.out.println();
		
		System.out.println("The least popular end station is: ");
		System.out.println(bikeQuestions.leastPopularEndStation());
		System.out.println("=================");
		System.out.println();
		
		System.out.println("And the least travelled day is: ");
		System.out.println(bikeQuestions.leastTravelledDay());
		System.out.println("And the most travelled day is: ");
		System.out.println(bikeQuestions.mostTravelledDay());
		System.out.println("=================");
		System.out.println();
		
		}

}
