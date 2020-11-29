
package stacksqueues;

/**
 * Tests the work done in the LinkedStack and ArrayDeque classes
 * by creating instances of stacks and deques holding different kinds 
 * of data and testing different methods on them.
 * 
 * 
 * @author Olga Shevchuk
 * @version 25th March, 2020
 */


public class Main {

	public static void main(String[] args) {
		
		stackTesting(); // calling a method that does all the testing for LinkedStack class
		dequeTesting(); // calling a method that does all the testing for ArrayDeque class
		
	}
    
	
	/**
	 * A static method that tests all the methods for the LinkedStack class
	 */
	public static void stackTesting() {
		
		Stack<Integer> myStack = new LinkedStack<Integer>(); // creating an instance of LinkedStack
		                                                     // of integers
		myStack.push(3);
		myStack.push(2);
		myStack.push(18);
		System.out.println(myStack);
		System.out.println(myStack.peek());
		myStack.push(5);
     	System.out.println(myStack);
     	System.out.println(myStack.peek());
		myStack.push(2);
		myStack.pop(); 
		System.out.println(myStack);
		myStack.push(24);
		myStack.pop();
		myStack.push(17);
		System.out.println(myStack);
		myStack.pop();
		
		System.out.println(myStack.peek());
		
		System.out.println(myStack.size());
		System.out.println(myStack.isEmpty());
		
		Stack<String> thisStack = new LinkedStack<String>(); // creating an instance of LinkedStack 
		                                                     // of Strings
		
		thisStack.push("I");
		thisStack.push("want");
		System.out.println(thisStack.peek());
		thisStack.push("coronavirus");
		thisStack.push("to");
		thisStack.push("end");
		thisStack.push("!");
		
		System.out.println(thisStack.peek());
		System.out.println(thisStack);
		System.out.println(thisStack.size());
		System.out.println(thisStack.isEmpty());
		
		thisStack.pop();
		thisStack.pop();
		thisStack.pop();
		thisStack.pop();
		thisStack.pop();
		thisStack.pop();
		
		System.out.println(thisStack);
		System.out.println(thisStack.size());
		System.out.println(thisStack.isEmpty());
		
		
		
	}
	
	
	/**
	 * A static method that tests all the methods for the ArrayDeque class
	 */
	public static void dequeTesting() {
		
		Deque<Integer> myDeque = new ArrayDeque<Integer>(8); // creating an instance of ArrayDeque of integers
		                                                     // with array capacity of 8

		
		myDeque.addLast(0);
		myDeque.addFirst(66);
		myDeque.addFirst(16);
		System.out.println(myDeque);
		System.out.println(myDeque.first());
		System.out.println(myDeque.last());
		myDeque.removeFirst();
		System.out.println(myDeque.first());
		myDeque.addFirst(345);
		myDeque.addFirst(100);
		myDeque.addLast(30);
		System.out.println(myDeque);
		System.out.println(myDeque.first());
		System.out.println(myDeque.last());
		myDeque.removeLast();
		myDeque.addLast(15);
		myDeque.removeFirst();
		myDeque.addLast(18);
		myDeque.removeLast();
		myDeque.addFirst(44);
		myDeque.removeFirst();
		myDeque.addFirst(35);
		myDeque.removeFirst();
		myDeque.addFirst(10);
		myDeque.removeFirst();
		
		
		
		System.out.println(myDeque);
		System.out.println(myDeque.isEmpty());
		System.out.println(myDeque.size());
		
		System.out.println(myDeque.first());
		System.out.println(myDeque.last());
		
		Deque<String> thisDeque = new ArrayDeque<String>(); // creating and instance of ArrayDeque of Strings
		                                                    // with default capacity
		
		
		thisDeque.addLast("day");
		thisDeque.addFirst("this");
		thisDeque.addLast("will");
		thisDeque.addLast("be");
		thisDeque.addLast("remembered");
		thisDeque.addLast("forever");
		thisDeque.addLast("!");
		
		System.out.println(thisDeque);
		System.out.println(thisDeque.size());
		System.out.println(thisDeque.isEmpty());
		
		thisDeque.removeLast();
		thisDeque.removeFirst();
		thisDeque.removeFirst();
		thisDeque.removeLast();
		thisDeque.removeLast();
		thisDeque.removeLast();
		thisDeque.removeLast();
		
		
		System.out.println(thisDeque);
		System.out.println(thisDeque.size());
		System.out.println(thisDeque.isEmpty());
		
		
	    
	}
	
}
