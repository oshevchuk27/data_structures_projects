package deduplication.sqf;

/**
 * Holds the information for a single 
 * row from the CSV that represents a voter
 * object. Includes the voter's
 * last, first, middle names, voter id, date 
 * of birth, residential address and
 * registration date as instance variables.
 * Implements the Comparable interface by 
 * overriding the compareTo method where
 * last name, then the first name, then 
 * date of birth, then residential address
 * and finally registration date 
 * of voters are compared.
 * Includes several methods that return different hash keys for 
 * that voter object.
 * 
 * 
 * 
 * 
 * 
 * @author Olga Shevchuk
 * @version 14th May, 2020
 *
 */

public class VoterInfo implements Comparable<VoterInfo> {

    // instance variable for VoterInfo class
	private String voterID;
	private String lastName;
	private String firstName;
	private String middleName;
	private String dateOfBirth;
	private String residentialAddress;
	private String registrationDate;
	
	/**
	 * Constructor for the VoterInfo
	 * class that turns the row from
	 * the CSV file represented as array
	 * of Strings into the VoterInfo 
	 * object
	 * @param row: array of Strings representing
	 * a row from the CSV file
	 * 
	 */
	public VoterInfo(String [] row) {
		this.lastName = row[3];
		this.firstName = row[4];
		this.registrationDate = row[6];
		this.dateOfBirth = row[7];
		this.residentialAddress = row[11];
		
	}
	
	/**Getter for the voterID of the voter
	 * @return the voterID of the voter
	 */
	public String getVoterID() {
		return this.voterID;
	}
	
	/**
	 * Getter for the last name of the voter
	 * @return the last name of the voter (String)
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * Getter for the first name of the voter
	 * @return the first name of the voter (String)
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * Getter for the middle name of the voter
	 * @return the middle name of the voter (String)
	 */
	public String getMiddleName() {
		return this.middleName;
	}
	
	/**
	 * Getter for the date of birth of the voter
	 * @return the date of birth of the voter (String)
	 */
	public String getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	/**
	 * Getter for the residential address of the voter
	 * @return the residential address of the voter (String)
	 */
	public String getResidentialAddress() {
		return this.residentialAddress;
	}
	
	/**
	 * Getter for the registration date of the voter
	 * @return the registration date of the voter (String)
	 */
	public String getRegistrationDate() {
		return this.registrationDate;
	}
	
	/**
	 * Compares the attributes of voter objects in the following order:
	 * by last name, then by first name, then by date of birth, then by residential 
	 * address and finally by registration date.
	 * @param other: the object representing voter whose attributes are
	 * compared to the current object's attributes
	 * @return either a positive integer which means that the String attribute
	 * of the object lexicographically follows the attribute of the argument
	 * object, a negative integer which means that the String attribute of the object 
	 * lexicographically precedes the attribute of the argument object or zero
	 * if the last name, first name, date of birth, residential address and
	 * registration date of the objects are the same.
	 */
	public int compareTo(VoterInfo other) {
	
		if (this.lastName.compareTo(other.getLastName()) > 0) {
			return 1;
		} else if (this.lastName.compareTo(other.getLastName()) < 0) {
			return -1;
		} else {
			if (this.firstName.compareTo(other.getFirstName()) > 0) {
				return 1;
			} else if(this.firstName.compareTo(other.getFirstName()) < 0) {
				return -1;
			} else {
				if (this.dateOfBirth.compareTo(other.getDateOfBirth()) > 0) {
					return 1;
				} else if (this.dateOfBirth.compareTo(other.getDateOfBirth()) < 0) {
					return -1;
				} else {
					if (this.residentialAddress.compareTo(other.getResidentialAddress()) > 0) {
						return 1;
				    } else if (this.residentialAddress.compareTo(other.getResidentialAddress()) < 0) {
						return -1;
					} else {
						return this.registrationDate.compareTo(other.getRegistrationDate());
					}
									
				}
			}
		}
	}
		
	
	/**
	 * Returns a hash key associated with that voter object that consists of the last and first name of the object
	 * @return the hash key associated with that voter object that consists of the last and first name of the object(String)
	 */
	public String hashKey() {
		return lastName + " " +  firstName;
	}
	
	/**
	 * Returns a hash key associated with that voter object that consists of last, first and
	 * middle names of the object
	 * @return a hash key associated with that voter object that consists of last, first and
	 * middle names of the object (String)
	 */
	public String brandNewHashKey() {
		return lastName + " " + firstName + " " + middleName;
	}
	
	/**
	 * Returns a hash key associated with that voter object that consists of 
	 * last, first, middle names and date of birth of the object
	 * @return a hash key associated with that voter object that consists of 
	 * last, first, middle names and date of birth of the object (String)
	 */
	public String newHashKey() {
		return lastName + " " + firstName + " " + middleName + " " + dateOfBirth;
	}
	
	/**
	 * Returns a hash key associated with that voter object that consists of 
	 * voterID of the object
	 * @return a hash key associated with that voter object that consists of
	 * voterID of the object (String)
	 */
	public String thisHashKey() {
		return voterID;
	}
	
	/**
	 * Returns a hash key associated with that voter object that consists of 
	 * the last, first, middle names. date of birth and residential address of the object
	 * @return a hash key associated with that voter object that consists of 
	 * the last, first, middle names. date of birth and residential address of the object
	 */
	public String freshHashKey() {
		return lastName + " " + firstName + " " + middleName + " " + dateOfBirth + " " + residentialAddress;
	}
	
	/**
	 * Returns a hash key associated with that voter object that consists of 
	 * the last, first names, date of birth, residential address and registration date of 
	 * the object
	 * @return a hash key associated with that voter object that consists of 
	 * the last, first names, date of birth, residential address and registration date of 
	 * the object (String)
	 */
	public String anotherHashKey() {
		return lastName + " " + firstName + " " +  dateOfBirth + " " + 
	 residentialAddress + " "  + registrationDate;
	}
	
	
}
