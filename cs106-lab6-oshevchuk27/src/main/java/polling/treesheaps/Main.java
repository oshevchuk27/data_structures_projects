package polling.treesheaps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.opencsv.CSVReaderHeaderAware;

/**
 * Tests the work done in ArrayHeap class
 * by creating instances of heaps holding different 
 * kinds of data and testing different methods on them. 
 * Reads in data from the csv files given as command line arguments 
 * and inserts it into the heap.
 * Prints out the candidates from the file in order from high to low polling number
 * using the removeMax function
 * 
 * 
 * 
 * 
 * @author Olga Shevchuk
 * @version 9th April, 2020
 *
 */

public class Main {
    
	/**
	 * The main method where polling data from csv is read in and inserted
	 * into the heap and the sorted heap is printed out. 
	 * Includes a call to the method that does 
	 * the testing for ArrayHeap class
	 * @param args: array of Strings representing command line arguments
	 */
    public static void main(String[] args) {

    	
    	arrayHeapTesting(); //tests for ArrayHeap class

    	
    	try {
    		CSVReaderHeaderAware reader;
    		
    		// creates a heap of candidates
    		ArrayHeap<CandidatePollingData> thisHeap = new ArrayHeap<CandidatePollingData>();
    		
    		reader = new CSVReaderHeaderAware(new FileReader(args[0])); // opens the reader
    		
    		// reads files into ArrayList of String arrays
    		ArrayList<String[]> myEntries = new ArrayList<String[]>(reader.readAll());
    		
    		for(String[] e: myEntries) {
    			thisHeap.insert(new CandidatePollingData(e)); // converting each row in the file
    			                                              // into the candidate object and 
    			                                              // inserting it into the heap
    		}
    		
    		
    		
    		reader.close(); //closes the reader
    		
    		System.out.println("File heap: ");
    	    System.out.println(thisHeap);
    	    System.out.println("size: " + thisHeap.size());
    	    
    	    System.out.println();
    	    
    	    System.out.println("A printout of candidates from highest polling number to lowest: ");
    	    System.out.println();
    		
    	    // sorts the heap of candidates by their polling numbers
    		while(!thisHeap.isEmpty()) {
    			System.out.println(thisHeap.removeMax()); 
    			
    		}
    	
    	
    	} catch (FileNotFoundException e1) { // when file cannot be found
    		e1.printStackTrace(); //handles an exception
		
    	} catch (IOException e1) { // when file contains an error or cannot be read
    		e1.printStackTrace(); // handles an exception
    	}
    	
    	
    }
    
    
    /**
     * A static method that tests all the methods for ArrayHeap class
     */
    public static void arrayHeapTesting() {
    	
    	
       Integer[] arr = {-2,3,9,-7,1,2,6,-3};
       
       ArrayHeap <Integer> myHeap = new ArrayHeap<Integer>();
       for(int i = 0; i<arr.length; i++) {
    	   myHeap.insert(arr[i]);
       }
    	
    
    	System.out.println("First heap: ");
    	System.out.println();
    	System.out.println(myHeap);
    	System.out.println("size: " + myHeap.size());
    	System.out.println("The maximum element of the heap is: " + myHeap.removeMax());
    	

    	
    	System.out.println();
    	
    	System.out.println("Heap after removing the maximum element: ");
    	System.out.println(myHeap);
    	System.out.println("size: " + myHeap.size());
    	
    	
    	System.out.println();
    	
    	System.out.println("Second heap: ");
    	
    	ArrayHeap<Character> letterHeap = new ArrayHeap<Character>();
    	letterHeap.insert('A');
    	letterHeap.insert('C');
    	letterHeap.insert('G');
    	letterHeap.insert('B');
    	letterHeap.insert('D');
    	letterHeap.insert('G'); // inserting again, will still both copies
    	letterHeap.insert('F');
    	letterHeap.insert('E');
    	letterHeap.insert('H');
    	letterHeap.insert('I');
    	
    	System.out.println();
    	
    	System.out.println("Now a heap: ");
    	System.out.println(letterHeap);
    	System.out.println("size:" + letterHeap.size());
    	System.out.println("Is the heap empty? " + letterHeap.isEmpty());
    	
    	System.out.println("The maximum element of the heap is: " + letterHeap.removeMax());
    	
    	System.out.println();
    	
    	System.out.println("Heap after removing the maximum element: ");
    	System.out.println(letterHeap);
    	System.out.println("size: " + letterHeap.size());
    	System.out.println();

    	letterHeap.sort();
    	System.out.println("\nNow sorted: ");
    	System.out.println(letterHeap);
    	
    	System.out.println("size:" + letterHeap.size());
    	
    	System.out.println("The maximum element of the sorted heap is: " + letterHeap.max());
    	
    	System.out.println();
    	
    	System.out.println("Third heap: ");
    	System.out.println();
    	
    	ArrayHeap <Integer> integerHeap = new ArrayHeap<Integer>();
    	
    	integerHeap.insert(3);
    	integerHeap.insert(4);
    	integerHeap.insert(5);
    	integerHeap.insert(6);
    	
    	integerHeap.removeMax();
    	
    	
    	System.out.println(integerHeap);
    	System.out.println("size: " + integerHeap.size());
    	System.out.println("Is the heap empty? " + integerHeap.isEmpty());
    	
    	integerHeap.removeMax();
    	integerHeap.removeMax();
    	integerHeap.removeMax();
    	
    	System.out.println();
    	
    	System.out.println("Heap after removing all elements: ");
    	
    	System.out.println(integerHeap);
    	System.out.println("size: " + integerHeap.size());
    	System.out.println("Is the heap empty? " + integerHeap.isEmpty());
    	
    	
    	System.out.println();
    	Integer[] arr1 = {-2,3,9,-7,1,2,6,-3};
    	ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(arr1)); // converts array into ArrayList
    	System.out.println("Original array: ");
    	System.out.println();
    	System.out.println(array);
    	System.out.println();
    	
    	ArrayHeap<Integer> heap = new ArrayHeap<Integer>(array);
    	
    	System.out.println("Creating a heap out of the original array: ");
    	System.out.println();
    	System.out.println(heap);
    	System.out.println();
    	
    	
    	heap.sort();
    	System.out.println("Sorted array: ");
    	System.out.println();
    	System.out.println(array); // print out the original array, now sorted
    	
    	System.out.println();
    	
    	
    	String[] arr2 = {"hello", "apple", "actor", "actor", "people", "dog"};
    	ArrayList<String> array1 = new ArrayList<String>(Arrays.asList(arr2)); // converts array into ArrayList
    	System.out.println("Original array: ");
    	System.out.println();
    	System.out.println(array1);
    	System.out.println();
    	
    	ArrayHeap<String> heap1 = new ArrayHeap<String>(array1);
    	System.out.println("Creating a heap out of the original array: ");
    	System.out.println();
    	System.out.println(heap1);
    	System.out.println();
    	
    	heap1.sort();
    	System.out.println("Sorted array: ");
    	System.out.println();
    	System.out.println(array1);
    	
    	System.out.println();
    	
    	
    	
    	
    	
    }
    
}
