package deduplication.sqf;

import java.io.FileNotFoundException;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import com.opencsv.CSVReaderHeaderAware;

/**
 * Stores the full data set. Reads in the CSV file
 * taken from the command line as an argument 
 * into an ArrayList of String arrays. Holds
 * four different data deduplication methods
 * that return new ArrayLists holding the same data
 * as original one but without duplicates.
 * Includes helper methods for data deduplication methods.
 * 
 * 
 * 
 * 
 * 
 * 
 * @author Olga Shevchuk
 * @version 14th May, 2020
 */

public class VotersRoster {
	
	// holds the data set of voter objects
	private ArrayList <VoterInfo> data;
	
	
	
	/**
	 * Constructor for the VotersRoster class
	 * that takes the file name given as a command line 
	 * argument as a parameter and reads in the whole data set 
	 * into ArrayList of String arrays and then adds each String array
	 * representing a row from a file and turned into a voter object 
	 * to the new ArrayList
	 * 
	 * 
	 * @param fileName: the file name given as a command line argument
	 */
	public VotersRoster(String fileName) {
		
		data = new ArrayList<VoterInfo>(); // initializing the new ArrayList
		
		try {
			// opens the reader
			CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(fileName));
			// reads files into ArrayList of String arrays
			ArrayList<String[]> myEntries = new ArrayList<String[]> (reader.readAll());
			
			for(String[] e: myEntries) {       // converting each row in the file into
				data.add(new VoterInfo(e));    // the voter object and adding it to the 
				                               // new ArrayList
			}
			
			reader.close(); // closes the reader
		} catch (FileNotFoundException e) { // when file cannot be found
			e.printStackTrace(); // handles an exception
		} catch (IOException e) { // when file contains an error or cannot be found
			e.printStackTrace(); // handles an exception
		}
	}

	
	/**
	 * Constructor for the VotersRoster class 
	 * that takes the file name given as a command line 
	 * argument and the number of rows to read from that file as
	 * parameters. Reads the specified number of rows and adds them 
	 * to the new ArrayList converting them into voter objects.
	 * 
	 * 
	 * @param fileName: the file name given as a command line argument
	 * @param numRows: the number of lines to be read in from the file
	 */
	public VotersRoster(String fileName, int numRows) {
		
		data = new ArrayList<VoterInfo> (); // initializing the new ArrayList
		
		try {
			// opens the reader
			CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(fileName));
			
    
    		for (int i = 0; i < numRows; i++) {               // converting each row read in 
    			data.add(new VoterInfo(reader.readNext()));   // into the voter object and adding 
    			                                              // it to the new ArrayList
    		}
    		
    		reader.close(); // closes the reader
		} catch (FileNotFoundException e) { // when file cannot be found
			e.printStackTrace(); // handles an exception
		} catch (IOException e) { // when file contains an error or cannot be read
			e.printStackTrace(); // handles an exception
		}
	}
	
	/**
	 * Getter for the ArrayList that holds
	 * the data set of voter objects
	 * @return the ArrayList that
	 * holds the data set of voter objects (ArrayList<VoterInfo>)
	 */
	public ArrayList<VoterInfo> getData() {
		return this.data;
	}
	
	
	/**
	 * Deduplicates the ArrayList of
	 * voter objects comparing each pair of voters 
	 * in the file and not adding the duplicate items to the new list.
	 * @return the ArrayList of voter objects without duplicates (ArrayList<VoterInfo>)
	 */
	public ArrayList<VoterInfo> allPairsDeduplication() {
			
		ArrayList<VoterInfo> newList = new ArrayList<>();
		
		for (int i = 0; i< data.size()-1; i++) {
			boolean seen = false;
			for(int j = i+1; j < data.size(); j++) {
				if (data.get(i).compareTo(data.get(j)) == 0) {
		            seen = true;
				} 
				
			}
			if (seen == false) {
				newList.add(data.get(i));
			} 
				
		}
		newList.add(data.get(data.size()-1)); // always adding the last element
		
		return newList;	
	}
	
	
	/**
	 * Deduplicates the ArrayList of voter objects
	 * using hash table algorithm of deduplication.
	 * Prints out the  average number of probes during insertions, 
	 * max number of probes during insertions, and load factor after insertions. 
	 * @return a list of non-duplicate items in a given data set (ArrayList<VoterInfo>)
	 */
	public ArrayList<VoterInfo> hashLinearDeduplication() {
		int capacity = 1000003;
		double numOfKeys = 0;
		
		ProbeHashMap<String, Integer> map = new ProbeHashMap(capacity);
		ArrayList<VoterInfo> newList  = new ArrayList<>();
		int max = 0;
	    int probes = 0;
		for (VoterInfo e: data) {
			
			String keyString = e.anotherHashKey(); // getting a key for each voter
			
			if (map.get(keyString) == null) { // if the hash table does not contain a value        
				map.put(keyString, 0) ;       // associated with a specified key
				numOfKeys++;                  // increasing the number of keys in the map
				int numOfProbes = map.getNumOfProbes();
				probes = probes + numOfProbes; // summing up the probes for each key
				if (numOfProbes > max) {
					max = numOfProbes;
				}
				newList.add(e);
			} 
			
			map.put(keyString, map.get(keyString) + 1);
			
		}
		
		double averageNumOfProbes = probes/ numOfKeys;
		double loadFactor = numOfKeys/capacity;
		System.out.println("Average number of probes: " + averageNumOfProbes);
		System.out.println("Max number of probes: " + max);
		System.out.println("Load factor: " + loadFactor);
		
		return newList;
		
	}
	
	
	/**
	 * Deduplicates the ArrayList of voter objects
	 * by comparing the objects one by one in the sorted
	 * ArrayList and not adding the duplicates to the new ArrayList
	 * @return a list of non-duplicate items in a given data set (ArrayList<VoterInfo>)
	 */
	public ArrayList<VoterInfo> quicksortDeduplication() {
		ArrayList<VoterInfo> newList = new ArrayList<>();
		quickSort(data, 0, data.size()-1); // rearranging the existing ArrayList
		for(int i = 0; i < data.size()-1; i++) {
			if(data.get(i).compareTo(data.get(i+1))!= 0) {
				newList.add(data.get(i));
			}
		}
		
		
		newList.add(data.get(data.size()-1)); // always adding the last element
			
		return newList;
	}
	
	/**
	 * Performs quicksort on the ArrayList holding 
	 * the data set of voter objects in-place and sorts the objects 
	 * by their last and then first names in ascending order
	 * @param list: ArrayList holding the data set of voter objects
	 * @param low: the lowest index in the input ArrayList
	 * @param high: the highest index in the input ArrayList
	 */
	public void quickSort(ArrayList<VoterInfo> list, int low, int high) {
		
	    // base case
		if (low >= high) {
			return;
		} else {
		
			int index = partition(list, low, high);
			//recursive functions
			quickSort(list, low, index-1);
			quickSort(list, index+1, high);
		
		}
	}
	
	/**
	 * Helper method that returns the index where the pivot should go
	 * in the ArrayList defined on the range from the lowest
	 * index to the highest one
	 * @param list: ArrayList holding the data set of voter objects
	 * @param low: the lowest index in the ArrayList
	 * @param high: the highest index in the ArrayList
	 * @return the index where the pivot should be placed in the subArrayList (int)
	 */
	public int partition(ArrayList<VoterInfo> list, int low, int high) {
		VoterInfo pivot = list.get(low); // taking the element at the lowest index to be the pivot
		int i = low;
		int j = high;
		while(i!=j) {
			
			if (list.get(i) == pivot) {
				if(pivot.compareTo(list.get(j)) <= 0) {
					j--;
				} else {
					swap(list, i, j);
				}
			
			} else if (list.get(j) == pivot) {
			
				if(pivot.compareTo(list.get(i)) >= 0) {
					i++;
				} else {
					swap(list, i, j);
			    }
			}
		}
		return i;
		
		
	}
	 /**
	 * Helper method that swaps the elements at the specified indices
	 * @param list: ArrayList holding the data set of voter objects
	 * @param startIndex: the lower index out of the indices of two elements to be swapped
	 * @param endIndex: the higher index out of the indices of two elements to be swapped
	 */
	public void swap(ArrayList<VoterInfo> list, int startIndex, int endIndex) {
			VoterInfo startObject = list.get(startIndex);
			VoterInfo endObject = list.get(endIndex);
			list.set(startIndex, endObject);
			list.set(endIndex, startObject);
		}
		
	
	/**
	 * Sorts the existing ArrayList using built-in 
	 * sorting method.
	 * Deduplicates the ArrayList of voter objects 
	 * by comparing the objects one by one in the sorted
	 * ArrayList and not adding the duplicates to the new ArrayList
	 * @return a list of non-duplicate items in a given data set (ArrayList<VoterInfo>)
	 */
	public ArrayList<VoterInfo> builtinSortDeduplication() {
		ArrayList<VoterInfo> newList = new ArrayList<>();
		Collections.sort(data);
		for(int i = 0; i < data.size()-1; i++) {
			if(data.get(i).compareTo(data.get(i+1))!= 0) {
				newList.add(data.get(i));
			}
		}
		newList.add(data.get(data.size()-1)); // always adding the last element
			
		return newList;
	}

	
}

