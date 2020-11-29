package prelab;

public class Student {
	
	
	
	private String name;
	private int age;
	private ClassYear classYear;
	private FordDorms dorm;
	private boolean campusJob;
	private String dean;
	
	public enum ClassYear {FIRST_YEAR, SOPHOMORE, JUNIOR, SENIOR};
	
	public enum FordDorms
    {  
   	    BARCLAY, 
		TRITTON,
		GUMMERE, 
		JONES, 
		APARTMENTS,
		LEEDS,
		KIM,
		LLOYD,
		COMFORT,
		LUNT, 
		Q_HOUSE,
		DRINKER,
		BCC
		
	  };
	// constructor taking parameters that match the type of instance variables
	public Student (String name, int age, ClassYear classYear, FordDorms dorm, boolean campusJob, String dean) {
		this.name = name;
		this.age = age;
		this.classYear = classYear;
		this.dorm = dorm;
		this.campusJob = campusJob;
		this.dean = dean;
	}
	
	private String getName() {
		return this.name;
	}
     
	private int getAge() {
		return this.age;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	public void setAge(int newAge) {
		this.age = newAge;
	}
	public String toString() {
		return "Student's name is " + name + " and he/she is " + age + " years old. This student is a " + classYear + ".";
	}
	// Second constructor
	public Student (String name, String age, String inputClassYear, String inputDorm, String campusJob, String dean) {
		this.name = name;
		this.age = Integer.parseInt(age);
		this.classYear = classYearConverter(inputClassYear);
		this.dorm = dormConverter(inputDorm);
		this.campusJob = campusJobConverter(campusJob);
		this.dean = dean;	
	}
	/**
	 * 
	 * @param array
	 */
	public Student (String[] array) {
		this.name = array[0];
		this.age = Integer.parseInt(array[1]);
		this.classYear = classYearConverter(array[2]);
		this.dorm = dormConverter(array[3]);
		this.campusJob = campusJobConverter(array[4]);
		this.dean = array[5];	
		
	}
	public boolean campusJobConverter(String campusJob) {
		if (campusJob.equals("Yes")) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public ClassYear classYearConverter(String classYear) {
		
		switch(classYear) {
		case "First Year":
			return ClassYear.FIRST_YEAR;
		case "Sophomore":
			return ClassYear.SOPHOMORE;
		case "Junior":
			return ClassYear.JUNIOR;
	    default:
	    	return ClassYear.SENIOR;
		}
	}
	
	public FordDorms dormConverter(String dorm) {
		
		switch(dorm) {
		case "Tritton":
			return FordDorms.TRITTON;
		case "Gummere":
			return FordDorms.GUMMERE;
		case "Apartments":
			return FordDorms.APARTMENTS;
		case "Lunt":
			return FordDorms.LUNT;
		case "Leeds":
		    return FordDorms.LEEDS;
		case "QHouse":
			return FordDorms.Q_HOUSE;
		case "BCC":
			return FordDorms.BCC;
		case "Kim":
			return FordDorms.KIM;
		case "Drinker":
			return FordDorms.DRINKER;
		case "Comfort":
			return FordDorms.COMFORT;
		case "Jones":
			return FordDorms.JONES;
		case "Lloyd":
			return FordDorms.LLOYD;
		default:
			return FordDorms.BARCLAY;
			
		}
	}
	
	
	public static void main (String [] args) {
		
		Student firstStud = new Student("Will", 20, ClassYear.SOPHOMORE, FordDorms.BARCLAY, true, "Michael Elias");
		Student firstStudent = new Student("Will", "20", "Sophomore", "Barclay", "Yes", "Michael Elias");
		System.out.println(firstStud);
		System.out.println(firstStudent);
		
	}
	
	
}
