import java.util.ArrayList;
import java.lang.Math;
import java.util.HashMap;

/**
 * This class contains the algorithms for solving the question set on the Homework
 * @author Joseph
 *
 */
public class QuestionSet {
	private ArrayList<TripData> tripInfo;
	private ArrayList<StationTable> stationInfo;
	
	/**
	 * The constructor takes in the array list of trip info and station info
	 * @param trip trip data
	 * @param station station data
	 */
	public QuestionSet(ArrayList<TripData> trip, ArrayList<StationTable> station){
		tripInfo = trip;
		stationInfo = station;
	}
	
	/**
	 * Method for question one
	 * @param s trip type
	 * @return int count of trip types
	 */
	
	public int countTripTypes(String s){
		int count = 0;
		for (TripData t : tripInfo){
			String test = t.getPassType();
			if (test.equalsIgnoreCase(s)){
				count ++;
			}
		}
		return count; 
	}
	
	/**
	 * Method for q2
	 * Finds stations that are still active and went live in 2015
	 * @param year year we want to check
	 * @param active active level
	 * @return int count
	 */
	
	public int goLiveActive(String year, String active){
		int count = 0;
		for (StationTable s: stationInfo){
			String tableYear = s.getGoLiveDate();
			String tableActive =  s.getActive();
			if (tableYear.contains(year) && tableActive.equalsIgnoreCase(active)){
				count ++;
			}
		}
		return count;
	}
	
	/**
	 * Method to return a percentage of trips starting at a given location
	 * @param s start location
	 * @return Double percentage
	 */
	
	public double startPercentage(String s){
		double percentage = 0.0;
		int count = 0;
		String stationId = "";
		int tripSize = tripInfo.size();
		for (StationTable t: stationInfo){
			String name = t.getStationName();
			if (name.equalsIgnoreCase(s)){
				stationId = t.getStationID();
				break;
			}
		}
		for (TripData d : tripInfo){
			String id = d.getStartStation();
			if (stationId.equalsIgnoreCase(id)){
				count ++;
			}
		}
		percentage = (double)count / tripSize;
		return percentage;
	}
	
	/**
	 * Method to determine the percentage of trips taken by a certain pass type and trip type
	 * @param pass pass type
	 * @param trip trip type
	 * @return double percentage
	 */
	
	public double passTripTypePercentage(String pass, String trip){
		double percentage = 0.0;
		int countPassType = 0;
		int countTripType = 0;
		for (TripData t : tripInfo){
			String passType = t.getPassType();
			String tripType = t.getTripCategory();
			if (passType.equalsIgnoreCase(pass)){
				countPassType ++;
				if (tripType.equalsIgnoreCase(trip)){
					countTripType ++;
				}
			}
		}
		percentage = ((double) countTripType / countPassType);
		return percentage;
	}
	
	/**
	 * Method finds the bike with the longest duration
	 * @return String bike id
	 */
	
	public String bikeWithLongestDuration(){
		String bikeId = "";
		int longestDuration = 0;
		for (TripData d : tripInfo){
			String stringDuration = d.getDuration();
			int duration = Integer.parseInt(stringDuration);
			if (duration > longestDuration){
				longestDuration = duration;
				bikeId = d.getBikeID();
			}
		}
		return bikeId;
	}
	
	/**
	 * method finds the numbers of bikes in use on a given date and time
	 * @param date date
	 * @param time time
	 * @return int count
	 */
	
	public int bikesInUse(String date, String time){
		int count = 0;
		time = time.replace(":", "");
		int userTime = Integer.parseInt(time);
		for (TripData d : tripInfo){
			String startDateAndTime = d.getStartTime();
			String endDateAndTime = d.getEndTime();
			String[] splitsville = startDateAndTime.split(" ");
			String startDate = splitsville[0];
			String startTime = splitsville[1];
			startTime = startTime.replace(":", "");
			int dataStartTime = Integer.parseInt(startTime);
			String[] splitEnd = endDateAndTime.split(" ");
			String endDate = splitEnd[0];
			String endTime = splitEnd[1];
			endTime = endTime.replace(":", "");
			int dataEndTime = Integer.parseInt(endTime);
			
			if (startDate.equalsIgnoreCase(date) && endDate.equalsIgnoreCase(date)){
				if (dataStartTime < userTime && dataEndTime > userTime){
					count ++;
				}
			}
			else if (startDate.equalsIgnoreCase(date)){
				if (dataStartTime < userTime){
					count ++;
				}
			}
			else if (endDate.equalsIgnoreCase(date)){
				if (dataEndTime > userTime){
					count ++;
				}
			}
		}
		return count;
	}
	
	/**
	 * Method finds the longest trip
	 * prints out the information for that trip
	 */
	
	public void longestTripInfo(){
		String iD = "";
		Double longestTrip = 0.0;
		for (TripData d : tripInfo){
			boolean nullCheck = checkForNull(d);
			if (nullCheck){
				double startLat = Double.parseDouble(d.getStartLat());
				double endLat = Double.parseDouble(d.getEndLat());
				double startLon = Double.parseDouble(d.getStartLon());
				double endLon = Double.parseDouble(d.getEndLon());
				double a = startLat - endLat;
				double b = startLon - endLon;
				a = a*a;
				b = b*b;
				double c = a + b;
				double f = Math.sqrt(c);
				if (f > longestTrip){
					longestTrip = f;
					iD = d.getTripID();
				}
			}
		}
		for (TripData d : tripInfo){
			String tripID = d.getTripID();
			if (tripID.equals(iD)){
				d.printTripInfo();
				break;
			}
		}
	}
	
	/**
	 * Method to make sure LAt and Long are useable values
	 * @param d TripData object to check
	 * @return boolean
	 */

	private boolean checkForNull(TripData d){
		boolean keepGoin = true;
		String startLat = d.getStartLat();
		String startLon = d.getStartLon();
		String endLat = d.getEndLat();
		String endLon = d.getEndLon();
		String badCase = "\\N";
		if (startLat.equalsIgnoreCase(badCase)){
			keepGoin = false;
		}
		else if (startLon.equalsIgnoreCase(badCase)){
			keepGoin = false;
		}
		else if (endLat.equalsIgnoreCase(badCase)){
			keepGoin = false;
		}
		else if (endLon.equalsIgnoreCase(badCase)){
			keepGoin = false;
		}
		return keepGoin;		
	}
	
	/**
	 * method to find the trip ids associated with stations that have unique golivedates
	 * @return ArrayList<String> of trip ids
	 */
	
	public ArrayList<String> tripsOnGoLiveDates(){
		ArrayList<String> tripIDS = new ArrayList<String>();
		ArrayList<String> uniqueGoDates = getUniqueStartDates();
		ArrayList<String> locations = new ArrayList<String>(); 
		for (StationTable t : stationInfo){
			String location = t.getStationID();
			String date = t.getGoLiveDate();
			for (String s : uniqueGoDates){
				if (date == s){
					locations.add(location);
				}
			}
		}
		
		for (TripData d : tripInfo){
			String startStation = d.getStartStation();
			String endStation = d.getEndStation(); 
			
			for (String s : locations){
				if (startStation.equalsIgnoreCase(s)){						
					tripIDS.add(d.getTripID());
				}
				else if (endStation.equalsIgnoreCase(s)){
					tripIDS.add(d.getTripID());
				}
			}
		}
		for (String s : tripIDS){
			System.out.println(s);
		}
		return tripIDS;
	}
	
	/**
	 * Method to find all the unique go live dates in the station table data
	 * @return ArrayList of unique dates
	 */

	private ArrayList<String> getUniqueStartDates(){
		ArrayList<String> uniqueStartDates = new ArrayList<String>();
		ArrayList<String> startDates = new ArrayList<String>();
		for (StationTable s : stationInfo){
			String i = s.getGoLiveDate();
			startDates.add(i);
		}
		
		for (int i = 0; i < startDates.size(); i++){
			boolean matches = false;
			String test = startDates.get(i);
			for (int j = 0; j < startDates.size(); j++){
				if (j == i){
					String counterPart = "";
					if (test.equals(counterPart)){
						matches = true;			
					}
				}
				else{
					String counterPart = startDates.get(j);
					if (test.equals(counterPart)){
						matches = true;			
					}
				}
			}
			if (matches == false) {
				uniqueStartDates.add(startDates.get(i));
			}
		}
			
		return uniqueStartDates;
	}

	/**
	 * This method finds the percentage of plans that are of a given duration
	 * @param s plan duration
	 * @return double percentage
	 */
	
	public Double getPlanDurationPercentage(String s){
		double percentage = 0.0;
		int count = 0;
		int total = tripInfo.size();
		for (TripData d : tripInfo){
			String plan = d.getPlanDuration();
			if (plan.equalsIgnoreCase(s)){
				count++;
			}
		}
		percentage = 100 * ((double) count / total);
		return percentage;
	}
	
	/**
	 * This method finds the stations close to eachother
	 * @return 
	 */
	
	
	public void getStationPairs(){
		ArrayList<String> stationIDS = new ArrayList<String>();
		ArrayList<Double> latitudes = new ArrayList<Double>();
		ArrayList<Double> longitudes = new ArrayList<Double>();
		ArrayList<StationPairs> pairs = new ArrayList<StationPairs>();
		for (StationTable t : stationInfo){
			stationIDS.add(t.getStationID());
		}
		
		for (String s : stationIDS){
			for (TripData d : tripInfo){
				if (s.equals(d.getStartStation())){
					if (checkForNull(d)){
						String latString = d.getStartLat();
						String lonString = d.getEndLon();
						double lat = Double.parseDouble(latString);
						double lon = Double.parseDouble(lonString);
						latitudes.add(lat);
						longitudes.add(lon);
					}
					continue;
				}
				
			}
		}
		for (int i = 0; i < stationIDS.size(); i++){
			double lat1 = latitudes.get(i);
			double lon1 = longitudes.get(i);
			for (int j = i + 1; j < stationIDS.size(); j++){
				double lat2 = latitudes.get(j);
				double lon2 = longitudes.get(j);
				if (areTheyClose(lat1, lon1, lat2, lon2)){
					StationPairs newPair = new StationPairs(stationIDS.get(i), stationIDS.get(j));
					pairs.add(newPair);
					}
				}
			}
		for (StationPairs i : pairs){
			i.print();
		}
	}
	
	private boolean areTheyClose(double lat1, double lon1, double lat2, double lon2){
		boolean close = false;
		double latDif = lat1 - lat2;
		double lonDif = lon1 - lon2;
		double average = (latDif + lonDif)/2;
		if (average < .02){
			close = true;
		}
		return close;
	}
	
	/**
	 * This method finds the least popular station
	 * @return String station name
	 */
	
	
	public String leastPopularEndStation(){
		int least = 100000;
		String leastPopularStation = "";
		for (StationTable t : stationInfo){
			int count = 0;
			String station = t.getStationID();
			for (TripData d : tripInfo){
				String end = d.getEndStation();
				if (station.equalsIgnoreCase(end)){
					count++;
				}
			}
			if (count < least){
				least = count;
				leastPopularStation = t.getStationName();
			}
		}
		return leastPopularStation;
	}
	
	public String leastTravelledDay(){
		int trips = 100000;
		String previousTripDay = "";
		int dayCount = 0;
		String day = "";
		for (TripData d : tripInfo){
			String dateTime = d.getStartTime();
			String[] dateAndTime = dateTime.split(" ");
			String date = dateAndTime[0];
			if (date.equalsIgnoreCase(previousTripDay)){
				dayCount ++;
				previousTripDay = date;
				if (dayCount < trips){
					trips = dayCount;
					day = date;
				}
			}
			else {
				dayCount = 0;
				previousTripDay = date;
			}
		}
		return day;
	}
	
	public String mostTravelledDay(){
		int trips = 0;
		String previousTrip = "";
		int dayCount = 0;
		String recordHolder = "";
		for (TripData d : tripInfo){
			String dateTime = d.getStartTime();
			String[] dateAndTime = dateTime.split(" ");
			String date = dateAndTime[0];
			if (date.equalsIgnoreCase(previousTrip)){
				dayCount ++;
				previousTrip = date;
				if (dayCount > trips){
					trips = dayCount;
					recordHolder = previousTrip;
				}
			}
			else {
				dayCount = 0;
				previousTrip = date;
			}
		}
		return recordHolder;
	}
}

