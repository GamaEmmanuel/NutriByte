package hw2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import hw2.Product.ProductNutrient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

public class Model {

		//Product product = new Product(); 
		//NutriByte nutriByte = new NutriByte(); 
		
		 static ObservableMap <String, Product> productsMap = FXCollections.observableHashMap();
		 static ObservableMap <String, Nutrient> nutrientsMap = FXCollections.observableHashMap();
		

		void readProducts(String filename) {
			
			CSVFormat csvFormat =  CSVFormat.DEFAULT.withFirstRecordAsHeader(); 
			
			try {
				CSVParser csvParser = CSVParser.parse(new FileReader(filename), csvFormat);
				
				for (CSVRecord csvRecord : csvParser) {
					Product product = new Product (csvRecord.get(0), csvRecord.get(1),
							csvRecord.get(4), csvRecord.get(7));
					
					productsMap.put(csvRecord.get(0), product); 
				}
			}
			catch (FileNotFoundException e1) { e1.printStackTrace();} 
			catch (IOException e1) {e1.printStackTrace();}
			
		}
		
		
		void readNutrients(String filename) {
			
			CSVFormat csvFormat =  CSVFormat.DEFAULT.withFirstRecordAsHeader(); 
			
			try {
				CSVParser csvParser = CSVParser.parse(new FileReader(filename), csvFormat);
				
				for (CSVRecord csvRecord : csvParser) {
					Nutrient nutrient = new Nutrient (csvRecord.get(1), csvRecord.get(2),
							csvRecord.get(5));
					 
					nutrientsMap.put(csvRecord.get(1), nutrient); 
				
					
					if (Float.parseFloat(csvRecord.get(4))!=0) {
						Product product = productsMap.get(csvRecord.get(0));
						
						Product.ProductNutrient temporalProductNutrient = 
								product.new ProductNutrient(csvRecord.get(1), 
							Float.parseFloat(csvRecord.get(4).toString()));
					
					product.getProductNutrients().put(csvRecord.get(1), 
							temporalProductNutrient);
					}

				}
			}
			catch (FileNotFoundException e1) { e1.printStackTrace();} 
			catch (IOException e1) {e1.printStackTrace();}
		
		// Populate getProductsNutrients Map 
			
	}
		
		
		
		void readServingSizes(String filename) {
			CSVFormat csvFormat =  CSVFormat.DEFAULT.withFirstRecordAsHeader(); 
			
			try {
				CSVParser csvParser = CSVParser.parse(new FileReader(filename), csvFormat);
				
				for (CSVRecord csvRecord : csvParser) {
						//	temporalProductSize.setNdbNumner(csvRecord.get(0));
							if(csvRecord.get(1).isEmpty() ||csvRecord.get(2).isEmpty() ||
									csvRecord.get(3).isEmpty() || csvRecord.get(4).isEmpty()) {
								
							}
							else {
								 productsMap.get(csvRecord.get(0)).setServingSize(Float.parseFloat(csvRecord.get(1)));
									productsMap.get(csvRecord.get(0)).setServingUom((csvRecord.get(2)));	
									productsMap.get(csvRecord.get(0)).setHouseholdSize(Float.parseFloat(csvRecord.get(3)));
									productsMap.get(csvRecord.get(0)).setHouseholdUom(csvRecord.get(4));
							}

					}
			}
			catch (FileNotFoundException e1) { e1.printStackTrace();} 
			catch (IOException e1) {e1.printStackTrace();}
			
		}
		
		
		boolean readProfiles(String filename) {
			DataFiler dataFile = null;  
			if (!filename.isEmpty()) {
				if (filename.contains(".csv")) {
					try {
						dataFile = new CSVFiler();  
						return dataFile.readFile(filename);
					} catch (Exception e) {
						e.printStackTrace();
						return false; 
					}
					
				}
				else {
					try {
						dataFile = new XMLFiler();  
						return dataFile.readFile(filename);
					} catch (Exception e) {
						e.printStackTrace();
						return false; 
					}
					
				}
			}
			else return false; 
			
		}
		
	}	
		

