
package stacksqueues;

import java.util.EmptyStackException;

/**
 * Implements the stack ADT using 
 * a generic singly linked list. 
 * An exception is thrown if 
 * peek and pop operations are attempted when 
 * the stack is empty. This class includes 
 * the main methods of the built-in class 
 * java.util.Stack and a toString method that 
 * includes a string representation of the elements 
 * of the stack in order from the bottom to the top.
 * 
 * 
 * @author Olga Shevchuk
 * @version 25th March, 2020
 */

public class LinkedStack<E> implements Stack<E> {
	
	// instance variables for the LinkedStack class
	private Node<E> top; // reference to the head node
	private int size; // number of elements in the stack
	
	
	/**
	 * A constructor for the LinkedStack class
	 * that constructs an empty stack
	 */
	public LinkedStack() { 
		top = null;
		size = 0;
	}
    
	/**
	 * Getter for the size of the stack
	 * @return the number of elements in the stack (int)
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Evaluates whether the stack is empty
	 * @return true if the stack is empty, false otherwise (boolean)
	 */
	public boolean isEmpty() {
		if(top == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Inserts an element at the top of the stack
	 * @param elem: element to be inserted
	 * (this implementation does not require
	 * a FullStackException to be thrown 
	 * since we are using a linked data structure 
	 * and the stack will never be full)
	 */
	public void push(E elem)  {
		Node<E> newNode = new Node<E>(elem, top); // create and link-in a new node
		top = newNode; // updating the pointer
		size++;	
	}
	
	/**
	 * Inspects the element at the top of the stack
	 * @return top element in the stack (E)
	 * @exception EmptyStackException if the stack is empty
	 */
	public E peek() throws EmptyStackException {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return top.getData();
	}
	
	/**
	 * Removes the top element from the stack
	 * @return element removed (E)
	 * @exception EmptyStackException if the stack is empty
	 */
	public E pop() throws EmptyStackException {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		E temp = top.getData();
		top = top.getNext(); // link-out the former top node
		size--;
		return temp;
	}
	
	/**
	 * @Overrides the built-in toString method
	 * for LinkedStack class 
	 * @return a string representation of the stack 
	 * with elements in order from the bottom to the top of the stack
	 * enclosed in parenthesis and separated by commas (String)
	 */
	public String toString() { 
		LinkedStack<E> newStack = new LinkedStack<>(); // creating an intermediate stack 
		
		if(isEmpty()) {
			return "()"; // returns if there are no elements in the stack
		} 
	    while(!isEmpty()) {
	    	newStack.push(pop()); //pushing the popped elements of the stack 
	    	                      // the new intermediate stack
	    }
	    StringBuilder sb = new StringBuilder("");
	    E element = newStack.peek();
	    sb.append("(" + element); // getting the top element of the new stack
	    newStack.pop();
	    push(element); // to restore contents of the original stack
	    
	    while(!newStack.isEmpty()) {
	    	E element1 = newStack.peek(); // getting the remaining elements of the new stack
	    	sb.append(", " + element1);
	    	newStack.pop();
	    	
	    	push(element1); // to restore contents of the original stack
	    	
	    }
	    sb.append(")");
		return sb.toString();
	
	}
		
}