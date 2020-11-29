package babynames.linkedlist;

import java.util.ArrayList;

import java.util.Arrays;
/**
 * Holds the information about the name object,
 * including a String name, ArrayLists representing 
 * the years when this name object was present, 
 * the number of names, the ranks and the percentages 
 * of this object across the years. Includes constructors,
 * getters and setters for the instance variables
 * 
 * @author Olga Shevchuk
 * @version March 1st, 2020
 *
 */

public class Name {
	
	
    // instance variables for the name class
	private final String nameForBaby; // a String representing name
    private ArrayList<Integer> yearList = new ArrayList<Integer>(); // represents the years when
                                                                    // this object was present                                                                
    private ArrayList<Integer> numNamesList = new ArrayList<Integer>(); // represents the number of names
                                                                      // of this object across the years
    private ArrayList<Integer> rankList = new ArrayList<Integer>(); // represents the ranks of this object 
                                                                    // across the years
    private ArrayList<Double> percentageList = new ArrayList<Double>(); // represents the percentages of this 
                                                                       // object across the years
	private int nameTotal = 0; // total number of babies with a specific name among all of the years
    
	
	/**
	 * A constructor that creates a Name with given fields
	 * @param rank: rank of an object in one specific year
	 * @param name: String name of an object
	 * @param numNames: number of names of an object in one specific year
	 * @param year: a year when the object was present
	 */
	public Name(int rank, String name, int numNames, int year) {

		this.nameForBaby = name;
		this.yearList.add(year);
		this.numNamesList.add(numNames);
		this.rankList.add(rank);
	}
	/**
	 * A constructor that creates a Name parsing a string input
	 * @param rank: rank of an object in one specific year
	 * @param name: String name of an object
	 * @param numNames: number of names of an object in one specific year
	 * @param year: a year when the object was present
	 */
	    public Name(String rank, String name, String numNames, String year) {
		this.rankList.add(Integer.parseInt(rank));
		this.nameForBaby = name;
		this.numNamesList.add(Integer.parseInt(numNames));
		this.yearList.add(Integer.parseInt(year));
		
	}
		/** Getter for the String that represents the baby name
         * @return a String that represents a baby name 
         */
		public String getNameForBaby() {
			return this.nameForBaby;
		}
		/** Getter for the ArrayList that represents the list of years
         * @return an ArrayList that represents the list of years 
         */
		public ArrayList<Integer> getYearList() {
			return this.yearList;
		}
		/** Getter for the ArrayList that represents the list of number of names
         * @return an ArrayList that represents the list of number of names
         */
		public ArrayList<Integer> getNumNamesList() {
			return this.numNamesList;
		}
		/** Getter for the ArrayList that represents the list of ranks
         * @return an ArrayList that represents the list of ranks  
         */
		public ArrayList<Integer> getRankList() {
			return this.rankList;
		}
		/** Getter for the ArrayList that represents list of percentages
         * @return an ArrayList that represents the list of percentages 
         */
		public ArrayList<Double> getPercentageList() {
			return this.percentageList;
		}
		
		/** Setter for the ArrayList that represents the list of years
        /@param: a year to be added to the ArrayList (int)
        */
		public void setYear(int newYear) {
			yearList.add(newYear);
		}
		/** Setter for the ArrayList that represents the list of number of names
        /@param: a number of names to be added to the ArrayList(int)
        */
		public void setNumNames(int newNumNames) {
			numNamesList.add(newNumNames);
		}
		/** Setter for the ArrayList that represents the list of ranks
        /@param: a rank to be added to the ArrayList (int)
        */
		public void setRank(int newRank) {
			rankList.add(newRank);
		}
		/** Setter for the ArrayList that represents the list of percentages
        /@param: percentage to be added to the ArrayList (int)
        */
		public void setPercentage(double newPercentage) {
			
			percentageList.add(newPercentage);
		}
		/*
		 * Calculates the number of babies with a specific name among all of the years
		 * @return the number of babies with a specific name among all of the years (int)
		 */
		public int totalsCalculation() {
			int total = 0;
		
			for(int e: numNamesList) {
				total+=e;
		     }
			nameTotal = total;
			return total;
	     }
		
		
		 /* Returns the total number of names for a specific name among all of the years
		  * @return: the total number of names for a specific name among all of the years (int)
		  */
		public int getNameTotal() {
			return nameTotal;
		}
		
		/**
		 * @Overrides the built-in toString method for the Name class
		 * @returns a String representation of the name
		 */
		public String toString() {
			String yrList = "";
			String numList = "";
			String rkList = "";
			String percList = "";
			for (int i =0; i<yearList.size(); i++) {
				yrList+=yearList.get(i) + " ";
				
			}
			for (int i =0; i<numNamesList.size(); i++) {
				numList+=numNamesList.get(i) + " ";
			}
			for (int i =0; i<rankList.size(); i++) {
				rkList+=rankList.get(i) + " ";
			}
			for (int i =0; i<percentageList.size(); i++) {
				percList+=percentageList.get(i) + " ";
			}
			return "name: " + nameForBaby + "; rank: " + rankList + "; number of names " + numNamesList + "; percentage of babies " +
			percentageList;
			
			
		}
		
	
	
	

}
