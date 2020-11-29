


package babynames.linkedlist;

import java.util.ArrayList;

/* Doubly linked list that holds the nodes that contain baby name objects,
 * a reference to the header and the trailer,
 * contains the method that rearranges the list in 
 * the alphabetical order, a method that returns 
 * a position of a certain node in the linked list,
 * computes the necessary statistics for the input name,
 * reports those statistics back to the main class  
 * 
 * @author Olga Shevchuk
 * @version March 1st, 2020
 * 
 */

public class LinkedList {

	//instance variables for the LinkedList class
	private Node header; // header sentinel
	private Node trailer; // trailer sentinel
	private int size = 0; // number of elements
	
    /** Constructor that creates an empty list */
	public LinkedList() {
		header = new Node (null, null, null); // create header
		trailer = new Node (null, header, null); // create trailer
		header.setNext(trailer); // make header and trailer point to each other
	}
	
	/** Returns the number of elements in the list.*/
	public int size() {
		return size;
	}
    /** Returns whether the list is empty */
	public boolean isEmpty() {
		return size == 0;
	}

    /** Inserts the given element at the head of the list*/
	public void addFirst(Name n) {
		addBetween(n, trailer.prev(), trailer);
	}
    /** Inserts the given element at the tail of the list*/
	public void addLast(Name n) {
		addBetween(n, trailer.prev(), trailer);
	}

	
	// private update methods
	/**Inserts a new element of type Name to the linked list in between the given nodes. */
	private void addBetween(Name node, Node predecessor, Node successor) {
		// create and link a new node
		Node newest = new Node(node, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrevious(newest);
		size++;
	}

	/**
	 * Walk in method that puts the names in the alphabetical order
	 * @param inputName: a name object 
	 */
	public void linkedListWalkIn(Name inputName) {
		Node curr = header.next(); 
		Node prev = header;
         
		// if the list is empty, adds the name object to the beginning of the list
		if(isEmpty()) {
			addBetween(inputName, header, trailer);
		} else {


			// if the input name object has a String name that in the alphabetical order
			// goes after the String name of the current node, we put that name object after the current node
			while((curr.next().getBabyName() != null) 
					&& (inputName.getNameForBaby().compareTo(curr.getBabyName().getNameForBaby()) > 0))  {
			    prev = curr;
				curr = curr.next();	// updates the position of the current node

			}	

			// if the name name in the list already exists, we modify the node with that name,
			// adding the information from the object with the same name
			 if(inputName.getNameForBaby().compareTo(curr.getBabyName().getNameForBaby()) == 0) {
				// accessing the baby name of the current node
				Name current = curr.getBabyName();
				// setting the year, rank, number of names and the percentage information
				// of the current node by adding the information from the new node containing the input name
				current.setYear(inputName.getYearList().get(0));
				current.setRank(inputName.getRankList().get(0));
				current.setNumNames(inputName.getNumNamesList().get(0));
				
				
			// if the input name object has a String name that in the alphabetical order
		    // precedes the String name of the current node, we put that name object before the current node
			} else if (inputName.getNameForBaby().compareTo(curr.getBabyName().getNameForBaby()) < 0){ 
				addBetween(inputName, prev, curr);
			// adds the given name object at the tail of the list if it is the last one in the alphabetical order
			} else {
				addLast(inputName);
			}
		}
	
	}
	
	/**
	 * Returns the position of the node in the linked list
	 * associated with the given input String name
	 * @param inputName: a name associated with a given node
	 * @return position of the node in the LinkedaList (int)
	 */
	public int getPosition (String inputName) {
		int count = 0; // initial position
		if(isEmpty()) {
			return -1; // returns if the list is empty
		} else {
			Node curr = header.next();
			Node prev = header;
			// if the String name of the new node does not match that of the current one, we keep walking 
			// increasing the position
			while((curr.getBabyName() != null) && (inputName.compareTo(curr.getBabyName().getNameForBaby()) != 0))  {

				prev = curr;
				curr = curr.next();	// updating the position in the LinkedList
				count++; // increasing the position

			} 
		
			// if the String name of the new node matches that of the current,
			// we return the position corresponding to the current node
			if ((curr.getBabyName() != null) && 
					(inputName.compareTo(curr.getBabyName().getNameForBaby()) == 0)) { 
				
				
				return count;
			} else {
				return -1;
			}
		}
	}
	
	
	   /**
	    * Calculates the total number of names among all of the years
	    * @return the total number of names among all of the years (int)
	    */
	    public int totalNames() {
		int total = 0;
		Node newNode = header.next();
		while (newNode != null && newNode != trailer) {
			total+=newNode.getBabyName().totalsCalculation(); // summing up the calculations
			                                                  // of totals among all of the years
			                                                 // for each node
		newNode = newNode.next(); // updating the node
		}
	    return total;
	}
	
	/**
	 * Calculates the percentage of babies given that name among all years
	 * @param inputName: a String representing the input name
	 * @return the percentage of babies given that name among all years (double)
	 */
	public double percentageOfBabies(String inputName) {
		Node curr = header.next();
		Node prev = header;
		Node inputNameNode;
		double percentage = 0;
        
	   // calculates the percentage if finds the current node with the name that matches the input name
	   while(curr.getBabyName()!=null) {
		   if (inputName.compareTo(curr.getBabyName().getNameForBaby()) == 0) {
			   inputNameNode = curr;
			   percentage = inputNameNode.getBabyName().totalsCalculation()/ (double) totalNames();
			   return percentage;
		   } else {	// keeps walking

				prev = curr;
				curr = curr.next();	

			}	
		}
		
	  return percentage;
	}
	
	/**
	 * Calculates the index of a specific input year in the ArrayList of years for
	 * the name object
	 * @param inputYear: input year
	 * @return the index of a specific input year in the ArrayList of years
	 * for the name object (int)
	 */
	public int indexOfAYear(int inputYear) {
		Name reference = header.next().getBabyName();
		int index = reference.getYearList().indexOf(inputYear);
		return index;
	} 
	
	/**
	 * Calculates the total number of names for a specific year
	 * @param inputYear: input year
	 * @return the total number of names for a specific year (int)
	 */
	public int totalNamesForAYear(int inputYear) {
		int total = 0;
		Node newNode = header.next();
		while (newNode != null && newNode != trailer) {
			// getting a list of number of names among all the years for a specific name
			ArrayList<Integer> listOfNumNamesForAName= newNode.getBabyName().getNumNamesList();
			// getting a list of number of years for a specific name
			ArrayList<Integer> listOfYearsForAName = newNode.getBabyName().getYearList();
			
			int indexNumNames = listOfYearsForAName.indexOf(inputYear); // index of the input name in the list of years 
			if(indexNumNames != -1) {
				total+=listOfNumNamesForAName.get(indexNumNames); // summing up the number of names at the specific year
			}                                                  // for all nodes
			newNode = newNode.next();
		}
		return total;
	}
	
	/**
	 * Sets the percentage of babies given that name that year
	 * @param inputName: input name
	 * @param inputYear: input year
	 */
	public void percentageOfBabiesForThatNameThatYear(String inputName, int inputYear) {
		Node curr = header.next();
		Node prev = header;
		Node inputNameNode;
		double percentage = 0;

		// sets the percentage if finds the current node with the name that matches the input name
	   while(curr.getBabyName()!=null) {
		   if (inputName.compareTo(curr.getBabyName().getNameForBaby()) == 0) {
			   inputNameNode = curr;
			   percentage = inputNameNode.getBabyName().getNumNamesList().get(indexOfAYear(inputYear))
					   / (double) totalNamesForAYear(inputYear);
		       inputNameNode.getBabyName().setPercentage(percentage);
		   }
		
			   curr = curr.next();	
		   
			   
		}
	}
	
	/**
	 * Returns the total rank of the name among all years 
	 * @param inputName: a String name associated with a given node
	 * @return the total rank of the name among all years (int)
	 */
	public int rankOfTheNameAmongAllYears(String inputName) {
		Node curr = header.next();
		Node prev = header;
		Node inputNameNode = curr;
		while((curr.getBabyName()!=null)&&(curr!=trailer)) {
				if(inputName.compareTo(curr.getBabyName().getNameForBaby()) == 0) {
					inputNameNode = curr;
					break;
				} 
		curr = curr.next();
			  
		} 
		int rank = 0;
		curr = header.next();
		prev = header;
		while((curr.getBabyName()!=null)&&(curr!=trailer)) {
			if(curr.getBabyName().totalsCalculation() >= inputNameNode.getBabyName().totalsCalculation()) {
				rank++;
			} 
		curr = curr.next();
			  
		}
		return rank;
			
	}

	
	/**
	 * Returns the output that represents statistics for each year for
	 * a certain input name
	 * @param inputName: input String name
	 * @param year: input year
	 * @return the output that represents statistics for each year
	 * for a certain input name (String)
	 */
	public void finalString(String inputName) {
		Node curr = header.next();
		Node prev = header;
		Node inputNameNode = null;
		
       // walks to match the String inputName with the name of the current node
	   while(curr.getBabyName()!=null) {
		   if (inputName.compareTo(curr.getBabyName().getNameForBaby()) == 0) {
			   inputNameNode = curr;
		   }
		   curr = curr.next(); // updates the position of the node
		   
	   }
	  
	   int numOfYears = inputNameNode.getBabyName().getRankList().size();
	   for (int i=0; i<numOfYears; i++) {
	   System.out.println("\n" + inputNameNode.getBabyName().getYearList().get(i) + "\n" + inputName + ": " + 
	   inputNameNode.getBabyName().getRankList().get(i) + ", " +
	   inputNameNode.getBabyName().getNumNamesList().get(i) + ", " +
	   String.format("%.6f", inputNameNode.getBabyName().getPercentageList().get(i)));
	   }
	   
	}
	
	/**
	 * Returns the String representing the total statistics for
	 * a specific name in the linked list
	 * @param inputName: input String name
	 * @return the String representing the total statistics for a specific name
	 * in the linked list (String)
	 */
	public String totalsString(String inputName) {
		Node curr = header.next();
		Node prev = header;
		Node inputNameNode = null;
			

		   // walks to match the String inputName with the name of the current node
		   while(curr.getBabyName()!=null) {
			   if (inputName.compareTo(curr.getBabyName().getNameForBaby()) == 0) {
				   inputNameNode = curr;
			   }
			   curr = curr.next(); // updates the position of the node
		   }
		   
		   return "\n" + "Total\n" + inputName + ": " + rankOfTheNameAmongAllYears(inputName) +", " +
		   inputNameNode.getBabyName().totalsCalculation() + ", " + (String.format("%.6f", percentageOfBabies(inputName)));
		
	}
	
	/**
	 * Returns the string representing the position of a certain name object
	 * in the linked list, reporting the information to the main method
	 * @param inputName: input String name
	 * @return the String representing the position of a certain name object
	 * in the linked list (String)
	 */
	public String positionOfNameInTheLinkedList(String inputName)  {
			Node curr = header.next();
			Node prev = header;
			Node inputNameNode = null;
				

			   // walking through the list, if the.s..
			   while(curr.getBabyName()!=null) {
				   if (inputName.compareTo(curr.getBabyName().getNameForBaby()) == 0) {
					   inputNameNode = curr;
				   }
				   curr = curr.next();
			   }
		 
			return  "Position of " + inputNameNode.getBabyName().getNameForBaby() + 
				" in the Linked List: " + getPosition(inputNameNode.getBabyName().getNameForBaby());
    }
  
	/**
	 * Updates the percentage of babies given that name that year 
	 * for each node
	 * @param year: input year
	 */
	public void updatePercentage(int year) {
		Node curr = header.next();
		Node prev = header;
		
		   while(curr.getBabyName()!=null) {
			   double percentage = 0;
			   int listSize = curr.getBabyName().getNumNamesList().size() - 1;
			   percentage = (double) curr.getBabyName().getNumNamesList().get(listSize) / (double) totalNamesForAYear(year);
		       curr.getBabyName().setPercentage(percentage);
			   
			   curr = curr.next();
		   }
		
	}
	

	/* @Overrides the built-in toString method for a LinkedList
	 * @return the string representation of the list
	 */
	  public String toString() {
		 
		  String s = "";
		   
		   Node n = header.next();
		   
		   while (n!=trailer) {
			   s+=n.getBabyName();
			   n = n.next();
		      if (n!= trailer) {
		    	  s+="; \n";
		      }
		   }
		   return s;  
      }
	   
	  
	
}