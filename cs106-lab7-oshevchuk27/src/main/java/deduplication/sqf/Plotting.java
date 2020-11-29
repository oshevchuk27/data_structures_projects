package deduplication.sqf;



import java.util.ArrayList;
import java.util.Collections;

import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.LinePlot;



/**
 * Plots the runtimes of four deduplication methods
 * created in VotersRoster class. Varies the number of rows
 * read in from the file given as a command line argument
 * and illustrates the change of the runtimes
 * of four methods based on the change of number
 * of rows read in. Includes a method that 
 * prints out runtimes for four data deduplication methods
 * when run on the whole data set and a method that
 * compares runtimes of two sorting methods. Includes methods that 
 * plot the graph that represent the change of the runtime
 * of a recursive Fibonacci method based on the change in
 * n-values.
 * 
 * 
 * 
 * 
 * @author Olga Shevchuk
 * @version 23rd April, 2020
 *
 */

public class Plotting {
	
	/**
	 * Calls the method that prints out 
	 * the runtimes of four deduplication methods
	 * run on the full data set. Initializes the array
	 * of integers representing the different number of rows read
	 * in from a file, the array of doubles representing
	 * the runtimes of three methods corresponding to
	 * the number of rows deduplicated, and the array of
	 * Strings that separates the values in the aforementioned 
	 * arrays to account for each of the deduplication
	 * methods. Calls the newGraphPlot() function with 
	 * those arrays as parameters.
	 * @param args: array of Strings representing command line arguments
	 * 
	 */
	public static void main(String [] args) {
		
		// prints out the runtimes of two sorting methods
		//sortRuntimes(args[0]);
		
		// prints out the runtimes of three data deduplication methods
		//deduplicationMethodsRuntimes(args[0]);
		
		
	      
		int value = 2600;
		int[] numRows = new int [value];
		double [] runTime = new double [value];
		String [] categories = new String [value];
		
		int i = 0;
		for (int r = 2; r < 2002; r++) { // varying the number of rows read in
		
			VotersRoster roster = new VotersRoster(args[0], r); 
			
			// initializing the arrays with the values for the first
			// deduplication method
			long start = startTimer();
			ArrayList<VoterInfo> result = roster.allPairsDeduplication();
			long end = endTimer();
			double timeSec = secondsElapsed(start, end);
			numRows[i] = r;
			runTime[i] = timeSec;
			categories[i] = "all pairs";
			i++; 
		} 
		
		
		for (int c = 2; c < 20002; c+=100) { // varying the number of rows read in
			
			VotersRoster roster = new VotersRoster(args[0], c); 
			
			// initializing the arrays with the values for the second
			// deduplication method
			long newStart = startTimer();
			ArrayList<VoterInfo> newResult = roster.hashLinearDeduplication();
			long newEnd = endTimer();
			double newTimeSec = secondsElapsed(newStart, newEnd);
			numRows[i] = c;
			runTime[i] = newTimeSec;
			categories[i] = "linear hash";
			i++; 
		}
		
		
		
		for (int d = 2; d < 20002; d+=100) { // varying the number of rows read in
			
			VotersRoster roster = new VotersRoster(args[0], d);  
			
			// initializing the arrays with the values for the third
			// deduplication method
			long freshStart = startTimer();
			ArrayList<VoterInfo> freshResult = roster.quicksortDeduplication();
			long freshEnd = endTimer();
			double freshTimeSec = secondsElapsed(freshStart, freshEnd);
			numRows[i] = d;
			runTime[i] = freshTimeSec;
			categories[i] = "quicksort";
			i++;
		} 
		
		for (int p = 2; p < 20002; p+=100) { // varying the number of rows read in
			
			VotersRoster roster = new VotersRoster(args[0], p);
			
			// initializing the arrays with the values for the fourth
			// deduplication method
		    long thisStart = startTimer();
			ArrayList<VoterInfo> thisResult = roster.builtinSortDeduplication();
			long thisEnd = endTimer();
			double thisTimeSec = secondsElapsed(thisStart, thisEnd);
			numRows[i] = p;
			runTime[i] = thisTimeSec;
			categories[i] = "built-in sort";
		    i++;
			
		}
		
		
		newGraphPlot(numRows, runTime, categories); // produces the graphs of runtimes
		                                            // for three deduplication methods
		

		
	}
	
	/**
	 * Starts the timer to evaluate the runtime
	 * of a method
	 * @return the current time in milliseconds (long)
	 */
	public static long startTimer() {
		return System.currentTimeMillis();
		
	}
	
	/**
	 * Ends the timer to evaluate 
	 * the runtime of a method
	 * @return the current time in milliseconds (long)
	 */
	public static long endTimer() {
		return System.currentTimeMillis() ;
	}
	
	/**
	 * Calculates the runtime of a method
	 * @param inputStart: the time before the method was executed
	 * @param inputEnd: the time after the method was executed
	 * @return number of seconds it took to run a certain method (double)
	 */
	public static double secondsElapsed(long inputStart, long inputEnd) {
		return ((double)(inputEnd - inputStart))/1000;		
	}
	
	
	/**
	 * Plots the graphs that represent the change of runtime 
	 * of three deduplication methods based on the change of the number
	 * of rows deduplicated
	 * @param number: an array of integers representing the number of rows deduplicated
	 * @param time: an array of doubles representing runtimes
	 * @param categories: an array of Strings that separates and categorizes the graphs
	 */
	public static void newGraphPlot(int[] number, double[] time, String [] categories) {
			
	
			DoubleColumn column1 = DoubleColumn.create("number of rows deduplicated", number); // initializing the values on the x-axis
			DoubleColumn column2 = DoubleColumn.create("runtime (in seconds)", time); // initializing the values on the y-axis
	
			StringColumn catcolumn = StringColumn.create("graph categories", categories); // a column that categorizes the graphs
			Table table = Table.create("number of rows deduplicated by the deduplication methods"
					+ "and their corresponding runtimes based on the number of rows deduplicated");
			
			table.addColumns(column1, column2, catcolumn);
			Plot.show(LinePlot.create("Runtimes of four data deduplication methods based on the number of rows deduplicated", 
					table, "number of rows deduplicated", "runtime (in seconds)", "graph categories"));
	} 
	
	
	/**
	 * Calculates the runtimes of four data deduplication methods
	 * when run on one of the given datasets
	 * @param fileName: the file given as a command line argument
	 */
	public static void deduplicationMethodsRuntimes(String fileName) {
		VotersRoster roster = new VotersRoster(fileName); // initializes the roster containing all data from a given file
		
		// calculates the runtime of allPairsDeduplication() method
		long start = startTimer();
		ArrayList<VoterInfo> result = roster.allPairsDeduplication();
		long end = endTimer();
		double timeSec = secondsElapsed(start, end);
		System.out.println("The runtime of allPairsDeduplication() method is " + timeSec + " seconds."); 
		
		// calculates the runtime of hashLinearDeduplication() method
		long newStart = startTimer();
		ArrayList<VoterInfo> newResult = roster.hashLinearDeduplication();
		long newEnd = endTimer();
		double newTimeSec = secondsElapsed(newStart, newEnd);
		System.out.println("The runtime of hashLinearDeduplication() method is " + newTimeSec + " seconds."); 
		
		// calculates the runtime of quicksortDeduplication() method
		long freshStart = startTimer();
		ArrayList<VoterInfo> freshResult = roster.quicksortDeduplication();
		long freshEnd = endTimer();
		double freshTimeSec = secondsElapsed(freshStart, freshEnd);
		System.out.println("The runtime of quicksortDeduplication() method is " + freshTimeSec + " seconds.");
	
		// calculates the runtime of builtinSortDeduplication() method
		/*
		long thisStart = startTimer();
		ArrayList<VoterInfo> thisResult = roster.builtinSortDeduplication();
		long thisEnd = endTimer();
		double thisTimeSec = secondsElapsed(thisStart, thisEnd);
		System.out.println("The runtime of builtInSortDeduplication() method is " + thisTimeSec + " seconds.");
		*/
	}
	
	/**
	 * Calculates the runtimes of two different sorting methods
	 * when run on one of the given datasets
	 * @param fileName: the file given as a command line argument
	 */
	public static void sortRuntimes(String fileName) {
		VotersRoster roster = new VotersRoster(fileName);
		ArrayList<VoterInfo> greatResult = roster.getData();
		
		// calculates the runtime of quickSort() method
		long greatStart = startTimer();
		roster.quickSort(greatResult, 0, greatResult.size()-1);
		long greatEnd = endTimer();
		double greatTimeSec = secondsElapsed(greatStart, greatEnd);
		System.out.println("The runtime of quicksort() method is " + greatTimeSec + " seconds."); 
	
		// calculates the runtime of Collections.sort() method
		/*long bigStart = startTimer();
	    Collections.sort(greatResult);
	    long bigEnd = endTimer();
	    double bigTimeSec = secondsElapsed(bigStart, bigEnd);
	    System.out.println("The runtime of Collections.sort() is " + bigTimeSec + " seconds.");
		*/
	}
	
	
	/**
	 * Initializes the array of n-values
	 * and the array of the corresponding 
	 * runtimes based on the n-values given as 
	 * input to the recursive Fibonacci method.
	 * Calls the graphPlot method with those arrays as parameters.
	 */
	public static void fibonacciRuntime() {
		
		int number = 20;
		int [] values = new int[number];
		double [] runSecs = new double[number];
		int j = 0;
		for (int n = number; n < 2*number; n++) {
			long start = startTimer();
			int result = fibonacciNumber(n);
			long end = endTimer();
		    double timeSec = secondsElapsed(start, end);
		    values[j] = n;
		    runSecs[j] = timeSec;
		    j++;
		}
		
		
		 graphPlot(values, runSecs);
		
		
	}
		
	
	/**
	 * Recursive method that returns the nth Fibonacci number
	 * @param n: the order of the number in the Fibonacci sequence
	 * @return the nth Fibonacci number (int)
	 */
	public static int fibonacciNumber(int n) {
		
		// base case
		if(n == 0 || n == 1) {
			return 1;
		} else { // recursive function
			return fibonacciNumber(n-1) + fibonacciNumber(n-2);
		}
	}
	
	/**
	 * Plots the graph that represents the change of the runtime
	 * of recursive Fibonacci method based on the change in n-values.
	 * @param number: an array of integers representing n-values
	 * @param time: an array of doubles representing runtimes
	 */
	public static void graphPlot(int[] number, double[] time) {
		
		DoubleColumn column1 = DoubleColumn.create("n-values", number); // initializing the values on the x-axis
		DoubleColumn column2 = DoubleColumn.create("runtime (in seconds)", time); // initializing the values on the y-axis
		
		
		Table table = Table.create("n-values taken as input by recursive Fibonacci method "
				+ "and the corresponding runtimes of a method with those values as parameters");
		table.addColumns(column1, column2);
		Plot.show(LinePlot.create("The change of the runtime of recursive Fibonacci method "
				+ "based on the change in n-values", table, "n-values", "runtime (in seconds)"));
	}
	
	

}
