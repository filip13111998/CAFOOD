package com.ftn.CAFOOD.dto.request;

import java.util.ArrayList;

import com.ftn.CAFOOD.model.FOOD_TYPE;

public class FoodDTO {
	private String name;
	private String description;
	private ArrayList<String> foodAllergens;
	private String timeOfPreparation;
	private Long price;
	public FOOD_TYPE food_type;
	private boolean inMenu;
	
	public FoodDTO(String name, String description, ArrayList<String> foodAllergens, String timeOfPreparation,
			Long price, FOOD_TYPE food_type,  boolean inMenu) {
		super();
		this.name = name;
		this.description = description;
		this.foodAllergens = foodAllergens;
		this.timeOfPreparation = timeOfPreparation;
		this.price = price;
		this.food_type = food_type;
		
		this.inMenu = inMenu;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public FOOD_TYPE getFood_type() {
		return food_type;
	}
	public void setFood_type(FOOD_TYPE food_type) {
		this.food_type = food_type;
	}
	public boolean isInMenu() {
		return inMenu;
	}
	public void setInMenu(boolean inMenu) {
		this.inMenu = inMenu;
	}

}
