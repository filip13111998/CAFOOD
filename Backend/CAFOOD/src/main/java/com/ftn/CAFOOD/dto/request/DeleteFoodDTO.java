package com.ftn.CAFOOD.dto.request;

public class DeleteFoodDTO {
	private String name;

	// for deserialisation
    public DeleteFoodDTO() {}  
	
	public DeleteFoodDTO(String name) {
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
