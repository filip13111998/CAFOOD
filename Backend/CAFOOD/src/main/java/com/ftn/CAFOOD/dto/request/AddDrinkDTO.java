package com.ftn.CAFOOD.dto.request;

import java.util.ArrayList;

public class AddDrinkDTO {
	private String name;
	private String description;
	private ArrayList<String> foodAllergens;
	private String timeOfPreparation;
	private Long foodPrice;
	private boolean inMenu;
	
	
	

	public AddDrinkDTO(String name, String description, ArrayList<String> foodAllergens, String timeOfPreparation,
			Long foodPrice, boolean inMenu) {
		super();
		this.name = name;
		this.description = description;
		this.foodAllergens = foodAllergens;
		this.timeOfPreparation = timeOfPreparation;
		this.foodPrice = foodPrice;
		this.inMenu = inMenu;
	}

	
	
	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public ArrayList<String> getFoodAllergens() {
		return foodAllergens;
	}



	public void setFoodAllergens(ArrayList<String> foodAllergens) {
		this.foodAllergens = foodAllergens;
	}



	public String getTimeOfPreparation() {
		return timeOfPreparation;
	}



	public void setTimeOfPreparation(String timeOfPreparation) {
		this.timeOfPreparation = timeOfPreparation;
	}



	public Long getFoodPrice() {
		return foodPrice;
	}



	public void setFoodPrice(Long foodPrice) {
		this.foodPrice = foodPrice;
	}



	public boolean isInMenu() {
		return inMenu;
	}



	public void setInMenu(boolean inMenu) {
		this.inMenu = inMenu;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
