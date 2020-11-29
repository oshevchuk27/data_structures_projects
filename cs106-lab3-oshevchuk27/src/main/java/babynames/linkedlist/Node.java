/** 
 * Holds the the baby name object,
 * the reference to the previous and next nodes,
 * contains constructors, getters and setters for each of 
 * the instance variables
 * 
 * @author Olga Shevchuk
 * @version March 1st, 2020
 * 
 */

package babynames.linkedlist;

import java.util.ArrayList;

public class Node {

	// instance variables for the Node class
	private Name babyName; // a baby name object
	private Node previous; // a reference to the previous node
	private Node next; // a reference to the next node

	
	/**
	 * A default constructor for the Node class
	 * that sets the fields to null
	 */
	public Node() {
		this.babyName = null;
		this.previous = null;
		this.next = null;
	}
	/** Constructor that creates a node with given fields*/
	public Node(Name name, Node previous, Node next) {
		this.babyName = name;
		this.previous = previous;
		this.next = next;
	}
	/*
	 * Getter for the baby name object of this node
	 * @return the baby name object(Name)
	 */
	public Name getBabyName() {
		return this.babyName;
	}
	/* Returns the previous node of this node*/
	public Node prev() {
		return this.previous;
	}
	/* Returns the next node of this node*/
	public Node next() {
		return this.next;
	}
	/** Sets the element of this node*/
	public void setBabyName(Name newBabyName) {
		this.babyName = newBabyName;
	}
	/** Sets the previous node of this node*/
	public void setPrevious(Node newPrevious) {
		this.previous = newPrevious;
	}
	/** Sets the next node of this node*/
	public void setNext(Node newNext) {
		this.next = newNext;
	}
	/** Returns the default string representation of 
	 * the node set to null */
	public String toString() {
		return null;
    }
	
	
}
