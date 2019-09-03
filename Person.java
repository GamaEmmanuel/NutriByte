package hw2;

import hw2.NutriProfiler.AgeGroupEnum;

public abstract class Person {

	float age, weight, height, physicalActivityLevel; //age in years, weight in kg, height in cm
	String ingredientsToWatch;
	float[][] nutriConstantsTable = new float[NutriProfiler.RECOMMENDED_NUTRI_COUNT][NutriProfiler.AGE_GROUP_COUNT];

	NutriProfiler.AgeGroupEnum ageGroup;

	abstract void initializeNutriConstantsTable();
	abstract float calculateEnergyRequirement();
	Nutrient nutrientHere = new Nutrient(); 
 
	//remove this default constructor once you have defined the child's constructor
	Person() {
		
	}

	Person(float age, float weight, float height, float physicalActivityLevel, String ingredientsToWatch) {
		this.age = age; 
		this.weight = weight; 
		this.height = height;
		this.physicalActivityLevel = physicalActivityLevel; 
		this.ingredientsToWatch = ingredientsToWatch; 

////		
//		if (age < 0.25)
//				ageGroup = AgeGroupEnum.MAX_AGE_3M;
//		else if (0.25 < age && age < 0.50)
//				ageGroup = AgeGroupEnum.MAX_AGE_6M; 
//		else if (0.50 < age && age < 1)
//				ageGroup = AgeGroupEnum.MAX_AGE_1Y; 
//		else if (1 < age && age < 3)
//				ageGroup = AgeGroupEnum.MAX_AGE_13Y;
//		else if (3 < age && age < 8)
//				ageGroup = AgeGroupEnum.MAX_AGE_8Y; 
//		else if (8 < age && age < 18)
//				ageGroup = AgeGroupEnum.MAX_AGE_13Y; 
//		else if (18 < age && age < 30)
//				ageGroup = AgeGroupEnum.MAX_AGE_30Y; 
//		else if (30 < age && age  < 50)
//				ageGroup = AgeGroupEnum.MAX_AGE_50Y; 
//		else ageGroup = AgeGroupEnum.MAX_AGE_ABOVE; 
		
		for(NutriProfiler.AgeGroupEnum ageX: NutriProfiler.AgeGroupEnum.values()) {
			if (ageX.getAge()> age) {
				ageGroup = ageX; 
				break; 
			}
		}
		
	}

	//returns an array of nutrient values of size NutriProfiler.RECOMMENDED_NUTRI_COUNT. 
	//Each value is calculated as follows:
	//For Protein, it multiples the constant with the person's weight.
	//For Carb and Fiber, it simply takes the constant from the 
	//nutriConstantsTable based on NutriEnums' nutriIndex and the person's ageGroup
	//For others, it multiples the constant with the person's weight and divides by 1000.
	//Try not to use any literals or hard-coded values for age group, nutrient name, array-index, etc. 
	
	float[] calculateNutriRequirement() {
		//write your code here
		//Initialize array 
	//use the index got in agegroup 
		float [] nutrientRequirement = new float[NutriProfiler.RECOMMENDED_NUTRI_COUNT]; 
		
		
			nutrientRequirement[0] = (float) nutriConstantsTable[0][ageGroup.getAgeGroupIndex()]*weight; 
			nutrientRequirement[1] = (float) nutriConstantsTable[1][ageGroup.getAgeGroupIndex()]; 
			nutrientRequirement[2] = (float) nutriConstantsTable[2][ageGroup.getAgeGroupIndex()];
			
			for (int i = 3; i < nutrientRequirement.length; i++) {
				nutrientRequirement[i] = (float)(((nutriConstantsTable[i][ageGroup.getAgeGroupIndex()]) * weight)/1000);	
		}
			return nutrientRequirement;

	}
}
