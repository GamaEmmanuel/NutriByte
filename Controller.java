package hw2;

import java.io.File;
import java.util.Collection;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.transform.Source;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Controller {


	//3. RecommendNutrientButtonHandler: Takes all the data from the GUI controls 
	//(genderComboBox, ageTextField, etc.) to create a profile, and then populate 
	//the recommendedNutrientsTableView.
	class RecommendNutrientsButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {

			if (NutriByte.view.genderComboBox.getValue()==null) {
				
			}
			else {
				if (NutriByte.view.genderComboBox.getValue().contains("Male")) {

					float age = 0; 
					float weight = 0; 
					float height = 0;
					float phlevel = 1;
					
					if (!NutriByte.view.ageTextField.getText().isEmpty()) {
						age = Float.parseFloat(NutriByte.view.ageTextField.getText()); ; 
					}
					if (!NutriByte.view.weightTextField.getText().isEmpty()) {
						weight =  Float.parseFloat(NutriByte.view.weightTextField.getText()); 
					}
					if (!NutriByte.view.heightTextField.getText().isEmpty()) {
						height = Float.parseFloat(NutriByte.view.heightTextField.getText()); 
					}
					if (NutriByte.view.physicalActivityComboBox.getValue() != null) {
						for (NutriProfiler.PhysicalActivityEnum c : NutriProfiler.PhysicalActivityEnum.values()) 
						{
							
							if ((c.getName()).equalsIgnoreCase(NutriByte.view.physicalActivityComboBox.getValue())) 
							{
									phlevel = c.getPhysicalActivityLevel(); 
								
								break; 
								}
						} 
					}
					String ingridientsWatch = NutriByte.view.ingredientsToWatchTextArea.getText(); 

					NutriByte.person = new Male (age, weight, height, phlevel, ingridientsWatch); 

				}

				if (NutriByte.view.genderComboBox.getValue().contains("Female")) {

					float age = 0; 
					float weight = 0; 
					float height = 0;
					float phlevel = 1;
					
					if (!NutriByte.view.ageTextField.getText().isEmpty()) {
						age = Float.parseFloat(NutriByte.view.ageTextField.getText()); ; 
					}
					if (!NutriByte.view.weightTextField.getText().isEmpty()) {
						weight =  Float.parseFloat(NutriByte.view.weightTextField.getText()); 
					}
					if (!NutriByte.view.heightTextField.getText().isEmpty()) {
						height = Float.parseFloat(NutriByte.view.heightTextField.getText()); 
					}
					if (NutriByte.view.physicalActivityComboBox.getValue() != null) {
						for (NutriProfiler.PhysicalActivityEnum c : NutriProfiler.PhysicalActivityEnum.values()) 
						{
							
							if ((c.getName()).equalsIgnoreCase(NutriByte.view.physicalActivityComboBox.getValue())) 
							{
									phlevel = c.getPhysicalActivityLevel(); 
								
								break; 
								}
						} 
					}
	
					String ingridientsWatch = NutriByte.view.ingredientsToWatchTextArea.getText(); 

					NutriByte.person = new Female (age, weight, height, phlevel, ingridientsWatch);
						
				}
				
				NutriProfiler.createNutriProfile(NutriByte.person); //populate recommended nutrients lists
				NutriByte.view.recommendedNutrientsTableView.setItems(NutriProfiler.recommendedNutrientsList);
			}

	}
}


	//2. OpenMenuItemHandler: Opens the FileChooser for the user to choose 
	//a profile data file that can be .csv or .xml. Passes the selected file’s file 
	//name to the Model’s readProfile() method. Displays the profile data in the GUI. 
	//Finally, invokes NutriProfiler’s createNutriProfile() method to populate the 
	//recommendedNutrientsList.

	class OpenMenuItemHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {

			NutriProfiler.recommendedNutrientsList.clear(); 

			FileChooser fileChooser = new FileChooser(); 
			fileChooser.setTitle("Select File");
			fileChooser.setInitialDirectory(new File("/Users/emmanuel/Documents/JAVA/HW/data"));
			fileChooser.getExtensionFilters().addAll(
					new ExtensionFilter ("CSV Files","*.csv"),
					new ExtensionFilter ("XML Files","*.xml"));
			 
			 Stage stage = new Stage(); 
			File filename = fileChooser.showOpenDialog(stage);   

			if ( filename != null) 
			{
				if (NutriByte.model.readProfiles(filename.getAbsolutePath()))
				{
					
				 if(NutriByte.person instanceof Male) {
						NutriByte.view.genderComboBox.setId("Male");
					}
				else if (NutriByte.person instanceof Female) {
						NutriByte.view.genderComboBox.setId("Female");
					}
				NutriByte.view.ageTextField.setText(String.valueOf(NutriByte.person.age));
				NutriByte.view.weightTextField.setText(String.valueOf(NutriByte.person.weight));
				NutriByte.view.heightTextField.setText(String.valueOf(NutriByte.person.height));
				NutriByte.view.ingredientsToWatchTextArea.setText(NutriByte.person.ingredientsToWatch);
				
				String phName = null;
				
				float phlevel = NutriByte.person.physicalActivityLevel; 
				
				for (NutriProfiler.PhysicalActivityEnum c : NutriProfiler.PhysicalActivityEnum.values()) {
						if (c.getPhysicalActivityLevel()==phlevel) 
							phName = c.getName(); 
						break; 
						}
				NutriByte.view.physicalActivityComboBox.setValue(phName);
				
				NutriProfiler.createNutriProfile(NutriByte.person); //populate recommended nutrients lists
				NutriByte.view.recommendedNutrientsTableView.setItems(NutriProfiler.recommendedNutrientsList);
				} 
			}
		}
	}
			
		
	


	//1. NewMenuItemHandler: Switches the screen from welcome screen 
	//to NutriByte.view.nutriTrackerPane. Invokes initializePrompts() 
	//method of View class. Clears the recommended nutrients TableView.
	class NewMenuItemHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			NutriByte.view.root.setCenter(NutriByte.view.nutriTrackerPane);  // switches the screen from welcome to menu
			NutriByte.view.initializePrompts(); //Initialze Prompts 
			NutriProfiler.recommendedNutrientsList.clear();
		}
	}

	class AboutMenuItemHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("About");
			alert.setHeaderText("NutriByte");
			alert.setContentText("Version 2.0 \nRelease 1.0\nCopyleft Java Nerds\nThis software is designed purely for educational purposes.\nNo commercial use intended");
			Image image = new Image(getClass().getClassLoader().getResource(NutriByte.NUTRIBYTE_IMAGE_FILE).toString());
			ImageView imageView = new ImageView();
			imageView.setImage(image);
			imageView.setFitWidth(300);
			imageView.setPreserveRatio(true);
			imageView.setSmooth(true);
			alert.setGraphic(imageView);
			alert.showAndWait();
		}
	}

}

