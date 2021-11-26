package com.ftn.CAFOOD.dto.request;

import java.util.ArrayList;

public class UpdateDrinkDTO {
	private String name;
	private String description;
	private String timeOfPreparation;
	private Long foodPrice;
	public UpdateDrinkDTO(String name, String description, String timeOfPreparation, Long foodPrice) {
		super();
		this.name = name;
		this.description = description;
		this.timeOfPreparation = timeOfPreparation;
		this.foodPrice = foodPrice;
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
	
	
	
}
