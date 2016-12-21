/**
 * This class will create an object for each station in the station table
 * It will have variables for each data column in the station table 
 * @author Joseph
 *
 */
public class StationTable {
	private String stationID;
	private String stationName;
	private String goLiveDate;
	private String active;
	private String row;

	/**
	 * Constructor takes in a string and runs the create method
	 * @param s string or one line in the station table
	 */
	
	public StationTable(String s){
		row = s;
		create();
	}
	
	/**
	 * The create method splits the string by commas
	 * It then assigns the appropriate values to the appropriate variables
	 */
	
	private void create(){
		String[] splitIt = row.split(",");
		if (splitIt.length > 4) {
			String one = splitIt[1];
			String two = splitIt[2];
			String real = one.concat(two);
			String[] temp = new String[4];
			temp[0] = splitIt[0];
			temp[1] = real;
			temp[2] = splitIt[3];
			temp[3] = splitIt[4];
			splitIt = temp;
		}
		stationID = splitIt[0];
		stationName = splitIt[1];
		goLiveDate = splitIt[2];
		active = splitIt[3];
	}
	
	/**
	 * Accessor method for station id #
	 * @return stationID String
	 */

	public String getStationID() {
		return stationID;
	}
	
	/**
	 * Accessor for station name
	 * @return String station name
	 */

	public String getStationName() {
		return stationName;
	}
	
	/**
	 * accessor for live date
	 * @return String go Live Date
	 */

	public String getGoLiveDate() {
		return goLiveDate;
	}
	
	/**
	 * Accessor method for active
	 * @return String active
	 */

	public String getActive() {
		return active;
	}
	
	/**
	 * Method to print the station info for one object
	 */
	
	public void printStationInfo(){
		System.out.println(stationID + " " + stationName + " " + goLiveDate + " " + active);
	}
	
}
