package hw2;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RecommendedNutrient {
	private StringProperty nutrientCode = new SimpleStringProperty(); 
	private FloatProperty nutrientQuantity = new SimpleFloatProperty(); 
	
	public RecommendedNutrient(){
		nutrientCode.set(""); 
		nutrientQuantity.set(0); 
	}
	
	//Constructor
	public RecommendedNutrient(String nutrientCode, Float nutrientQuantity) {
		this.nutrientCode.set(nutrientCode);
		this.nutrientQuantity.set(nutrientQuantity);
	}
	

	
	//Setters
	public void setNutrientCode (String nutrientCode) {this.nutrientCode.set(nutrientCode);}
	public void setNutrientQuantity (Float nutrientQuantity) {this.nutrientQuantity.set( nutrientQuantity);}
	
	//Getters
	public String getNutrientCode() {return this.nutrientCode.get(); }
	public Float getNutrientQuantity() {return this.nutrientQuantity.get(); }
	

}
