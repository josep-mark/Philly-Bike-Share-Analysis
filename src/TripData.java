/**
 * This class creates an object for each line of the trip data
 * It contains variables for each column of data in Q3_2016_Trips
 * @author Joseph
 *
 */
public class TripData {
	private String row;
	private String tripID;
	private String duration;
	private String startTime;
	private String endTime;
	private String startStation;
	private String startLat;
	private String startLon;
	private String endStation;
	private String endLat;
	private String endLon;
	private String bikeID;
	private String planDuration;
	private String tripCategory;
	private String passType;
	
	/**
	 * Constructor takes in a line of data and splits it
	 * @param s line of data
	 */
	
	public TripData(String s){
		row = s;
		splitData();
	}
	
	/**
	 * Accessor for trip id
	 * @return String tripID
	 */
	
	public String getTripID() {
		return tripID;
	}
	
	/**
	 * Accessor for duration
	 * @return String
	 */

	public String getDuration() {
		return duration;
	}
	
	/**
	 * Accessor for start time
	 * @return String start time
	 */

	public String getStartTime() {
		return startTime;
	}
	
	/**
	 * Accessor for end time
	 * @return String end time
	 */

	public String getEndTime() {
		return endTime;
	}

	/**
	 * Accessor for start station
	 * @return String
	 */
	
	public String getStartStation() {
		return startStation;
	}
	
	/**
	 * Accessor for starting latitude
	 * @return String
	 */

	public String getStartLat() {
		return startLat;
	}
	
	/**
	 * Accessor for starting Longitude
	 * @return String
	 */

	public String getStartLon() {
		return startLon;
	}

	/**
	 * Accessor method for end station
	 * @return String
	 */
	
	public String getEndStation() {
		return endStation;
	}
	
	/**
	 * Accessor method for ending latitude
	 * @return String
	 */

	public String getEndLat() {
		return endLat;
	}
	
	/**
	 * Accessor method for ending longitue
	 * @return String
	 */

	public String getEndLon() {
		return endLon;
	}

	/**
	 * Accessor method for bike id
	 * @return String
	 */
	
	public String getBikeID() {
		return bikeID;
	}
	
	/**
	 * Accessor method for plan duration
	 * @return String
	 */

	public String getPlanDuration() {
		return planDuration;
	}
	
	/**
	 * Accessor method for trip category
	 * @return String
	 */

	public String getTripCategory() {
		return tripCategory;
	}
	
	/**
	 * Accessor method for pass type
	 * @return String
	 */

	public String getPassType() {
		return passType;
	}
	
	/**
	 * splits data by the comma
	 */

	private void splitData(){
		String[] split = row.split(",");
		tripID = split[0];
		duration = split[1];
		startTime = split[2];
		endTime = split[3];
		startStation = split[4];
		startLat = split[5];
		startLon = split[6];
		endStation = split[7];
		endLat = split[8];
		endLon = split[9];
		bikeID = split[10];
		planDuration = split[11];
		tripCategory = split[12];
		passType = split[13];
	}
	
	/**
	 * prints all the information for a trip
	 */
	
	public void printTripInfo(){
		System.out.println(row);
	}
}
