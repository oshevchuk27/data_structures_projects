package polling.treesheaps;
/**
 * Implements the BinaryTree by means of a linked structure.
 * Includes instance variables for a LinkedBinaryTree class
 * that include the data stored inside the node of the tree, 
 * and the left and right subtrees. The class also includes 
 * two constructors: one that constructs an empty tree and 
 * the other one that constructs a tree with one element.
 * Includes a recursive insertion method, a method that recomputes 
 * the size of the tree recursively each time it is called, 
 * and three recursive methods that output strings that
 * represent tree traversals in different orders.
 * 
 * 
 * @author Olga Shevchuk
 * @version 3rd April, 2020
 * @param <E> the type of the data in the tree
 */

public class LinkedBinaryTree<E extends Comparable<E>> implements BinaryTree<E> {
	
	private E data; // data inside the node of a tree
	private LinkedBinaryTree<E> left; //pointer to the left subtree
	private LinkedBinaryTree<E> right; //pointer to the right subtree
	
	
	/**
	 * A constructor for LinkedBinaryTree class
	 * that constructs an empty tree
	 */
	public LinkedBinaryTree() {
		this.data = null; // start with an empty tree
		this.left = null;
		this.right = null;
	}
	
	/**
	 * A constructor for LinkedBinaryTree class
	 * that constructs a tree with one element
	 * @param initData: the given data inside the node of the tree
	 */
	public LinkedBinaryTree(E initData) {
		this.data = initData;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Inserts the given element at the correct position in 
	 * the binary tree. Initializes the left and right trees 
	 * as data is added. Uses recursion to keep adding elements to the tree.
	 * @param element: the given element to be added to the tree
	 */
	public void insert (E element) {
		
	    // base case
		if (this.data == null) {
			this.data = element;
		} 
		
		// if the element is bigger than the data
		// in the root of that tree, we add it to 
		// be the root of the right subtree of that tree
		else if (element.compareTo(this.data) > 0) {
			//base case
			if (this.right == null) {
				
				this.right = new LinkedBinaryTree<E>(element);
		  // recursive function
			} else {
		        this.right.insert(element);
			}
		    
		// if the element is smaller than the data
	    // in the root of that tree, we add it to  
		// be the root of the left subtree of that tree
		} else if (element.compareTo(this.data) < 0) {
			// base case
			if (this.left == null) {
				this.left = new LinkedBinaryTree<E>(element);
			// recursive function
			} else {
				this.left.insert(element);
			}
		} else { // if the element being inserted is already in the tree
			this.data = element;
		}
		
	}
	
	
	/**
	 * Getter for the data contained in the root of the tree
	 * @return the data in the current root of the tree (E)
	 */
	public E getRootElement() {
		return this.data;
	}
	
	/**
	 * Computes the size recursively 
	 * @returns the number of elements in the tree (int)
	 */
	public int size() {
		
		// base case
	    if(this.data == null) {
	    	return 0;
	 		}
	    
	    int size = 1; //start with one element which is 
	                  // the root of the tree
	    
	    //recursive function
	    if (this.left!=null) { 
	    	size = size+left.size(); // updates the size adding the size of 
	    	                         // left subtree of that tree
	    }
	    
	    if(this.right!=null) {
	    	size = size + right.size(); // updates the size adding the size of
	    	                            // right subtree of that tree
	    }
	    
	 	return size;
	}
	
	
	public boolean isLeaf() {
		return (this.left == null) && (this.right == null);
	}
	
	public LinkedBinaryTree<E> getRight() {
		return this.right;
	}
	
	public int height() {
		if (this.data == null) {
			return 0;
		} else {
			int leftChild = 0;
			int rightChild = 0;
			if(this.right!=null) {
				rightChild = this.right.height();
			}
			
			if (this.left!=null) {
				leftChild = this.left.height();
			}
			
			if (isLeaf()) {
				return Math.max(rightChild, leftChild);
			} else {
				return 1 + Math.max(rightChild,  leftChild);
			}
		}
	}
	
	/**
	 * Evaluates whether the tree is empty
	 * @returns true if the tree has no elements,
	 * false otherwise(boolean)
	 */
	public boolean isEmpty() {
		return this.data==null;
	}
	
	/**
	 * Puts the elements of 
	 * the tree in order. Includes the base case
	 * for an empty tree. Calls the recursive helper method
	 * that traverses the elements in order.
	 * @return a String that represents 
	 * elements of the tree that are put in order
	 * or an empty String for an empty tree (String)
	 */
	public String toStringInOrder() {
		StringBuilder sb = new StringBuilder("");
		// base case
		if(this.data == null) {
			return sb.toString();
		} 
		// calls a recursive method
		sb.append(toStringInOrderHelper());
		// removes extra space after the String
		return sb.toString().trim();
	} 
	
	
	/**
	 * Helper method for the toStringInOrder() method.
	 * Recursively traverses the elements in order.
	 * @return a String that represents 
	 * elements of the tree that are put in order (String)
	 */
	public String toStringInOrderHelper() {
		StringBuilder sb = new StringBuilder("");
		    
		    // traverses the left subtree
			if (this.left != null) {
				sb.append(this.left.toStringInOrderHelper()); 
			}
		
			sb.append(data + " "); // visits the root
		 
			// traverses the right subtree
			if(this.right!=null) {
				sb.append(this.right.toStringInOrderHelper());
			}
		
		return sb.toString();
	} 
		
	/**
	 * Puts the elements of the tree in pre-order. Includes
	 * the base case for an empty tree. Calls the recursive helper method
	 * that traverses the elements in pre-order.
	 * @return a String that represents
	 * elements of the tree that are put in pre-order
	 * or an empty String for an empty tree (String)
	 * 
	 */
	public String toStringPreOrder() {
		StringBuilder sb = new StringBuilder("");
		// base case
		if(this.data == null) {
			return sb.toString();
		} 
		
		// calls a recursive method
		sb.append(toStringPreOrderHelper());
		// removes extra space after the String
		return sb.toString().trim();
		
	}
	
	/**
	 * Helper method for the toStringPreOrder() method.
	 * Recursively traverses the elements in pre-order.
	 * @return a String that represents elements of the tree
	 * that are put in pre-order (String)
	 */
	public String toStringPreOrderHelper() {
		StringBuilder sb = new StringBuilder("");
		
		sb.append(data + " "); // visits the root
		
		// traverses the left subtree
		if (this.left != null) {
			sb.append(this.left.toStringPreOrderHelper());
		}
	
		// traverses the right subtree
		if(this.right!=null) {
			sb.append(this.right.toStringPreOrderHelper());
		}
	
		return sb.toString();
		
	}

	/**
	 * Puts the elements of the tree in post-order. Includes
	 * the base case for an empty tree. Calls the recursive helper method
	 * that traverses the elements in post-order.
	 * @return a String that represents
	 * elements of the tree that are put in post-order
	 * or an empty String for an empty tree (String)
	 */
	public String toStringPostOrder() {
		StringBuilder sb = new StringBuilder("");
		// base case
		if(this.data == null) {
			return sb.toString();
		} 
		
		// calls a recursive method
		sb.append(toStringPostOrderHelper());
		// removes extra space after the String
		return sb.toString().trim();
	} 
	
	
	/**
	 * Helper method for the toStringPostOrder() method.
	 * Recursively traverses the elements in post-order.
	 * @return a String that represents elements of the tree
	 * that are put in post-order (String)
	 */
	public String toStringPostOrderHelper() {
		
		StringBuilder sb = new StringBuilder("");
		
		// traverses the left subtree
		if (this.left != null) {
			  sb.append(this.left.toStringPostOrderHelper());
		}
		
		// traverses the right subtree
		if(this.right!=null) {
			  sb.append(this.right.toStringPostOrderHelper());
		}
			
	     sb.append(data + " "); // visits the root
	     
		return sb.toString();
	
	}
	
	
	/**
	 * Overrides the built-in toString method for LinkedBinaryTree class.
	 * Includes the Strings representing the pre-order,
	 * in order and post-order tree traversals.
	 * @return a String representing all three tree traversals (String)
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		
		sb.append("Tree:\n");
		sb.append("Pre:\t" + toStringPreOrder() + "\n");
		sb.append("In:\t" + toStringInOrder() + "\n");
		sb.append("Post:\t" + toStringPostOrder());
		
		return sb.toString();
	}
	
			
}
		
		
		
	
	
	

