
package stacksqueues;

/**
 * A class that represents a generic node used
 * to create a generic linked list which we use 
 * to implement a generic stack. Includes instance variables, 
 * constructors, getters an setters for the data in the node.
 * 
 * 
 * @author Olga Shevchuk
 * @version 25th March, 2020
 */

public class Node<E> {
	
	private E data; //special data, generic placeholder
	private Node<E> next; // reference to the next Node
	
	/**
	 * A constructor for the Node class that
	 * creates a node with null references to its element and the next node
	 */
	public Node() {
		this(null, null);
	}
	
	
	/**
	 * A constructor for the node class that 
	 * creates a node with the given data and the next node
	 * @param initData: a given data that the data of the node is set to
	 * @param initNext: a given reference to the next node that reference to 
	 * next Node in the existing node is set to
	 */
	public Node(E initData, Node<E> initNext) {
		data = initData;
		next = initNext; 
	}
	
	/**
	 * Getter for the data of this node
	 * @return the data of this node(E)
	 */
	public E getData() {
		return this.data;
	}
	
	/**
	 * Getter for the next node of this node
	 * @return the next node of this node (E)
	 */
	public Node<E> getNext() {
		return this.next;
	}
	
	/**
	 * Sets the data of this node
	 * @param newData: the given data for the node to be set to
	 */
	public void setData(E newData) {
		data = newData;
	}
	
	/**
	 * Sets the next node of this node
	 * @param newNext: the next node that the reference to the next Node of this 
	 * node is set to
	 */
	public void setNext(Node<E> newNext) {
		next = newNext;
	}
    
}

