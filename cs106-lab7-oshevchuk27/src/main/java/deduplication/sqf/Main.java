package deduplication.sqf;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Tests the work done in VotersRoster class
 * by creating an instance of a roster calling 
 * a constructor with a command line argument as 
 * a parameter. Prints out the total number of lines 
 * read in (number of records given), the attributes
 * based on which the equality of voters in a file 
 * was determined, and the number of duplicates 
 * found in a given file. 
 * 
 * 
 * 
 * 
 * @author Olga Shevchuk
 * @version 23rd April, 2020
 * 
 */
public class Main {
	
	/**
	 * Prints out the total number of lines 
     * read in (number of records given), the attributes
     * based on which the equality of voters in a file 
     * was determined, and the number of duplicates 
     * found in a given file. 
	 * @param args: array of Strings representing command line arguments
	 */
    public static void main(String[] args) {
    	
    	

		 VotersRoster roster = new VotersRoster(args[0]);
		        
		 int numRecords = roster.getData().size();
		 int numDuplicates = numRecords - roster.hashLinearDeduplication().size();
		 System.out.println("Records given:" + numRecords);
		 System.out.println("Attributes checked:LAST_NAME,FIRST_NAME,DATE_OF_BIRTH,RESIDENTIAL_ADDRESS1,REGISTRATION_DATE");
		 System.out.println("Duplicates found:" + numDuplicates); 
		        	
	    
    }
}


