package polling.treesheaps;

import java.io.FileNotFoundException;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReaderHeaderAware;

/**
 * Tests the work done in the LinkedBinaryTree class
 * by creating instances of binary trees holding different kinds
 * of data and testing different methods on them. Reads in data
 * from the csv files given as command line arguments and inserts 
 * it into the tree.
 * 
 * @author Olga Shevchuk
 * @version 3rd April, 2020
 *
 */

public class Main {
	
    public static void main(String[] args) {
    	
  
    	linkedBinaryTreeTesting(); // tests for LinkedBinaryTree class
    	
       
    	System.out.println("File input testing: ");
    	System.out.println();
    	
    	try {
			CSVReaderHeaderAware reader; 
			// creates a tree of candidates
			LinkedBinaryTree<CandidatePollingData> tree = new LinkedBinaryTree<CandidatePollingData>();
			// looping through the command line argument input that contains the file names
			for (int i=0; i<args.length; i++) {
				reader = new CSVReaderHeaderAware(new FileReader(args[i])); //open the reader
				// reads the files into ArrayList of String arrays
				ArrayList<String[]> myEntries = new ArrayList<String[]>(reader.readAll());
			
				
				for (String[] e: myEntries) {
					tree.insert(new CandidatePollingData(e)); // converting each row in the file 
					                                          // into the candidate object and
					                                          // inserting it into the tree
				}
			
				reader.close(); // closes the reader
				
			}
			System.out.println(tree);
			System.out.println("The size of the tree is " + tree.size());
			
		} catch (FileNotFoundException e1) { // when file cannot be found
			e1.printStackTrace(); //handles an exception
			
		} catch (IOException e1) { // when file contains an error or cannot be read
			e1.printStackTrace(); // handles an exception
		}
    }
    
    
    /**
     * A static method that tests all the methods for LinkedBinaryTree class
     */
    public static void linkedBinaryTreeTesting() {
    	
    	System.out.println("Tree testing: ");
    	System.out.println();
    	System.out.println("myTree: ");
    	System.out.println();
    	BinaryTree<String> myTree = new LinkedBinaryTree<String>();myTree.insert("I");
    	myTree.insert("want");
    	myTree.insert("want");
    	myTree.insert("coronavirus");
    	myTree.insert("to");
    	myTree.insert("end");
    	myTree.insert("!");
    	myTree.insert("want");
    	System.out.println("The root element is: " + myTree.getRootElement());
    	System.out.println("The size is: " + myTree.size());
    	System.out.println("Is the tree empty? " + myTree.isEmpty());
    	System.out.println("In order: " + myTree.toStringInOrder());
    	System.out.println("Pre order: " + myTree.toStringPreOrder());
    	System.out.println("Post order: " + myTree.toStringPostOrder());
    	System.out.println(myTree);
    	
    	System.out.println();
    	
     	System.out.println("intTree: ");
     	System.out.println();
    	
    	BinaryTree<Integer> intTree = new LinkedBinaryTree<Integer>();
    	intTree.insert(8);
    	intTree.insert(11);
    	intTree.insert(5);
    	intTree.insert(17);
    	intTree.insert(1);
    	intTree.insert(9);
    	intTree.insert(3);
    	System.out.println("size: " + intTree.size());
    	System.out.println(intTree);
    	System.out.println("Is the tree empty? " + intTree.isEmpty());
    	System.out.println("The root element is " + intTree.getRootElement());
    	
    	System.out.println();
    	
    	System.out.println("thatTree: ");
     	System.out.println();
    	
    	BinaryTree<Integer> thatTree = new LinkedBinaryTree<Integer>();
    	System.out.println("The height: " + thatTree.height());
    	System.out.println("size: " + thatTree.size());
    	System.out.println("Is the tree empty? " + thatTree.isEmpty());
    	
    	System.out.println();
    	
    	System.out.println("letterTree: ");
     	System.out.println();
     	
     	BinaryTree<Character> heightTree = new LinkedBinaryTree<Character>();
     	heightTree.insert('G');
     	heightTree.insert('C');
     	heightTree.insert('M');
     	heightTree.insert('A');
     	heightTree.insert('F');
     	heightTree.insert('Z');
     	heightTree.insert('D');
     	
     	System.out.println("The height is" + heightTree.getRight().getRight().height());
     			
     	
    	
    	
    	BinaryTree<Character> letterTree = new LinkedBinaryTree<Character>();
    	System.out.println("size before inserting : " + letterTree.size());
    	System.out.println("Is the tree empty? " + letterTree.isEmpty());
    	letterTree.insert('A');
    	letterTree.insert('C');
    	letterTree.insert('G');
    	letterTree.insert('B');
    	letterTree.insert('D');
    	letterTree.insert('G'); // inserting again, should replace
    	letterTree.insert('F');
    	letterTree.insert('E');
    	letterTree.insert('H');
    	letterTree.insert('I');
    	System.out.println("size after insertion is done :" + letterTree.size());
    	System.out.println(letterTree);
    	System.out.println("Is the tree empty? " + letterTree.isEmpty());
    	System.out.println("The root element is " + letterTree.getRootElement());
    	
    	System.out.println();
    	
    	System.out.println("integerTree: ");
     	System.out.println();
    	
      	BinaryTree<Integer> integerTree = new LinkedBinaryTree<Integer>(1);
      	integerTree.insert(2);
      	integerTree.insert(700);
      	integerTree.insert(3);
      	integerTree.insert(4);
      	integerTree.insert(5);
      	integerTree.insert(700);
      	integerTree.insert(6);
      	integerTree.insert(7);
      	System.out.println(integerTree);
      	System.out.println("The root element is " + integerTree.getRootElement());
      	System.out.println("size: " + integerTree.size());
      	
      	System.out.println();
      	
      	System.out.println("numberTree: ");
     	System.out.println();
      	

      	BinaryTree<Integer> numberTree = new LinkedBinaryTree<Integer>();
      	numberTree.insert(45);
      	numberTree.insert(40);
        numberTree.insert(36);
        numberTree.insert(35);
        numberTree.insert(1);
        System.out.println(numberTree);
        System.out.println("The root element is " + numberTree.getRootElement());
        System.out.println("size: " + numberTree.size());
        
        System.out.println();
      	
    }
}
