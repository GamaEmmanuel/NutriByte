package hw2;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class Nutrient {
	private StringProperty nutrientCode = new SimpleStringProperty(); 
	private StringProperty nutrientName = new SimpleStringProperty(); 
	private StringProperty nutrientUom = new SimpleStringProperty(); 
	
	public Nutrient() {
		nutrientCode.set(""); 
		nutrientName.set(""); 
		nutrientUom.set(""); 
	}
	
	
	public Nutrient(String nutrientCode, String nutrientName, String nutrientUom) {
		this.nutrientCode.set(nutrientCode); 
		this.nutrientName.set(nutrientName);
		this.nutrientUom.set(nutrientUom);
	}
	
	//Setters
	public void setNutrientCode (String nutrientCode){this.nutrientCode.set(nutrientCode); }
	public void setNutrientName (String nutrientName) {this.nutrientName.set(nutrientName); }
	public void setNuttrientUon(String nutrientUom) {this.nutrientUom.set(nutrientUom); }
	
	//Getters
	public String getNutrientCode() {return nutrientCode.get();}
	public String getNutrientName() {return nutrientName.get(); }
	public String getNutrientUom() {return nutrientUom.get(); }




	public StringProperty nutrientCodeProperty() {return nutrientCode;}
	public StringProperty nutrientNameProperty() { return nutrientName;}
	public StringProperty nutrientUomProperty() {return nutrientUom;}
	
	
	


}
