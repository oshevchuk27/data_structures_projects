/**
 * Holds the information about the defendant, 

 * including sex, race, the degree of the criminal charge, criminal charge degree 
 * description, the decile score that evaluates the risk of the defendant , 
 * the text score that evaluates the risk of the defendant, two year recidivism occurrence,
 * recidivism charge description, the degree of the recidivism charge. Includes constructors,
 * getters and setters for the instance variables.
 * Evaluates the false positivity (whether the defendant was labeled high risk but did not re-offend) 
 * and the false negativity (whether the defendant was labeled low yet did re-offend) 
 * for both African-American and Caucasian defendants.
 * 
 * @author Olga Shevchuk
 * @version 6th February, 2020
 */




package propublica.datadesign;

import prelab.Student.ClassYear;

public class Defendant {
	
	/**
	 * instance variables for the Defendant class
	 */
	private Sex sex; // one of the values of the enum Sex
	private Race race; // one of the values of the enum Race
	private CriminalChargeDegree criminalChargeDegree; // one of the values of the enum CriminalChargeDegree
	private String criminalChargeDescription; // example of a variable that we don't pass to the constructor
	
	                         // the score that evaluates the risk of the defendant 
	                         // (if it is in the range from 1 to 4,
	private int decileScore; // then the text score is low, if it is in the range from 5 to 7,
	                         // the text score is medium, if it is in the range from 8 to 10, 
	                         // the text score is high)
	private ScoreText scoreText; // one of the values of the enum ScoreText
	private boolean twoYearRecidivism; // evaluates if the defendant re-offended 
	                                    // within two years of the first crime committed
	private String recidivismChargeDescription; // example of a variable that we don't pass to the constructor
	private RecidivismChargeDegree recidivismChargeDegree; // one of the values of the enum RecidivismChargeDegree
	/** store the possible sex options of the defendant in an enum */
	public enum Sex {FEMALE, MALE};
	/** store the possible race options of the defendant in an enum */
	public enum Race {AFRICAN_AMERICAN, ASIAN, CAUCASIAN, HISPANIC, NATIVE_AMERICAN, OTHER};
	/** store the possible degrees of criminal charge of the defendant in an enum*/
	public enum CriminalChargeDegree {FELONY, MISDEMEANOR};
	/** store the possible degrees of the risk of the defendant in an enum*/
	public enum ScoreText {LOW, HIGH, MEDIUM};
	/** store the possible degrees of the recidivism charge of the defendant in an enum */
	public enum RecidivismChargeDegree {M1, M2, MO3, F1, F2, F3, F5, F6, F7, CO3, EMPTY};
	
	/**
	 * Constructor for the defendant class
	 * @param sex: the sex of the defendant (Sex)
	 * @param race: the race of the defendant (Race)
	 * @param criminalChargeDegree: the degree of the criminal charge of defendant (CriminalChargeDegree)
	 * @param decileScore: the score that evaluates the risk of the defendant (int)
	 * @param scoreText: the textual score that evaluates the risk of the defendant (ScoreText)
	 * @param twoYearRecidivism: evaluation of whether the defendant re-offended within 
	 * two years of the first crime committed (boolean)
	 */
	public Defendant(Sex sex, Race race, CriminalChargeDegree criminalChargeDegree, int decileScore, 
			ScoreText scoreText, boolean twoYearRecidivism) {
		this.sex = sex;
		this.race = race;
		this.criminalChargeDegree = criminalChargeDegree;
		// the default value for criminal charge description
		this.criminalChargeDescription = "";
		this.decileScore = decileScore;
		this.scoreText = scoreText;
		this.twoYearRecidivism = twoYearRecidivism;
		// the default value for the recidivism charge description
		this.recidivismChargeDescription = "";
		// the default value for the recidivism charge degree
		this.recidivismChargeDegree = RecidivismChargeDegree.EMPTY;
	}
	/**
	 * A method that overrides a built-in toString method for the defendant object and returns 
	 * the valid output that describes an object
	 * @return the valid output that describes an object (String)
	 */
	public String toString() {
		return "The defendant is " + sex +  " and is " + race + ". His/ Her criminal charge degree is "
	            + criminalChargeDegree + " due to : " + criminalChargeDescription +
	             " and decile score is " + decileScore + ", so it is " + scoreText +
				". He/She reoffended within two years of the first crime: "+ twoYearRecidivism +
				". His/her recidivism charge degree is " + recidivismChargeDegree +
				" due to " + recidivismChargeDescription;
		}
	/**
	 * Getter for the Defendant's sex
	 * @return the sex (Sex)
	 */
	public Sex getSex() {
		return this.sex;
	}
	/**
	 * Getter for the Defendant's race
	 * @return the race (Race)
	 */
	public Race getRace() {
		return this.race;
	}
	/**
	 * Getter for the Defendant's criminal charge degree
	 * @return the criminal charge degree (CriminalChargeDegree)
	 */
	public CriminalChargeDegree getChargeDegree() {
		return this.criminalChargeDegree;
	}
	/**
	 * Getter for the Defendant's risk decile score
	 * @return the risk decile score (int)
	 */
	public int getDecileScore() {
		return this.decileScore;
	}
	/**
	 * Getter for the Defendant's text score
	 * @return the text score (ScoreText)
	 */
	public ScoreText getScoreText() {
		return this.scoreText;
	}
	/**
	 * Getter for the evaluation of the Defendant's two year recidivism occurence
	 * @return the two year recidivism occurence (boolean)
	 */
	public boolean getTwoYearRecidivism() {
		return this.twoYearRecidivism;
	}
	/**
	 * Getter for the degree of Defendant's recidivism charge
	 * @return the degree of recidivism charge (RecidivismChargeDegree)
	 */
	public RecidivismChargeDegree getRecidivismChargeDegree () {
		return this.recidivismChargeDegree;
	}
	/**
	 * Getter for the description of the recidivism charge of the Defendant
	 * @return the description of the recidivism charge of the Defendant (String)
	 */
	public String getRecidivismChargeDescription() {
		return this.recidivismChargeDescription;
		
	}
	/**
	 * Evaluates whether the Defendant is a white defendant who was labeled high risk and did not re-offend
	 * @return the evaluation of whether the Defendant is a white defendant who was labeled high risk 
	 * and did not re-offend (boolean)
	 */
	public boolean isWhiteAndHighNotRecid() {
		 return (race == Race.CAUCASIAN && (scoreText == ScoreText.HIGH ||
				 scoreText == ScoreText.MEDIUM) && !(twoYearRecidivism));	 
			
	}
	/**
	 * Evaluates whether the Defendant is a black defendant who was labeled high risk and did not re-offend
	 * @return the evaluation of whether the Defendant is a black defendant who was labeled high risk 
	 * and did not re-offend (boolean)
	 */
	public boolean isBlackAndHighNotRecid() {
		return (race == Race.AFRICAN_AMERICAN && (scoreText == ScoreText.HIGH ||
				scoreText == ScoreText.MEDIUM) && !(twoYearRecidivism));
		
	}
	/**
	 * Evaluates whether the Defendant is a white defendant who was labeled low yet did re-offend
	 * @return the evaluation of whether the Defendant is a white defendant who was labeled low 
	 * yet did re-offend (boolean)
	 */
	public boolean isWhiteAndLowAndRecid() {
		return (race == Race.CAUCASIAN && scoreText == ScoreText.LOW && (twoYearRecidivism));
		
	}
	/**
	 * Evaluates whether the Defendant is a black defendant who was labeled low yet did re-offend
	 * @return the evaluation of whether the Defendant is a black defendant who was labeled low 
	 * yet did re-offend (boolean)
	 */
	public boolean isBlackAndLowAndRecid() {
	    return (race == Race.AFRICAN_AMERICAN && scoreText == ScoreText.LOW && twoYearRecidivism);
	}
     /**
      * Evaluates whether the Defendant is a white defendant who did not re-offend
      * @return the evaluation of whether the Defendant is a white defendant who did not re-offend (boolean) 
      */
     public boolean isWhiteAndNotRecid() {
    	 return (race == Race.CAUCASIAN && !(twoYearRecidivism));
    	 
     }
     /**
      * Evaluates whether the Defendant is a black defendant who did not re-offend
      * @return the evaluation of whether the Defendant is a black defendant who did not re-offend (boolean)
      */
     public boolean isBlackAndNotRecid() {
    	 return (race == Race.AFRICAN_AMERICAN && !(twoYearRecidivism));
    	 
     }
     /**
      * Evaluates whether the Defendant is a white defendant who re-offended
      * @return the evaluation of whether the Defendant is a white defendant who re-offended (boolean)
      */
     public boolean isWhiteAndRecid() {
    	 return (race == Race.CAUCASIAN && twoYearRecidivism); 
     }	
     /**
      * Evaluates whether the Defendant is a black defendant who re-offended (boolean)
      * @return the evaluation of whether the Defendant is a black defendant who re-offended (boolean)
      */
     public boolean isBlackAndRecid() {
    	 return (race == Race.AFRICAN_AMERICAN && twoYearRecidivism);
     }
     
     
     /**
      * Converts the String representing the sex of the Defendant into one of the values of the enum Sex
      * @param sex: the String representing the sex of the Defendant 
      * @throws IllegalArgumentException if the sex is other than "Female" or "Male"
      * @return one of the values of an enum Sex depending on the specific String parameter (Sex)
      */
     public Sex sexConverter (String sex) throws IllegalArgumentException {
    	 
      	 switch (sex) {
		 case "Female":
			 return Sex.FEMALE;
		 case "Male":
			 return Sex.MALE;
		 // throws an exception if the input String is invalid
		default:
 	    	 throw new IllegalArgumentException ("The sex is invalid");
    	 }	 
     }
	 /** 
	  * Converts the String representing the race of the Defendant into one of the values of the enum Race
      * @param race: the String representing the race of the Defendant
      * @throws IllegalArgumentException if the race is other than the ones listed in the csv file
      * (is neither "African-American", "Asian", "Caucasian", "Hispanic", "Native American" nor "Other")
      * @return one of the values of the enum Race depending on the specific String parameter (Race)
      */
      public Race raceConverter(String race) throws IllegalArgumentException {
    	  switch (race) {
    	  case "African-American":
    		  return Race.AFRICAN_AMERICAN;
    	  case "Asian":
    		  return Race.ASIAN;
    	  case "Caucasian":
    	      return Race.CAUCASIAN;
    	  case "Hispanic":
    		  return Race.HISPANIC;
    	  case "Native American":
    		  return Race.NATIVE_AMERICAN;
    	  case "Other":
    		  return Race.OTHER; 
          // throws an exception if the input String is invalid
    	  default:
    		  throw new IllegalArgumentException ("The race is invalid");
    		  
    	  }
      }
      /**
       * Converts the String representing the degree of the criminal charge of the Defendant into one 
       * of the values of the enum CriminalChargeDegree
       * @param cChargeDegree: the String representing the degree of the criminal charge of the Defendant 
       * @throws IllegalArgumentException if the criminal charge degree is neither "F" (felony) nor  "M" (misdemeanor)
       * @return one of the values of the enum CriminalChargeDegree depending on the specific String parameter (CriminalChargeDegree)
       */
       public CriminalChargeDegree criminalChargeDegreeConverter (String cChargeDegree) 
    		   throws IllegalArgumentException {
    	   switch (cChargeDegree) {
    	   case "F":
    	       return CriminalChargeDegree.FELONY;
    	   case "M":
    		   return CriminalChargeDegree.MISDEMEANOR;
    	   // throws an exception if the input String is invalid
    	   default:
    		   throw new IllegalArgumentException ("The criminal charge degree is invalid");
    	   }
    	   
       }
       /**
        * Converts the String representing the text score of the Defendant's risk
        * into one of the values of the enum ScoreText
        * @param scoreText: the String representing the text score of the Defendant's risk
        * @throws IllegalArgumentException if the text score is other than the Strings "Low", "Medium" and "High"
        * @return one of the values of the enum ScoreText depending on the specific String parameter (ScoreText)
        */
       public ScoreText scoreTextConverter (String scoreText) throws IllegalArgumentException {
    	   switch (scoreText) {
    	   case "Low":
    		   return ScoreText.LOW;
    	   case "Medium":
    		   return ScoreText.MEDIUM;
    	   case "High":
    		   return ScoreText.HIGH;
    	   // throws an exception if the input String is invalid
    	   default:
    		   throw new IllegalArgumentException ("The text score is invalid");
    	   }
       }
       /**
        * Converts the String representing the degree of the recidivism charge of the Defendant
        * into one of the values of the enum RecidivismChargeDegree
        * @param rChargeDegree: the String representing the degree of the recidivism charge of the Defendant
        * @throws IllegalArgumentException if the degree of the recidivism charge is neither of the values 
        * listed in the csv file (is neither "(CO3)", "F1", "F2", "F3", "F5", "F6", "F7", "M1", "M2", "MO3", nor "")
        * @return one of the values of the enum RecidivismChargeDegree depending 
        * on the specific String parameter (RecidivismChargeDegree)
        */
       public RecidivismChargeDegree recidivismChargeDegreeConverter (String rChargeDegree)
    		   throws IllegalArgumentException {
    	   switch (rChargeDegree) {
    	   case "(CO3)":
    		   return RecidivismChargeDegree.CO3;
    	   case "(F1)":
    		   return RecidivismChargeDegree.F1;
    	   case "(F2)":
    		   return RecidivismChargeDegree.F2;
    	   case "(F3)":
    		   return RecidivismChargeDegree.F3;
    	   case "(F5)":
    		   return RecidivismChargeDegree.F5;
    	   case "(F6)":
    		   return RecidivismChargeDegree.F6;
    	   case "(F7)":
    		   return RecidivismChargeDegree.F7;
    	   case "(M1)":
    		   return RecidivismChargeDegree.M1;
    	   case "(M2)":
    		   return RecidivismChargeDegree.M2;
    	   case "(MO3)":
    		   return RecidivismChargeDegree.MO3;
    	   case "":
    		   return RecidivismChargeDegree.EMPTY;
    	   default:
    		   throw new IllegalArgumentException ("The degree of the recidivism charge is invalid");
           }
       }
       
       /**
        * Second constructor for the Defendant class. Sets the values of the instance variables 
        * to the parsed Strings taken as an input.
        * @param array: represents the values from one row of the file
        * (such as sex, race, the degree of the criminal charge, criminal charge degree 
        * description, the decile score , the text score, two year recidivism occurrence,
        * recidivism charge description, the degree of the recidivism charge.(String[])
        * @throws IllegalArgumentException if String decile score converted to an int is 
        * not in determined range (from 1 to 10)
        * @throws IllegalArgumentException if two year recidivism occurence is neither 0 nor 1
        */
       public Defendant (String [] array) throws IllegalArgumentException {
    	    
    	 this.sex = sexConverter(array[0]);
    	 this.race = raceConverter(array[1]);
    	 this.criminalChargeDegree = criminalChargeDegreeConverter(array[2]);
    	 this.criminalChargeDescription = array[3];
    	 if ((Integer.parseInt(array[4]) >= 1) && (Integer.parseInt(array[4]) <= 10)) {
    		 this.decileScore = Integer.parseInt(array[4]);
    	 } else {
    		 throw new IllegalArgumentException ("The decile score is invalid");
    	 }
    	 this.scoreText = scoreTextConverter(array[5]);
    	 if (array[6].equals("1")) {
    	      this.twoYearRecidivism = true;
    	 } else if (array[6].equals("0")) {
    		 this.twoYearRecidivism = false;	 
    	 } else {
    		 throw new IllegalArgumentException ("The two year recidivism occurence cannot be identified");
    	 }
    	 this.recidivismChargeDescription = array[7];
    	 
    	 this.recidivismChargeDegree = recidivismChargeDegreeConverter(array[8]);
     }
       
    
       
       /**
   	 * Evaluates whether the Defendant is a white defendant who was labeled high risk and did not re-offend
   	 * or the white defendant that re-offended and had a minor recidivism charge description
   	 * @return the evaluation of whether the Defendant is a white defendant who was labeled high risk 
   	 * and did not re-offend or the white defendant that who re-offended and had a minor recidivism charge description (boolean)
   	 */  
    /*public boolean isWhiteAndHighNotRecidOptional() {
  		 return (race == Race.CAUCASIAN && (scoreText == ScoreText.HIGH ||
  				 scoreText == ScoreText.MEDIUM) && (!twoYearRecidivism || recidivismChargeDescription()));	 
  			
  	}
    /**
	 * Evaluates whether the Defendant is a black defendant who was labeled high risk and did not re-offend
	 * or the black defendant that re-offended and had a minor recidivism charge description
	 * @return the evaluation of whether the Defendant is a black defendant who was labeled high risk 
	 * and did not re-offend or the black defendant that re-offended and had a minor recidivism charge description (boolean)
	 */  
   /* public boolean isBlackAndHighNotRecidOptional() {
		return (race == Race.AFRICAN_AMERICAN && (scoreText == ScoreText.HIGH ||
				scoreText == ScoreText.MEDIUM) && (!twoYearRecidivism || recidivismChargeDescription()));
		
	}
    
    /**
	 * Evaluates whether the Defendant is a white defendant who was labeled low yet did re-offend
	 * and did not have one of the minor recidivism charge descriptions
	 * @return the evaluation of whether the Defendant is a white defendant who was labeled low 
	 * yet did re-offend and did not have one of the minor recidivism charge descriptions (boolean)
	 */
   	/*public boolean isWhiteAndLowAndRecidOptional() {
		return (race == Race.CAUCASIAN && scoreText == ScoreText.LOW && (twoYearRecidivism && !recidivismChargeDescription()));	
	}
   	/**
	 * Evaluates whether the Defendant is a black defendant who was labeled low yet did re-offend
	 * and did not have one of the minor recidivism charge descriptions
	 * @return the evaluation of whether the Defendant is a black defendant who was labeled low 
	 * yet did re-offend and did not have one of the minor recidivism charge descriptions (boolean)
	 */
   /*	public boolean isBlackAndLowAndRecidOptional() {
	    return (race == Race.AFRICAN_AMERICAN && scoreText == ScoreText.LOW && (twoYearRecidivism && !recidivismChargeDescription()));
	}
   	
   	/**
     * Evaluates whether the Defendant is a white defendant who did not re-offend
     * or the white defendant who re-offended and had a minor recidivism charge description
     * @return the evaluation of whether the Defendant is a white defendant who did not re-offend 
     * or the white defendant who re-offended and had a minor recidivism charge description (boolean) 
     */
    /*public boolean isWhiteAndNotRecidOptional() {
   	 return (race == Race.CAUCASIAN && (!twoYearRecidivism || recidivismChargeDescription()));
   	 
    }
    
    /**
     * Evaluates whether the Defendant is a black defendant who did not re-offend or the black 
     * defendant who re-offended and had a minor recidivism charge description
     * @return the evaluation of whether the Defendant is a black defendant who did not re-offend (boolean)
     */
   /* public boolean isBlackAndNotRecidOptional() {
   	 return (race == Race.AFRICAN_AMERICAN && (!twoYearRecidivism || recidivismChargeDescription()));
   	 
    }
   
    /**
     * Evaluates whether the Defendant is a white defendant who re-offended and did not have one of the
     * minor recidivism charge descriptions
     * @return the evaluation of whether the Defendant is a white defendant who re-offended 
     * and did not have one of the minor recidivism charge descriptions (boolean)
     */
   /* public boolean isWhiteAndRecidOptional() {
   	 return (race == Race.CAUCASIAN && twoYearRecidivism) && (twoYearRecidivism && !recidivismChargeDescription()) ; 
    }	
    
    /**
     * Evaluates whether the Defendant is a black defendant who re-offended and did not have one of the
     * minor recidivism charge decsriptions 
     * @return the evaluation of whether the Defendant is a black defendant who re-offended 
     * and did not have one of the minor recidivism charge descriptions (boolean)
     */
   /* public boolean isBlackAndRecidOptional() {
   	 return (race == Race.AFRICAN_AMERICAN && twoYearRecidivism) && (twoYearRecidivism && !recidivismChargeDescription());
    }
   	
    /**
     * Evaluates the recidivism charge descriptions which 
     * are not sufficient for the defendant to count as the one who re-offended
     * @param e: represents a Defendant object that is associated with one row of the file
     * @return the evaluation of the defendant's recidivism charge descriptions (boolean)
     */
	  /*  public boolean recidivismChargeDescription() {
			return (getRecidivismChargeDescription().equals("Drinking Alch Beverage In Open") ||
					getRecidivismChargeDescription().equals("Disorderly Conduct") ||
					getRecidivismChargeDescription().equals("Disobey Officer/Fireman") ||
					getRecidivismChargeDescription().equals("Open Container Of Alcoholic Bev") ||
					getRecidivismChargeDescription().equals("Sleeping On Beach") ||
					getRecidivismChargeDescription().equals("Driving While License Revoked") || 
					getRecidivismChargeDescription().equals("Loitering/Prowling")); 
		} */
	    
 }
