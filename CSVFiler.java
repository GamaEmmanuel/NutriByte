package hw2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVFiler extends DataFiler{
		
		public void writeFile(String filename) {
			
		}
		
		//takes the csv filename, reads the first line that has gender, age, weight, height, 
		//physical activity level, and a series of comma separated ingredients to watch. 
		//Uses this data to create a Male or Female object and assigns it to NutriByte.person. 
		//Returns true if file read successfully. Returns false otherwise.
		
		public boolean readFile(String filename) {
			 
			CSVFormat csvFormat =  CSVFormat.DEFAULT; 
			
			try {
				CSVParser csvParser = CSVParser.parse(new FileReader(filename), csvFormat);
					
for(CSVRecord csvRecord: csvParser)
	{
	
	float age = Float.parseFloat(csvRecord.get(1).toString().trim());
	float weight = Float.parseFloat(csvRecord.get(2).toString().trim());
	float height = Float.parseFloat(csvRecord.get(3).toString().trim()); 
	float physicalActivity = Float.parseFloat(csvRecord.get(4).toString().trim());
	
	StringBuilder stringBuilder = null;
	String ingredients="";
	for (int  i = 5; i < csvRecord.size(); i++) {
		ingredients+=csvRecord.get(i).toString() + ", ";  
	}
	ingredients=ingredients.substring(0,ingredients.length()-1);
	
	if(csvRecord.get(0).equals("Male"))
		{
		NutriByte.person = new Male (age, weight, height, physicalActivity,ingredients );
		}
	
	if(csvRecord.get(0).equals("Female"))
		{
		NutriByte.person = new Female (age, weight, height, physicalActivity, ingredients);
		}
	}
		return true;
			}
				
			catch (FileNotFoundException e1) { return false ;} 
			catch (IOException e1) {return false;}	
			
		}	
		
	}

