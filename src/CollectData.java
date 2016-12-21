import java.util.ArrayList;
import java.io.FileNotFoundException;


/**
 * This class takes in the trips and station table files and uses their array lists 
 * @author Joseph
 *
 */
public class CollectData {
	private ArrayList<TripData> tripsData;
	private ArrayList<StationTable> stationData;
	
	/**
	 * Constructor for the class
	 * reads the Q3 trip data file and the Station Table data file
	 * This creates ArrayLists for the lines of each file
	 */
	public CollectData(){
		stationData = new ArrayList<StationTable>();
		tripsData = new ArrayList<TripData>();
		
		try {
			FileReader f = new FileReader("Q3_2016_trips.csv");
			ArrayList<String> tripArrays = f.getLines();
			for (String s : tripArrays){
				TripData newTrip = new TripData(s);
				tripsData.add(newTrip);
			}
			
			FileReader f2 = new FileReader("Station-Table.csv");
			ArrayList<String> stationInfo = f2.getLines();
			for (String s : stationInfo){
				StationTable newStation = new StationTable(s);
				stationData.add(newStation);
			}
			
		} catch (FileNotFoundException e){
			System.out.println("That file does not exist.");
		}
		
	}
	
	
	/**
	 * Accessor method to get trip data
	 * @return trip data array List
	 */
	public ArrayList<TripData> getTripData(){
		return tripsData;
	}
	
	/**
	 * Accessor method for station table
	 * @return station table as an array list
	 */
			
	public ArrayList<StationTable> getStationTable(){
		return stationData;
	}
}
