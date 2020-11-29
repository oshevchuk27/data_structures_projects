package polling.treesheaps;

/**
 * Class that stores one row of the polling data. 
 * The instance variables include the last name, full name 
 * and polling percentage for a candidate. Includes a method
 * that compares last names of objects lexicographically.
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
		lastName = row[0];
		fullName = row[1];
		percentage = Double.parseDouble(row[2]);
	}
	
	/**
	 * Getter for the last name of the candidate
	 * @return the last name of the given candidate (String)
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Compares two Strings representing candidate's last names
	 * lexicographically
	 * @param other: the object representing candidate whose last name
	 * is compared to the current object's last name
	 * @return either a positive integer which means last name
	 * of the object lexicographically follows the last name of the argument object,
	 * a negative integer which means that last name of the object lexicographically 
	 * precedes the last name of the argument object or zero which means that 
	 * last names of both objects are equal
	 */
	public int compareTo(CandidatePollingData other) {
		return(this.lastName.compareTo(other.getLastName()));
	}
	
	/**
	 * Overrides the built-in toString method for the CandidatePollingData class
	 * @return a String with a full name and polling percentage for a candidate (String)
	 */
	public String toString() {
		return fullName + ":" + percentage;
	}
	

}
