package hw2;

import java.util.Map;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

public class Product {
	private StringProperty ndbNumber = new SimpleStringProperty(); 
	private StringProperty productName = new SimpleStringProperty(); 
	private StringProperty manufacturer = new SimpleStringProperty(); 
	private StringProperty ingridients = new SimpleStringProperty(); 
	private FloatProperty servingSize = new SimpleFloatProperty();
	private StringProperty servingUom = new SimpleStringProperty(); 
	private FloatProperty householdSize = new SimpleFloatProperty();
	private StringProperty householdUom = new SimpleStringProperty(); 
	private ObservableMap <String, ProductNutrient> productNutrients = FXCollections.observableHashMap(); 
	
	
	public Product() {
		ndbNumber.set(""); 
		productName.set(""); 
		manufacturer.set(""); 
		ingridients.set(""); 
		servingSize.set(0); 
		servingUom.set(""); 
		householdSize.set(0); 
		householdUom.set("");
	}
	
	// Constructor
	public Product(String ndbNumber, String productName, String manufacturer, String ingridients) {
		this.ndbNumber.set(ndbNumber); 
		this.productName.set(productName);
		this.manufacturer.set(manufacturer);
		this.ingridients.set(ingridients); 
	}
	
	// Setters 
	public void setNdbNumner (String ndbNumber) { this.ndbNumber.set(ndbNumber); }
	public void setProductName (String productName) {this.productName.set(productName); }
	public void setManufacturer (String manufacturer) {this.manufacturer.set(manufacturer); }
	public void setIngridients (String ingridients) { this.ingridients.set(ingridients); }
	public void setServingSize (Float servingSize) {this.servingSize.set(servingSize);}
	public void setServingUom (String servingUom) {  this.servingUom.set(servingUom); }
	public void setHouseholdSize (Float householdSize) {  this.householdSize.set(householdSize);}
	public void setHouseholdUom (String householdUom) {  this.householdUom.set(householdUom);}
	
	
	//Getters 
	public String getNdbNumner () { return this.ndbNumber.get(); }
	public String getProductName () {return this.productName.get(); }
	public String getManufacturer () {return this.manufacturer.get(); }
	public String getIngridients () { return this.ingridients.get(); }
	public Float getServingSize () {return this.servingSize.get();}
	public String getServingUom () { return this.servingUom.get(); }
	public Float getHouseholdSize () { return this.householdSize.get();}
	public String getHouseholdUom () { return this.householdUom.get();}
	
	public class ProductNutrient {
		private StringProperty nutrientCode = new SimpleStringProperty(); 
		private FloatProperty nutrientQuantity = new SimpleFloatProperty(); 
		
		public ProductNutrient() {
			nutrientCode.set("");
			nutrientQuantity.set(0);
		}
		
		public ProductNutrient(String nutrientCode, Float nutrientQuantity) {
			this.nutrientCode.set(nutrientCode);
			this.nutrientQuantity.set(nutrientQuantity);
			
		}
		
		//Setters 
		public void setNutrientCode(String nutrientCode){this.nutrientCode.set(nutrientCode);}
		public void setNutrientQuantity (Float nuetrientQuantity) {this.nutrientQuantity.set(nuetrientQuantity); }
		
		//Getters
		public String getNutrientCode() {return nutrientCode.get();}
		public Float getNutrientQuantity() {return nutrientQuantity.get(); }
	
		
		//XProperty () return the property 

	}

	public ObservableMap<String, ProductNutrient> getProductNutrients() {
		
		return productNutrients;
	}

}
