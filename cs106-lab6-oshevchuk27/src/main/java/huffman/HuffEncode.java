package huffman;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Stores the arrays of codes and symbols.
 * Reads in data from a txt file
 * given as command line argument
 * and breaks the input into tokens. Encodes the given input by
 * matching a token with a character from the array of symbols 
 * and finding a code that corresponds to it from the array of codes. 
 * Then decodes the code by calling the decode method from HuffDecode class on 
 * the character tree.
 * 
 * 
 * 
 * 
 * 
 * @author Olga Shevchuk
 * @version 13th April, 2020
 *
 */

public class HuffEncode {
	
	
	public static final String[] CODES = {"0000", "110", "0010", "0011", "0100", "0110", "0111", "1001", "1010", "10000", "10111", "11111", "010100", "010101", "010110", "100010", "100011", "101101", "111000", "111001", "111011", "111100", "1011000", "1110100", "1110101", "11110110", "11110111", "010111101", "010111111", "101100100", "101100101", "111101000", "111101010", "0101110001", "0101110010", "0101110011", "0101110111", "0101111000", "0101111001", "0101111100", "0101111101", "1011001101", "1011001110", "1011001111", "1111010010", "1111010111", "01011100000", "01011100001", "01011101000", "01011101001", "01011101011", "10110011000", "11110100110", "11110100111", "11110101100", "11110101101", "010111010101", "010111011000", "010111011001", "010111011010", "101100110011", "0101110101000", "0101110101001", "0101110110111", "01011101101100", "01011101101101", "10110011001000", "10110011001011", "101100110010011", "1011001100100100", "1011001100100101", "1011001100101000", "1011001100101001", "10110011001010100", "10110011001010101", "10110011001010110", "101100110010101111", "10110011001010111011", "101100110010101110000", "101100110010101110001", "101100110010101110010", "101100110010101110011", "101100110010101110100", "101100110010101110101", "000100", "000101", "0001100", "0001101", "00011100", "00011101", "0001111"};

    public static final char[] SYMBOLS = {'e', ' ', 's', 'h', 'i', 'n', 'o', 'a', 't', 'l', 'd', 'r', 'p', ',', 'y', 'g', 'f', 'w', 'm', 'c', '\n', 'u', 'v', '.', 'b', '\"', 'k', '-', 'P', 'A', 'T', '\'', 'I', 'j', 'z', 'q', 'W', 'S', 'R', '?', 'M', 'B', 'N', 'x', '!', 'H', 'V', ';', 'K', 'Y', 'G', 'O', 'F', 'D', 'C', 'E', '(', ')', 'X', 'L', ':', '*', 'J', '1', '2', '0', '8', 'U', 'Z', '7', '5', '6', '3', '/', '9', 'Q', '4', '[', '#', ']', '%', '=', '@', '$', '_', '~', '<', '\\', '>', '+', '`'};

	
	/**
	 * Reads in data from a txt file given as command
	 * line input and breaks the input into tokens. 
	 * Matches the input token with a code
	 * from the code array and encodes the message 
	 * 
	 * 
	 * @param args: array of Strings representing command line arguments
	 */

	public static void main(String [] args) {
		
		// if there is no input
		if (args.length == 0) {
			System.err.println("Usage: java HuffEncode <expr>");
		} else {
			
			try {
				File f = new File(args[0]);
				FileReader fr = new FileReader(f); // opens the reader
				BufferedReader br = new BufferedReader(fr);

				StringBuilder sb = new StringBuilder("");
				int r;
				while ((r = br.read())!= -1) { // reads character by character
					char character = (char) r;
					int charIndex = new String(SYMBOLS).indexOf(character); // converting the array of characters
																			// into String and getting the index of a specific character 
					                                                        // in the String
					sb.append(CODES[charIndex]); // corresponding codes from the code array
				}
					
				System.out.println("Encoded message: " + sb.toString()); // the resulting code
				
				HuffTree thisTree = new HuffTree(); // creating a tree of characters
				for (int i = 0; i<SYMBOLS.length; i++) {
					
					
			
					thisTree.addNode(SYMBOLS[i], CODES[i]);
				}
				
				System.out.println("Decoded message: " + HuffDecode.decode(thisTree, sb.toString()));
			} catch (FileNotFoundException e1) { // when file cannot be found
				
				e1.printStackTrace(); // handles an exception
				
			} catch (IOException e1) { // when file contains an error or cannot be read
	    		e1.printStackTrace(); // handles an exception
	    	}
			
			
	    	
			
		}
			
	}
}

