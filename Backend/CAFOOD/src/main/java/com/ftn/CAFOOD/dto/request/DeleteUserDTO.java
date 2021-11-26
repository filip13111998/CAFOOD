package com.ftn.CAFOOD.dto.request;

public class DeleteUserDTO {
	private String username;

	// for deserialisation
    public DeleteUserDTO() {}  
	
	public DeleteUserDTO(String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
