import java.io.File; 
import java.util.ArrayList; 
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * The file reader class takes in a file and creates an arraylist<String> of lines for that file
 * @author Joseph
 *
 */
public class FileReader {
	private String filename; 
	private ArrayList<String> lines;
	
	public FileReader(String file) throws FileNotFoundException { 
		filename = file;
		lines = new ArrayList<String>(); 
		readFile();
	}
	
	/**
	 * Read file takes the file and loops through the lines to create the array list
	 * @throws FileNotFoundException
	 */
	
	private void readFile() throws FileNotFoundException {
		
		File inputFile = new File(filename); 
		Scanner in = new Scanner(inputFile);
			
		while (in.hasNextLine()) { 
			String line = in.nextLine();
			lines.add(line);
		}
			
		in.close(); 
		} 
	
	/**
	 * getter method for the lines arraylist
	 * @return ArrayList<String> of lines
	 */
	
	public ArrayList<String> getLines() {
		return lines;
	}
}
