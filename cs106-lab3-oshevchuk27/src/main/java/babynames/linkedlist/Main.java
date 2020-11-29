package babynames.linkedlist;

import java.io.FileNotFoundException;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



import com.opencsv.CSVReader;

/**
 * Parses the given command line arguments indicating which sex, name, and
 * files to include. Reads the files into an ArrayList of String arrays,
 * calls the final output reporting methods.
 * 
 * @author Olga Shevchuk
 * @version March 1st, 2020
 */
public class Main 
{
    public static void main( String[] args ) {
   
    	
    	// female names for search
    	ArrayList<String> femaleNames = new ArrayList<String>();
    	// male names for search
    	ArrayList<String> maleNames = new ArrayList<String>();
    	
    	Name femaleName; // female name object
    	Name maleName; // male name object
    	LinkedList maleList= new LinkedList(); // LinkedList of male names
    	LinkedList femaleList = new LinkedList(); // LinkedList of female names
    	
    try {
    	
    	CSVReader reader;
    	
    	// looping through the command line argument input that contains the file names
    	for(int i = 2; i <args.length; i++) {    	
    		reader = new CSVReader(new FileReader(args[i])); // open the reader
    		
    		// reads the files into ArrayList of String arrays
    		ArrayList<String[]> myEntries = new ArrayList<String[]>(reader.readAll());
    		for(String[] e: myEntries) {
    	        // initializing the female name object
    			femaleName = new Name(e[0], e[3], e[4], args[i].substring(5,9));
    			// initializing the male name object
    			maleName = new Name(e[0], e[1], e[2], args[i].substring(5,9));
    			
    			femaleList.linkedListWalkIn(femaleName); // calling the method that puts both lists
    			                                         // in alphabetical order
    			maleList.linkedListWalkIn(maleName);
    			
    		}
    		
    		femaleList.updatePercentage(Integer.parseInt(args[i].substring(5,9))); //updates the percentages
    		                                                                       // for each name object in the list
		    maleList.updatePercentage(Integer.parseInt(args[i].substring(5,9)));
           
    		reader.close();// close the reader
           
       } //end for loop
    	
    	
    	LinkedList chosenList;
    	
    	if (args[0].equals("-f")) {
    		chosenList = femaleList; // initializing the female LinkedList
    	} else if(args[0].equals("-m")) { 
    		chosenList = maleList; // initializing the male LinkedList
        } else {
        	throw new IllegalArgumentException("The flag is invalid!");
        }
    	
    	// calling the final output methods
    	System.out.println(chosenList.positionOfNameInTheLinkedList(args[1]));
    	
    	chosenList.finalString(args[1]);
          
        System.out.println(chosenList.totalsString(args[1]));
          
        
        
    } catch (FileNotFoundException e1) { // when file cannot be found
    	e1.printStackTrace(); // handles an exception
    } catch (IOException e1) { // when file contains an error or cannot be read
    	e1.printStackTrace(); // handles an exception
    }
   
    

    } //closes main
}

