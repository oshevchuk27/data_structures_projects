package prelab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReaderHeaderAware;

public class Main {
	public static void main(String [] args) throws IOException {
		
		
		try {
			CSVReaderHeaderAware dataReadIn = new CSVReaderHeaderAware(new FileReader("StudentProfile.csv"));
			ArrayList<String[]>	myEntries	= new	ArrayList<String[]> (dataReadIn.readAll());
			StudentData info = new StudentData(myEntries);
			dataReadIn.close();
			System.out.println(info);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
	}
	
}

