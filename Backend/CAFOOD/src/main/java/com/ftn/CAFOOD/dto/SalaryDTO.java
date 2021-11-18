package com.ftn.CAFOOD.dto;

import com.ftn.CAFOOD.model.MyUser;

public class SalaryDTO {
	
	private Long price;
	private MyUser username;
	
	public SalaryDTO(Long pr,MyUser mu) {
		this.setPrice(pr);
		this.setUsername(mu);
	}


	public void setUsername(MyUser username) {
		this.username = username;
	}


	public Long getPrice() {
		return price;
	}


	public void setPrice(Long price) {
		this.price = price;
	}


	public MyUser getUsername() {
		return username;
	}


	
	
	
}
