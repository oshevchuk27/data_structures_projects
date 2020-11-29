
package stacksqueues;

/**
 * Implements a Deque ADT using a generic circular array.
 * An exception is thrown  if getFirst, getLast, removeFirst
 * and removeLast operations are attempted when the deque is 
 * empty and addFirst and addLast operations are attempted
 * when the deque is full. This class includes a subset of 
 * java.util.LinkedList methods and two different methods 
 * that include string representations of the deque 
 * with elements in the order from the first to the last in the queue 
 * 
 * 
 * @author Olga Shevchuk
 * @version 25th March, 2020
 */

public class ArrayDeque<E> implements Deque<E> {
	
	public static final int CAPACITY = 1000; // default array capacity
	
	private int front; // index for the front of the deque
	private int size; // number of elements in the deque
	private int capacity; // The actual capacity of the deque array
	private E[] array; // Generic array used to implement the deque
	
	
	/**
	 * A constructor for the ArrayDeque class
	 * that initializes an array with default capacity
	 */
	public ArrayDeque() {
		this(CAPACITY); 
	}
	
	
	/**
	 * A constructor for the ArrayDeque class 
	 * that allows the user to choose the capacity of the array
	 * @param capacity: the given capacity of the array
	 */
	public ArrayDeque(int capacity) {
		front = 0; // initial index of the front
		size = 0; // initial size
		this.capacity = capacity;
		array = (E[]) new Object[capacity];	 // setting the array with the given capacity
		
	}
	
	
	/**
	 * Getter for the size of the deque
	 * @return the number of elements in the deque(int)
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Evaluates whether the deque is empty
	 * @return true if the deque is empty, false otherwise(boolean)
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	/**
	 * Inserts an element to be the first in the deque
	 * @param element: an element to be added to be the first in the deque
	 * @exception FullQueueException if the deque is full
	 */
	public void addFirst(E element) throws FullQueueException {
		if (size == array.length){
			throw new FullQueueException();
		} 
		front = (front -1 + array.length) % array.length; // changing the front pointer
		array[front] = element; 
		size++;
	}
	
	/**
	 * Inserts an element to be the last in the deque 
	 * @param element: an element to be added to be the last in the deque
	 * @exception FullQueueException if the deque is full
	 */
	public void addLast(E element) throws FullQueueException {
		if(size == array.length) {
			throw new FullQueueException();
		} 
		
	    int end = (front + size) % array.length; // index of the new end of the deque
		array[end] = element;
		
		size++;
		    
	}
	
	
	/**
	 * Removes the first element in the deque
	 * @return the removed element of the deque (E)
	 * @exception EmptyQueueException if the deque is empty
	 */
	public E removeFirst() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		E result = array[front];
		array[front] = null;
		front = (front + 1) % array.length; // changing the front pointer
		size --;
		return result;
	}
	
	
	/**
	 * Removes the last element in the deque
	 * @return the removed element of the deque (E)
	 * @exception EmptyQueueException if the deque is empty
	 */
	public E removeLast() throws EmptyQueueException {
		if(isEmpty()) {
			throw new EmptyQueueException();
		}
		int end = (front + size - 1) % array.length; // index of the current end of the deque
		E result = array[end];
		array[end] = null;
		end = (end - 1 + array.length) % array.length; // changing the end pointer
		size--;
		return result;
	}
	
	/**
	 * Returns the first element of the deque
	 * @return the first element of the deque (E)
	 * @exception EmptyQueueException if the deque is empty
	 */
	public E first() throws EmptyQueueException {
		if(isEmpty()) {
			throw new EmptyQueueException();
		}
		return array[front];
	}
	
	
	/**
	 * Returns the last element of the deque
	 * @return the last element of the deque (E)
	 * @exception EmptyQueueException if the deque is empty
	 */
	public E last() throws EmptyQueueException {
		if(isEmpty()) {
			throw new EmptyQueueException();
		}
		int end = (front + size - 1) % array.length; // index of the current end of the deque
		return array[end];
	}
	
	
	/**
	 * @Overrides the built-in toString method 
	 * for the ArrayDeque class
	 * @return a string representation of the deque 
	 * with elements in order from the first to the last in the queue
	 * enclosed in parenthesis and separated by commas (String)
	 */
	public String toString() {
		
		if (isEmpty()) {
			return "()"; // returns if there are no elements in the deque
		}
		StringBuilder sb = new StringBuilder("");
		int i = front; 
		int end = (front + size) % array.length; // index of the array cell after the last element of the deque
		sb.append("(" + array[i]); // appending the first element in the queue
		i = (front + 1) % array.length; // changing i pointer
		while(i!=end) {
			sb.append(", " + array[i]); // appending all the following elements in the queue
			i= (i+1)%array.length; // changing i pointer
		}
		sb.append(")");
		return sb.toString();
	}
	
	/**
	 * Returns a string representation of the deque 
	 * with elements in order from the first to the last in the queue
	 * separated by spaces 
	 * @return a string representation of the deque (String)
	 */
	public String stringVersion() {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < size; i++) { // loops from 0 up to size because
			                             // we are always adding last and the 
			                             // front pointer does not change
			sb.append(array[i] + " ");
		}
		return sb.toString();
	}
	
}
