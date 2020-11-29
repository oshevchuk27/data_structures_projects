package polling.treesheaps;

import java.util.ArrayList;

/**
 * Implements a priority queue using a heap.
 * Includes an instance variable for an ArrayHeap class
 * which is an ArrayList that represents the priority queue.
 * The class also includes two constructors: one that constructs
 * an empty heap and the other one that constructs a heap with 
 * the maximum element in the root out of the input ArrayList.
 * Includes a insert method that insets input elements into the heap,
 * max method that returns the maximum element in the heap, 
 * removeMax method that removes the maximum element, size and 
 * isEmpty methods that return the size of the heap and whether the heap
 * is empty and finally an overriden toString method that outputs 
 * a String representation of the heap that includes elements printed 
 * level by level. Includes some helper methods that are called from
 * the above defined methods that implement the priority queue.
 * 
 * 
 * 
 *@author Olga Shevchuk
 *@version 9th April, 2020
 *@param <E> the type of data in the heap
 */

public class ArrayHeap<E extends Comparable<E>> implements PriorityQueue<E> {
	
	private ArrayList<E> heapArray; // an ArrayList that represents a priority queue 
	                                // implemented as a heap
	
	/**
	 * A constructor for ArrayHeap class
	 * that constructs an empty heap
	 */
	public ArrayHeap() {
		heapArray = new ArrayList<E>();
	}
	
	/**
	 * A constructor for ArrayHeap class
	 * that turns an input ArrayList
	 * into a heap with maximum value 
	 * at the root
	 * @param array: input ArrayList
	 */
	public ArrayHeap(ArrayList<E> array) {
		heapArray = array;
		
		for(int i = 0; i < heapArray.size(); i++) {
		
			bubbleUp(i);
			
		}
		
	}
	
	/**
	 * Returns the size of the heap
	 * @return number of elements in the heap(int)
	 */
	public int size() {
		return heapArray.size();
	}
	
	/**
	 * Evaluates whether the heap is empty
	 * @return true if the heap is empty, 
	 * false otherwise (boolean)
	 */
	public boolean isEmpty() {
		return heapArray.size()==0;
	}
	
	/**
	 * Returns the maximum element in the heap
	 * @return the maximum element in the heap(E)
	 */
	public E max() {
		if (isEmpty()) {
			return null;
		}
		return heapArray.get(0);
	}
	
	/**
	 * Adds an element to the heap
	 * @param element: element to be added to the heap
	 */
	public void insert (E element) {
		heapArray.add(element);
		bubbleUp(heapArray.size() - 1);
	}
	
	/**
	 * Removes the maximum element in the heap
	 * @return the maximum element in the heap (E)
	 */
	public E removeMax() {
		if (isEmpty()) {
			return null;
		}
		E maxElement = heapArray.get(0);
		E lastElement = heapArray.get(heapArray.size() - 1);
		heapArray.set(0, lastElement);
		heapArray.remove(heapArray.size() - 1);
		bubbleDown(0);
		
		return maxElement;
	}
	
	
	/**
	 * Sorts the ArrayList low to high
	 */
	public void sort() {
		for(int i = heapArray.size()-1; i > 0; i--) {
			swap(0, i);
			bubbleDown(0, i);
		}
	}
	
	/**
	 * Helper method that bubbles down the element at the specific index in the heap
	 * to restore the heap property disregarding the last elements 
	 * at each stage which then create the sorted ArrayList
	 * @param startIndex: index the element at which we need to bubble down
	 * @param endIndex: index of the element which should not be included in the bubbling down process
	 */
	public void bubbleDown(int startIndex, int endIndex) {
		while ((leftChild(startIndex) < endIndex)) {
			
				int biggerChild = leftChild(startIndex); // if there is only one child which is left or
			                                         	// if there are two children and the left one is bigger than 
			                                         	// the right one
			
				if((rightChild(startIndex) < endIndex) &&
						(heapArray.get(leftChild(startIndex))).compareTo(heapArray.get(rightChild(startIndex))) < 0) {
					biggerChild = rightChild(startIndex);	// if there are two children and the right one is bigger
				}
			
				if(heapArray.get(startIndex).compareTo(heapArray.get(biggerChild)) < 0) { 
					swap(startIndex, biggerChild);  // swapping the element with the biggest child if the element
				                                // is smaller than the bigger child
				} else { 
				         // if the element is bigger than the bigger child,
					break;   // then it is also bigger than the smaller child, 
				         // so the heap property is satisfied and no swapping is needed
				
				}
				
				startIndex = biggerChild; // updating the index of the element after the swapping
		
		}
	}
	
	
	/**
	 * Helper method that swaps the elements at specific indexes
	 * @param parentIndex: index of the parent element to be swapped
	 * @param childIndex: index of the child element to be swapped
	 */
	
	public void swap(int parentIndex, int childIndex) {
		E parent = heapArray.get(parentIndex);
		E child = heapArray.get(childIndex);
		heapArray.set(parentIndex, child);
		heapArray.set(childIndex, parent);
	}
	
	/**
	 * Helper method that calculates the index of a parent
	 * @param child: the index of the child whose parent's index needs to be calculated
	 * @return the index of a parent calculated out of the input index of a child
	 * @throws IndexOutOfBoundsException if the input index is 0,
	 * the element at which then cannot have any parents
	 */
	public int parent (int child) throws IndexOutOfBoundsException {
		if(child == 0) {
		   throw new IndexOutOfBoundsException("The element at index 0 cannot have any parents!");
		}  
		return (child-1)/2;
	}
	
	/**Helper method that calculates the index of a left child of a parent
	 * @param parentIndex: the index of the parent whose left child's index needs to be calculated
	 * @return the index of the left child calculated out of the input index of a parent
	 */
	public int leftChild(int parentIndex) {
		return 2*parentIndex + 1;
	}
	
	/**
	 * Helper method that calculates the index of the right child of a parent
	 * @param parentIndex: the index of the parent whose right child's index needs to be calculated
	 * @return the index of the right child calculated out of the input index of a parent
	 */
	public int rightChild(int parentIndex) {
		return 2*parentIndex + 2;
	}
	
	/**
	 * Helper method that bubbles up the element in the ArrayList at specific index
	 * to restore the heap property
	 * @param inputIndex: the index of the element which needs to be bubbled up
	 */
	public void bubbleUp(int inputIndex) {
		while(inputIndex>0 && heapArray.get(inputIndex).compareTo(heapArray.get(parent(inputIndex))) > 0) {
			swap(parent(inputIndex), inputIndex);
			inputIndex = parent(inputIndex); 
		}
	}
	
	
	
	/**
	 * Helper method that bubbles down an element at the specific index 
	 * in the heap to restore the heap property
	 * @param inputIndex: the index of an element that needs to be bubbled down
	 */
	public void bubbleDown(int inputIndex) {
		while ((leftChild(inputIndex) <= heapArray.size() - 1)) {
			
			int biggerChild = leftChild(inputIndex); // if there is only one child which is left or
			                                         // if there are two children and the left one is bigger than 
			                                         // the right one
			
			if((rightChild(inputIndex) <= heapArray.size() -1) &&
					(heapArray.get(leftChild(inputIndex))).compareTo(heapArray.get(rightChild(inputIndex))) < 0) {
				biggerChild = rightChild(inputIndex);	// if there are two children and the right one is bigger
			}
			
			if(heapArray.get(inputIndex).compareTo(heapArray.get(biggerChild)) < 0) { 
				swap(inputIndex, biggerChild);  // swapping the element with the biggest child if the element
				                                // is smaller than the bigger child
			} else { 
				         // if the element is bigger than the bigger child,
				break;   // then it is also bigger than the smaller child, 
				         // so the heap property is satisfied and no swapping is needed
				
			}
				
			inputIndex = biggerChild; // updating the index of the element after the swapping
		}
	}
			
	
	/**
	 * @Override the built-in toString method for the ArrayHeap class.
	 * Includes the String that represents the elements in the heap level by level
	 * @return a String representation of the heap level by level (String)
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		int toPrint = 1;
		int printed = 0;
		for (int i = 0; i<heapArray.size(); i++) {
			sb.append(heapArray.get(i) + " ");
			printed++;
			if (printed == toPrint) {
				sb.append("\n");
				toPrint = toPrint*2; // double elements to print on the next level
				printed = 0; // clear counter
			}
			
		}
		return sb.toString();
	} 
	
	


	
	

}
