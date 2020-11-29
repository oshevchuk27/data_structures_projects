/**
 * Tests the work done in DefendantsRoster class
 * Reads the file into an ArrayList of objects, 
 * creates the instance of the DefendantsRoster 
 * object.
 * Prints out data table that replicates the ProPublica chart.
 * 
 * @author Olga Shevchuk
 * @version 6th February, 2020
 */



package propublica.datadesign;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReaderHeaderAware;


public class Main 
{
    public static void main( String[] args ) {
        
        
        try {
        	// reads the csv file 
           CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader("compas-scores.csv"));
           // reads the csv file, stores each row as an array of Strings and adds them to an ArrayList
           ArrayList<String[]> myEntries = new ArrayList<String[]>(reader.readAll());
           // creates an instance of the DefendantsRoster object by calling the constructor 
           // for the DefndantsRoster object passing the ArrayList of Strings as the parameter
           DefendantsRoster info = new DefendantsRoster(myEntries); // creates a DefendantsRoster object of defendant objects           
           reader.close(); // closes the reader
           // creates the new table 
           PropublicaDataTable data = new PropublicaDataTable(info.isFalsePositiveWhite(),
        		   info.isFalsePositiveBlack(), info.isFalseNegativeWhite(), info.isFalseNegativeBlack());
           // prints out the table
           System.out.println(data);
           /* remove comment to run optional analysis
           PropublicaDataTable data1 = new PropublicaDataTable(info.isFalsePositiveWhiteOptional(),
        		   info.isFalsePositiveBlackOptional(), info.isFalseNegativeWhiteOptional(), info.isFalseNegativeBlackOptional());
           System.out.println(data1);  */
           

        } catch (FileNotFoundException e1) { // when file cannot be found
        	e1.printStackTrace(); // handles an exception
        } catch (IOException e1) { // when file contains an error or cannot be read
        	e1.printStackTrace(); // handles an exception
        }
       
    
    }
}
