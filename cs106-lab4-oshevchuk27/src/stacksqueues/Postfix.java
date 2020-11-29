
package stacksqueues;

import java.io.StringReader;

import java.util.Scanner;

/**
 *  Computes arithmetic expressions in post-fix notation.
 *  Takes in argument from the command line, 
 *  converts the string input into the scanner input,
 *  and then splits that input at various boundaries.
 *  Contains the post-fix method that loops to run
 *  through all the tokens of the input and performs 
 *  operations on the input if it matches certain patterns
 *
 *  @author Nick Howe, Sara Mathieson, Olga Shevchuk
 *  @version 25th March, 2020
 */
public class Postfix {

    /** Pattern that matches on words */
    public static final String WORD = "[a-zA-Z]*\\b";

    /** Pattern that matches on arithmetic operators */
    public static final String OPERATOR = "[^\\w]";

    /** Main method to evaluate expression */
    public static void main(String[] args) {

    	// tell the user how to run the program
    	if (args.length==0) {
    		System.err.println("Usage: java Postfix <expr>");

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
				double finalResult = postfix(input);
				System.out.println("result: " + finalResult);
			} 
			
			// catches the exception thrown in the post-fix method
			catch(IllegalArgumentException e) {
				e.printStackTrace(); // handles an exception
			}
    	}
    }
    
    /**
     * Returns a result of the arithmetic computation done on 
     * the expression in post-fix notation 
     * @param input: an input from the command line converted into Scanner
     * @return: the result of the arithmetic computation (double)
     * @exception IllegalArgumentException if the input is invalid
     */
    public static double postfix(Scanner input) throws IllegalArgumentException {

    	Stack <Object> myStack = new LinkedStack<Object>(); // creating an instance of a stack of objects
		
    	while (input.hasNext()) {
    		
			if (input.hasNextDouble()) {
				double number = input.nextDouble();
				myStack.push(number);
				
				
			} else if (input.hasNext(WORD)) {
			    String word = input.next(WORD);
			    
			    // handles functions and the Pi value
			    switch (word) {
			    
			    case "sin" :
			    	double value = (double) myStack.pop();
			    	myStack.push(Math.sin(value));
			    break;
			    
			    case "cos" :
			    	double newValue = (double) myStack.pop();
			    	myStack.push(Math.cos(newValue));
			    break;
			    
			    case "log" :
			    	double thisValue = (double) myStack.pop();
			    	myStack.push(Math.log(thisValue));
			    break;
			    
			    case "sqrt" :
			    	double myValue = (double) myStack.pop();
			    	myStack.push(Math.sqrt(myValue));
			    break;
			    
			    case "max" :
			    	double num1 = (double) myStack.pop();
			    	double num2 = (double) myStack.pop();
			    	myStack.push(Math.max(num2, num1));
			    break;
			    
			    case "min" :
			    	double newNum1 = (double) myStack.pop();
			    	double newNum2 = (double) myStack.pop();
			    	myStack.push(Math.min(newNum2, newNum1));
			    break;
			    
			    case "Pi" :
			    	myStack.push(Math.PI);
			    
			    break;
			    
			    default:
			    	throw new IllegalArgumentException(); // if the input is a word other than the functions above
			    	                                      // and the Pi value
			    }
			    	
			    	
			} else if (input.hasNext(OPERATOR)) {
				String operator = input.next(OPERATOR);
				
				double val1 = (double)myStack.pop();
				double val2 = (double)myStack.pop();
				
				// handles different kinds of operators
				switch (operator) {
				case "+" :
					myStack.push(val2 + val1);
				break;
				
				case "-" :
					myStack.push(val2 - val1);
				break;
				
				case "/" :
					myStack.push(val2/val1);
				break;
				
				case "*" :
					myStack.push(val2 * val1);
			    break;
				
				case "^": 
			    	myStack.push(Math.pow(val2, val1)); 
			    	break;
				default:
					throw new IllegalArgumentException(); // if the input is an operator
					                                      // other than the ones above
				}
				
			} else {
				throw new IllegalArgumentException(); // handles invalid input
			}
		}
		
			double val = (double) myStack.pop(); // the remaining value on the stack which is a result
			return val;
     }
}
