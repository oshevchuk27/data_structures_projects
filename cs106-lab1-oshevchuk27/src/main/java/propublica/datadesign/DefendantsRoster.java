/**
 * Holds the full CSV file of Defendants data,
 * performs calculations that replicate the values in 
 * the ProPublica chart. 
 * Performs additional analysis based on the change in
 * two year recidivism indicator. 
 * 
 * 
 * 
 * @author Olga Shevchuk
 * @version 16th February, 2020
 */


package propublica.datadesign;

import java.util.ArrayList;

public class DefendantsRoster {
	/**
	 * instance variables for the DefendantsRoster class
	 */
	private ArrayList <Defendant> data; // an ArrayList of Defendant objects 
	
	/**
	 * A constructor for the DefendantsRoster class 
	 * that converts each String array into the Defendant object 
	 * @param input: ArrayList of String arrays
	 */
	public DefendantsRoster(ArrayList<String[]> input) {
		
		data = new ArrayList<Defendant> (); // initializing an ArrayList of 
		                                    // Defendant objects
		
		for (String [] e: input) { // goes through each array of Strings in the ArrayList
			                       // that represents the data from the file
			try {
			// adds a new defendant object to the newly created ArrayList
			data.add(new Defendant(e));
			
			} catch (IllegalArgumentException e1) {
				e1.printStackTrace(); // handles an exception
			}
		}
	}
	/*
	 * Getter for the list of all defendants
	 * @return the variable representing the list of all defendants (ArrayList<Defendant>)
	 */
	public ArrayList<Defendant> getData() {
		return this.data;
	}
	
	/**
	 * A method that overrides a built-in toString method for 
	 * the DefendantsRoster object and returns the valid output 
	 * that would print out all the rows in the file
	 *@return the valid output that prints out all the rows in the file (String)
	 */
	
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for (Defendant e: data) {
			sb.append(e.toString() + "\n");
		}
		return sb.toString();
	}

    /**
     * Calculates the number of white defendants who were rated high
     * and did not re-offend out of the total number of white defendants
     * who survived
     * @return a decimal representing a fraction of white defendants who were labeled high risk 
     * and did not re-offend out of all white defendants who did not re-offend (double)
     */
    public double isFalsePositiveWhite() {
    	double whiteAndHighNotRecidNumber = 0; // a number of white defendants that were 
    	                                       // rated high but did not re-offend initially set to 0
    	double whiteAndNotRecidNumber = 0;    // a total number of white defendants 
    	                                      // who did not re-offend initially set to 0
    	for (Defendant e: data) {
		     if(e.isWhiteAndHighNotRecid()) {
		    	 whiteAndHighNotRecidNumber++;
		     } if(e.isWhiteAndNotRecid()) {
		    	 whiteAndNotRecidNumber++;  
		    	 
		     }
	    }
	    
		return whiteAndHighNotRecidNumber/whiteAndNotRecidNumber;
      }
    
    /**
     * An optionally run method that calculates the number of white defendants
	 * who were rated high but did not re-offend out of the total number of white defendants
	 * who did not re-offend on top including  the defendants whose recidivism charge description is not 
	 * sufficient enough to count them as those who re-offended
	 * @return a decimal representing a fraction of white defendants who were labeled
	 * high but did not re-offend out of all white defendants who did not re-offend
	 * on top including the defendants whose recidivism charge description is not sufficient 
	 * enough to count them as those who re-offended (double) 
     */
  /* public double isFalsePositiveWhiteOptional() {
    	double whiteAndHighNotRecidNumberOptional = 0; // a number of white defendants that were 
    	                                       // rated high but did not re-offend initially set to 0
    	double whiteAndNotRecidNumberOptional = 0;    // a total number of white defendants 
    	                                      // who did not re-offend initially set to 0
    	for (Defendant e: data) {
    		if(e.isWhiteAndHighNotRecidOptional()) {
		    	 whiteAndHighNotRecidNumberOptional++;
		     } if(e.isWhiteAndNotRecidOptional()) {
		    	 whiteAndNotRecidNumberOptional++;  
		    	 
		     }
  
		     
    	}
	    
		return whiteAndHighNotRecidNumberOptional/whiteAndNotRecidNumberOptional;
      } 
    /**
     * Calculates the number of black defendants who were rated high and
     * did not re-offend out of the total number of black defendants who survived
     * @return a decimal representing a fraction of black defendants who were labeled high
     * risk and did not re-offend out of all black defendants who did not re-offend (double)
     */
    public double isFalsePositiveBlack() {
    	double blackAndHighNotRecidNumber = 0; // a number of black people that were rated high
    	                                       // but did not re-offend initially set to 0
    	double blackAndNotRecidNumber = 0; // a total number of black people who did
    	                                    // not re-offend initially set to 0
    	for (Defendant e: data) {
    		if(e.isBlackAndHighNotRecid()) {
    			blackAndHighNotRecidNumber++;
    		} if(e.isBlackAndNotRecid()) {
    			blackAndNotRecidNumber++;
    		}
    	}
    	
    	return blackAndHighNotRecidNumber/blackAndNotRecidNumber;
    }
    
    /**
     * An optionally run method that calculates the number of black defendants
	 * who were rated high but did not re-offend out of the total number of white defendants
	 * who did not re-offend on top including  the defendants whose recidivism charge description is not 
	 * sufficient enough to count them as those who re-offended
	 * @return a decimal representing a fraction of white defendants who were labeled
	 * low risk but re-offended out of all white defendants who re-offended
	 * on top including the defendants whose recidivism charge description is not sufficient 
	 * enough to count them as those who re-offended (double) 
     */
   /* public double isFalsePositiveBlackOptional() {
    	double blackAndHighNotRecidNumber = 0; // a number of black people that were rated high
    	                                       // but did not re-offend initially set to 0
    	double blackAndNotRecidNumber = 0; // a total number of black people who did
    	                                    // not re-offend initially set to 0
    	for (Defendant e: data) {
    		if(e.isBlackAndHighNotRecidOptional()) {
    			blackAndHighNotRecidNumber++;
    		} if(e.isBlackAndNotRecidOptional()) {
    			blackAndNotRecidNumber++;
    		}
    	}
    	
    	return blackAndHighNotRecidNumber/blackAndNotRecidNumber;
    }
  
   /**
    * Calculates the number of white defendants who were rated low but re-offended
    * out of the total number of white defendants who re-offended
    * @return a decimal representing a fraction of white defendants who were labeled low 
    * risk and re-offended out of all white defendants who re-offended (double)
    */
    public double isFalseNegativeWhite() {
    	double whiteAndLowAndRecidNumber = 0; // a number of white people who were
    	                                      // rated low yet did re-offend initially set to 0
    	double whiteAndRecidNumber = 0; // a total number of white people who re-offended
    	                                // initially set to 0
    	for (Defendant e: data) {
    		if(e.isWhiteAndLowAndRecid()) {
    			whiteAndLowAndRecidNumber++;
    		} if(e.isWhiteAndRecid()) {
    			whiteAndRecidNumber++;
    		}
    	
    	}
    	
    	return whiteAndLowAndRecidNumber/whiteAndRecidNumber;
    }
    
     /**
     * An optionally run method that calculates the number of white defendants
	 * who were rated low but re-offended out of the total number of white defendants
	 * who re-offended excluding the defendants whose recidivism charge description is not 
	 * sufficient enough to count them as those who re-offended
	 * @return a decimal representing a fraction of white defendants who were labeled
	 * low risk but re-offended out of all white defendants who re-offended
	 * excluding the defendants whose recidivism charge description is not sufficient 
	 * enough to count them as those who re-offended (double) 
     */
   /* public double isFalseNegativeWhiteOptional() {
    	double whiteAndLowAndRecidNumberOptional = 0;
    	double whiteAndRecidNumberOptional = 0;
    	for (Defendant e: data) {
    		if(e.isWhiteAndLowAndRecidOptional()) {
    			whiteAndLowAndRecidNumberOptional++;
    		} if(e.isWhiteAndRecidOptional()) {
    			whiteAndRecidNumberOptional++;
    		    }
        }
    	
    	return whiteAndLowAndRecidNumberOptional/whiteAndRecidNumberOptional;
   }

    /**
    * Calculates the number of black defendants who were rated low but re-offended
    * out of the total number of black defendants who re-offended
    * @return a decimal representing a fraction of black defendants who were labeled low 
    * risk and re-offended out of all black defendants who re-offended (double)
     */
    public double isFalseNegativeBlack() {
    	double blackAndLowAndRecidNumber = 0; // a number of black people who were rated low
    	                                      // yet did re-offend initially set to 0
    	double blackAndRecidNumber = 0; // a number of black people who re-offended
    	                                 // initially set to 0
    	for (Defendant e: data) {
    		if(e.isBlackAndLowAndRecid()) {
    			blackAndLowAndRecidNumber++;
    		} if(e.isBlackAndRecid()) {
    			blackAndRecidNumber++;
    	    }
    	}
    	
    	return blackAndLowAndRecidNumber/blackAndRecidNumber;
    }
    
    /**
     * An optionally run method that calculates the number of black defendants
	 * who were rated low but re-offended out of the total number of black defendants
	 * who re-offended excluding the defendants whose recidivism charge description is not 
	 * sufficient enough to count them as those who re-offended
	 * @return a decimal representing a fraction of black defendants who were labeled
	 * low risk but re-offended out of all black defendants who re-offended
	 * excluding the defendants whose recidivism charge description is not sufficient 
	 * enough to count them as those who re-offended (double) 
     */
   /* public double isFalseNegativeBlackOptional() {
    	double blackAndLowAndRecidNumberOptional = 0; // 
    	double blackAndRecidNumberOptional = 0;
    	for (Defendant e: data) {
    		if(e.isBlackAndLowAndRecidOptional()) {
    			blackAndLowAndRecidNumberOptional++;
    		}	
    		if(e.isBlackAndRecidOptional()) {
    			blackAndRecidNumberOptional++;
    		}
    	}
    	
    	return blackAndLowAndRecidNumberOptional/blackAndRecidNumberOptional;
    } */
    	
}   		
    
    
    
    

	
	
	


