package com.ftn.CAFOOD.dto.request;

public class EditMenuFoodDTO {
	private String name;

	public EditMenuFoodDTO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
