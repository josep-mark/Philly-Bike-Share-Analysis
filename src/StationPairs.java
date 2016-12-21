/**
 * A class to hold pairs of station ids
 * @author Joseph
 *
 */
public class StationPairs {
	private String station1;
	private String station2;
	
	/**
	 * Constructor takes two string for the stations
	 * @param s station 1
	 * @param q station 2
	 */
	public StationPairs(String s, String q){
		station1 = s;
		station2 = q;
	}

	public String getStation1() {
		return station1;
	}

	public String getStation2() {
		return station2;
	}
	
	public void print(){
		System.out.println(station1 + " & " + station2);
	}
	
}
