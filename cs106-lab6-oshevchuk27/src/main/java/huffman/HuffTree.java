package huffman;
/**
 * Implements a HuffTree (a tree that
 * stores letters and characters by means 
 * of a linked data structure). Includes 
 * instance variables for a HuffTree class
 * that include the data stored inside 
 * node of the tree, and the left and right 
 * subtrees. The class also includes two 
 * constructors: one that constructs an empty 
 * tree and the other one that constructs a tree 
 * with one element. Includes recursive addNode 
 * and decode methods.
 * 
 * 
 * 
 * @author Olga Shevchuk
 * @version 13th April, 2020
 * 
 *
 */

public class HuffTree {
	
	// instance variables for the HuffTree class
	private char data; // data inside the node of the tree
	private HuffTree left; // pointer to the left subtree
	private HuffTree right; // pointer to the right subtree
	
	
	/**
	 * A constructor for HuffTree class
	 * that constructs an empty HuffTree
	 */
	public HuffTree() {
		this.data = 0;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * A constructor for HuffTree class
	 * that constructs a tree with one element
	 * @param initData: the given data inside the node of the tree
	 */
	public HuffTree(char initData) {
		this.data = initData;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Places the character inside
	 * a specific node in the tree
	 * @param symbol: a character to be added to the tree
	 * @param code: a code associated with a character
	 * that is added to the tree
	 */
	public void addNode(char symbol, String code) {
		
		// base case
		if(code.equals("")) {
			this.data = symbol;
		
	    
		} else if (code.charAt(0) == '0') {
			// creates a tree to the left
			if(this.left == null) {
				this.left = new HuffTree();
			}
				// recursive function
				this.left.addNode(symbol, code.substring(1));
		} else if (code.charAt(0) == '1') {
			// creates a tree to the right
			if(this.right == null) {
				this.right = new HuffTree();
			}
				// recursive function
				this.right.addNode(symbol, code.substring(1));
		} 
	 }
	
	

	/**
	 * Returns the first character
	 * that is found in the tree
	 * when the substring of code 
	 * matches the path to that character
	 * @param message: code that needs to be decoded
	 * @return the first character
	 * that is found in the tree (char)
	 * @throws IllegalArgumentException when the input is not a code
	 */
	public char decode1(String message) throws IllegalArgumentException {
	
	
		// base case
		if(message.equals("")) {
			return 0; 
		} 
	    
		// when a character was found
		if (this.data!= 0) {
			return this.data;
		} else { // recursive functions
			// move to the left subtree
			if (message.charAt(0) == '0') {
				return this.left.decode1(message.substring(1));
			// move to the right subtree
			} else if (message.charAt(0) == '1'){
				return this.right.decode1(message.substring(1));
			} else { // when the input is not a code
				throw new IllegalArgumentException("The input is not a code!");
			}
		
		}


	}

}
	


