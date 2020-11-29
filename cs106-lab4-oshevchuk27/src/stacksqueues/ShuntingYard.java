package stacksqueues;

import java.io.StringReader;

import java.util.Scanner;

/**
 *  Implements the full shunting yard algorithm given on the Wikipedia page.
 *  Implements five main operators and several functions, 
 *  does not implement composite functions, functions with variable number of arguments,
 *  and unary operators. Takes in argument from the command line, 
 *  converts the string input into the scanner input,
 *  and then splits that input at various boundaries. Contains the infixToPostfix method
 *  that loops to run through all the tokens of the input and performs 
 *  operations on the input if it matches certain patterns. Converts the input in the infix format into 
 *  post-fix format and then calls the post-fix method from the Postfix class to compute the final 
 *  result of the post-fix expression.
 *  
 *  @author Olga Shevchuk
 *  @version March 25th, 2020
 */
public class ShuntingYard {
	
	/** Pattern that matches on words */
	public static final String WORD = "[a-zA-Z]*\\b";
	
	/** Pattern that matches on arithmetic operators */
	public static final String OPERATOR = "[^\\w]";

	/** Main method to evaluate expression */
    public static void main(String[] args) {

    	// tell the user how to run the program
    	if (args.length==0) {
    		System.err.println("Usage: java ShuntingYard <expr>");

    	} else {
    		System.out.println("input: " + args[0]);
    		Scanner input = new Scanner(new StringReader(args[0]));

			// Below is a complicated regular expression that will split the
			// input string at various boundaries.
			input.useDelimiter("(\\s+"                  // whitespace
					+"|(?<=[a-zA-Z])(?=[^a-zA-Z])"      // word->non-word
					+"|(?<=[^a-zA-Z])(?=[a-zA-Z])"      // non-word->word
					+"|(?<=[^0-9\\056])(?=[0-9\\056])"  // non-number->number
					+"|(?<=[0-9\\056])(?=[^0-9\\056])"  // number->non-number
					+"|(?<=[^\\w])(?=[^\\w]))");        // symbol->symbol
            try {
            	
            	// converts the string received from the infixToPostfix method into Scanner
            	Scanner thisInput = new Scanner(infixToPostfix(input));
            	// calls the post-fix method from the Postfix class passing the resulting Scanner input as 
            	// a parameter
            	System.out.println("result: " + Postfix.postfix(thisInput));
           
             // catches an exception thrown in the infixToPostfix method
            } catch(IllegalArgumentException e) {
            	e.printStackTrace(); // handles an exception 
            }
    	}
    }
    
    /**
     * Converts the input expression in the infix notation 
     * into the expression in the post-fix notation
     * @param input: expression in the infix notation
     * @return expression in the post-fix notation (String)
     * @throws IllegalArgumentException if the input is invalid
     */
	public static String infixToPostfix (Scanner input) throws IllegalArgumentException {
		
		// creating instances of the stack and deque of objects
		Stack<Object> myStack = new LinkedStack<Object>();
		Deque<Object> myDeque = new ArrayDeque<Object>();
		
		while (input.hasNext()) {
			
			
			if (input.hasNextDouble()) {
				double number = input.nextDouble();
				myDeque.addLast(number);
				
			} else if (input.hasNext(WORD)) {
				String word = input.next(WORD);
				
				if (isFunction(word)) { // if the input word is a function
					myStack.push(word);
					
				} else if(word.equals("Pi")) {
					myDeque.addLast(word);
				} else {
					throw new IllegalArgumentException(); // if the input word is neither one of the functions
					                                      // nor word representing Pi value
					
				}
			
			} else if (input.hasNext(OPERATOR)) {
				String operator = input.next(OPERATOR);
				
				
			      if (isOperator(operator)) { // if the input is an operator (does not include parenthesis)
			    	  
			    	  while ((!myStack.isEmpty()) && (isFunction((String)myStack.peek()) || 
			    			  ((isOperator((String) myStack.peek())) &&
			    			  ((isLeftAssociative(operator)) && 
			    			  (getPriority(operator) <= getPriority((String)myStack.peek())) ||
			    			  (!isLeftAssociative(operator)) && 
			    			    (getPriority(operator) < getPriority((String)myStack.peek())))))) {
						  myDeque.addLast(myStack.pop());
			    	  }
					myStack.push(operator);
				 } else if (operator.equals("(")) {
					 myStack.push(operator);
				 } else if (operator.equals(")")) {
					 while (!myStack.isEmpty() && !myStack.peek().equals("(")) { // loop until the top of the stack
						                                                         // is a left parenthesis
							
							myDeque.addLast(myStack.pop());
						
						}
					 
					 if (myStack.isEmpty()) { // if the stack runs out without finding the left parenthesis
						 throw new IllegalArgumentException("Mismatched parenthesis");
					 }
					 myStack.pop(); // pops the left parenthesis from the stack
					 
				 } 
			       
			
		    } else { // if the input is invalid
			   throw new IllegalArgumentException();
		    }
	    }
			while(!myStack.isEmpty()) { // while there are no more tokens to read and there are still 
				                        // tokens in the stack
				
				if(myStack.peek().equals(")") 
					      || myStack.peek().equals("(")) {
					      throw new IllegalArgumentException("Mismatched parenthesis");
					    }
				
				myDeque.addLast(myStack.pop());
			}
		
		
		return  ((ArrayDeque<Object>) myDeque).stringVersion();
	}
	
	/**
	 * Evaluates whether the input String is a function
	 * @param inputFunction: input String
	 * @return true if the input String is one of the functions considered, 
	 * false otherwise (boolean)
	 */
	public static boolean isFunction(String inputFunction) {
		return inputFunction.equals("sin") || inputFunction.equals("max") ||
				inputFunction.equals("cos") || inputFunction.equals("min") ||
						inputFunction.equals("sqrt") || inputFunction.equals("log");
	}
	
	/**
	 * Evaluates whether the input String is an operator (excluding parenthesis)
	 * @param inputString: input String
	 * @return true if the input String represents one of the operators considered,
	 * false otherwise (boolean)
	 */
	public static boolean isOperator(String inputString) {
		return inputString.equals("+") || inputString.equals("-") || inputString.equals("*") ||
				inputString.equals("/") || inputString.equals("^");
	}
	
	
	/**
	 * Evaluates whether the input String represents an operator that is left associative		
	 * @param inputOperator: input String representing an operator
	 * @return true if the input String represents an operator that is left associative,
	 * false otherwise (boolean)
	 */
	public static boolean isLeftAssociative(String inputOperator) {
		return inputOperator.equals("+") || inputOperator.equals("-") || inputOperator.equals("*") ||
				inputOperator.equals("/");
	} 
	
	/**
	 * Evaluates the precedence of operators
	 * @param inputValue: input String representing an operator
	 * @return a number that represents the precedence(priority) associated
	 * with an operator represented by the input String (int)
	 */
	public static int getPriority(String inputValue) {
		if (inputValue.equals("+") || inputValue.equals("-")) {
			return 2;
		} else if (inputValue.equals("*") || inputValue.equals("/")){
			return 3;
		} else { // if inputValue is "^"
			return 4;
		}
	}
	

}
