package polling.treesheaps;

/**
 * Class that stores one row of the polling data. 
 * The instance variables include the last name, full name 
 * and polling percentage for a candidate. Includes a method
 * that compares objects by their polling numbers and if there
 * is a tie, it compares their last names lexicographically.
 * 
 * 
 * 
 * @author Olga Shevchuk
 * @version 3rd April, 2020
 * @param <CandidatePollingData> object representing a row from csv file
 */

public class CandidatePollingData implements Comparable<CandidatePollingData> {
	
	private String lastName; // last name of the candidate 
	private String fullName; // full name of the candidate
	private double percentage; // percentage of the people polled who said they
	                           // would vote for that candidate
	
	/**
	 * Constructor for the CandidatePollingData class
	 * that turns the row from the csv file 
	 * represented as array of Strings into the 
	 * CandidatePollingData object
	 * @param row: array of Strings representing
	 * a row from the csv file
	 */
	public CandidatePollingData(String[] row) {
		this.lastName = row[0];
		this.fullName = row[1];
		this.percentage = Double.parseDouble(row[2]);
	}
	
	/**
	 * Getter for the last name of the candidate
	 * @return the last name of the given candidate (String)
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * Getter for the polling percentage of the candidate
	 * @return the polling percentage of the given candidate (double)
	 */
	public double getPercentage() {
		return this.percentage;
	}
	
	/**
	 * Compares the polling data of the candidate objects, 
	 * if there is a tie, compares string representing objects' last 
	 * names lexicographically.
	 * @param other: the object representing candidate whose polling percentage
	 * is compared to the current object's polling percentage
	 * @return either a positive integer which means the polling percentage
	 * of the object is bigger than that of the argument object,
	 * a negative integer which means that the polling percentage of the object is smaller 
	 * that of the argument object or compares the last names of both objects by the same
	 * principle if the polling percentage of both objects is equal
	 */
	public int compareTo(CandidatePollingData other) {
		if(this.percentage > other.getPercentage()) {
			return 1;
		} else if(this.percentage < other.getPercentage()) {
			return -1;
		} else { // if there is a tie
			return (this.lastName.compareTo(other.getLastName()));
		}
	}
	
	/**
	 * Overrides the built-in toString method for the CandidatePollingData class
	 * @return a String with a full name and polling percentage for a candidate (String)
	 */
	public String toString() {
		return this.fullName + ":" + this.percentage;
	}
	

}

