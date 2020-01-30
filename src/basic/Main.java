/**
 * Tests different functions by calling them from the main method.
 *
 * @author Olga Shevchuk
 * @version January 29, 2020
 */



package basic;

public class Main {

    /** Calls the power, GCD, isPrime, round, and builtBefore1950 functions on several examples. */
	public static void main(String[] args) {
	
		System.out.println("3.5 to the power of 4 is " + power(3.5, 4));
		System.out.println("0 to the power of 10 is " + power(0, 10));
		System.out.println("-1 to the power of 14 is " + power(-1, 14));
		System.out.println("-2 to the power of 3 is " + power(-2, 3));
		System.out.println("10 to the power of 0 is " + power(10, 0));
		System.out.println("The greatest common denominator of 9 and 72 is " + GCD(9, 72));
		System.out.println("The greatest common denominator of 1 and 1 is " + GCD(1, 1));
		System.out.println("The greatest common denominator of 357 and 221 is " + GCD(357, 221));
		System.out.println("9 is a prime number: " + isPrime(9));
		System.out.println("0 is a prime number: " + isPrime(0));
		System.out.println("1 is a prime number: " + isPrime(1));
		System.out.println("2 is a prime number: " + isPrime(2));
		System.out.println("17 is a prime number: " + isPrime(17));
		System.out.println("4.6 rounded to the nearest integer is " + round(4.6));
		System.out.println("3.4 rounded to the nearest integer is " + round(3.4));
		System.out.println("0.5 rounded to the nearest integer is " + round(0.5));
		System.out.println("0.3 rounded to the nearest integer is " + round(0.3));
		builtBefore1950(FordDorms.LUNT_HALL);
		builtBefore1950(FordDorms.BARCLAY_HALL);
		builtBefore1950(FordDorms.LLOYD_HALL);
		
	}
	/**
	 * Returns the real number obtained as a result of raising 
     * a real number to a certain power
     * @param value:    a positive real number 
     * @param exponent: an integer to the power of which the real number is raised
     * @return the real number obtained as a result of raising
     * a real number to a certain power (double)
     */ 
     public static double power(double value, int exponent) {
	     double number = 1;
	     for (int i = 0; i<exponent; i++) {
		     number = number*value;  
	     }
	    return number;
     }
     /**
	 * Returns the greatest common denominator 
     * of two positive integers using the algorithm from Euclid.
     * @param num1: a first positive integer
     * @param num2: a second positive integer
     * @return the greatest common denominator of two positive integers
     * using the algorithm from Euclid (int)
     */
     public static int GCD(int num1, int num2) {
         while (num1!=num2) {

           if (num1>num2) {
              while(num2!=0) {
                  int mod = num1%num2;
                  num1=num2;
                  num2=mod;
              }
              return num1;
        
           } else {
        
              while(num1!=0) {
                  int mod = num2%num1;
                  num2=num1;
                  num1=mod;
              }
              return num2;
           }
          }
              return num1; 
     }
     /**
     * Returns a boolean value (true or false) 
     * depending on whether the certain integer is prime.
     * @param figure: a nonnegative integer that is being evaluated
     * @return a boolean value (true or false)
     * depending on whether a certain integer is prime (boolean)
     */
     public static boolean isPrime (int figure) {
         // a special case for 1 and 0 since they are
         // neither prime nor composite
	     if (figure == 1 || figure == 0) {
		   return false;
	 }
	       for (int i=2; i<figure; i++) {
		      if(figure % i == 0) {
			    return false;
		      }
	       }
	        return true;
     }
     /**
     * Returns a value obtained as a result of rounding 
     * a real number to the nearest integer
     * @param inval: a real number that is being rounded
     * @return a value obtained as a result of rounding 
     * a real number to the nearest integer (double)
     */
     public static int round (double inval) {
         int rounded = (int) (inval + 0.5);
         return rounded;
     }
         
        
	     
     /**
     * Creates an enum that represents a group of constants (dorm names)
     */
     public enum FordDorms
     {  // populate the enum
    	BARCLAY_HALL, 
		CADBURY_HOUSE, 
		COMFORT_HALL, 
		HENRY_S_DRINKER_HOUSE, 
		GUMMERE_HALL, 
		JONES_HALL, 
		KIM_AND_TRITTON_HALLS, 
		HAVERFORD_COLLEGE_APARTMENTS, 
		LA_CASA_HISPANICA,
		LEEDS_HALL, 
		LLOYD_HALL, 
		LUNT_HALL, 
		IRA_DE_A_REID_HOUSE, 
		YARNALL_HOUSE  
	  };
     
    /**
    * Takes a certain dorm (constant) from the enum as a parameter 
    * and prints out that dorm name followed by the year built
    * only if it was built before 1950, in other cases (if the dorm 
    * was not built before 1950) it prints out
    * a special message indicating that
    * @param dorm: a dorms of type FordDorms from the enum being evaluated 
    */
	public static void builtBefore1950(FordDorms dorm) {
	    // set up a switch to handle all cases
		switch (dorm) {
		case BARCLAY_HALL:
			System.out.println("Barclay Hall: 1877");
		break;
		case CADBURY_HOUSE:
			System.out.println("Cadbury House: 1886");
		break;
		case HENRY_S_DRINKER_HOUSE:
			System.out.println("Henry S. Drinker House: 1902");
		break;
		case HAVERFORD_COLLEGE_APARTMENTS:
			System.out.println("Haverford College Apartments: 1949");
		break;
		case LA_CASA_HISPANICA:
			System.out.println("La Casa Hispánica: 1911");
		break;
		case LLOYD_HALL:
			System.out.println("Lloyd Hall: 1920");
		break;
		case IRA_DE_A_REID_HOUSE:
			System.out.println("Ira de A. Reid House: 1900");
		break;
		case YARNALL_HOUSE:
			System.out.println("Yarnall House: 1900");
		break;
		default :
	    	System.out.println("The dorm wasn't built before 1950");
	
        }

    }

}
