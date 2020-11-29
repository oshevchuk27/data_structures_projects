package prelab;


import java.util.ArrayList;

public class StudentData {
	ArrayList <Student> data = new ArrayList <Student> ();
    
	public StudentData(ArrayList<String[]> input) {
		for (String[] m : input) {
			data.add(new Student(m));
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for(Student m: data) {
			sb.append(m.toString() + "\n");
				
			}
			 return sb.toString();
		}
	}

