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
		System.out.println("The greatest common denominator of 0 and 72 is " + GCD(0, 72));
		System.out.println("The greatest common denominator of 1 and 1 is " + GCD(1, 1));
		System.out.println("The greatest common denominator of 357 and 221 is " + GCD(357, 221));
		System.out.println("9 is a prime number: " + isPrime(9));
		System.out.println("0 is a prime number: " + isPrime(0));
		System.out.println("1 is a prime number: " + isPrime(1));
		System.out.println("2 is a prime number: " + isPrime(2));
		System.out.println("17 is a prime number: " + isPrime(17));
		System.out.println("4.6 rounded to the nearest integer is  " + round(4.6));
		System.out.println("3.5 rounded to the nearest integer is " + round(3.4));
		System.out.println("0.5 rounded to the nearest integer is " + round(0.5));
		System.out.println("0.3 rounded to the nearest integer is " + round(0.3));
		builtBefore1950(FordDorms.LUNT_HALL);
		builtBefore1950(FordDorms.BARCLAY_HALL);
		builtBefore1950(FordDorms.LLOYD_HALL);
		
	}
	/**
	 * Returns the greatest common denominator 
     * of two positive integers using the algorithm from Euclid.
     * @param value:    a positive real number 
     * @param exponent: an integer to the power of which the real number is raised
     */ 
     
     
     public static double power(double value, int exponent) {
	     double number = 1;
	     for (int i = 0; i<exponent; i++) {
		     number = number*value;  
	     }
	    return number;
     }
     public static int GCD(int n, int m) {
         while (n!=m) {

         if (n>m) {
             while(m!=0) {
                  int k = n%m;
                  n=m;
                  m=k;
             }
        return n;
        
        } else {
        
         while(n!=0) {
              int k = m%n;
              m=n;
              n=k;
         }
        return m;
       }
    }
    return n;
 }
  

     public static boolean isPrime (int value) {
	     if (value == 1 || value == 0) {
		   return false;
	 }
	       for (int i=2; i<value; i++) {
		      if(value % i == 0) {
			    return false;
		      }
	       }
	        return true;
     }
     public static int round (double number1) {
	     int rounded = (int) (number1 + 0.5);
	     return rounded;
     }

     public enum FordDorms
     { 
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
     
     
	public static void builtBefore1950(FordDorms dorm) {
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
