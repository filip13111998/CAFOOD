package com.ftn.CAFOOD.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "food_price")
public class FoodPrice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "food_price_id")
	private Long id;
	
	@Column(name="food_price" , nullable = false , unique = false)
	private Long foodPrice;
	
	@Column(name="price_date_of_created" , nullable = false , unique = false)
	private Date dateOfCreated;
	
//	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
//	private Food food;
	
	@Column(name="active" , nullable = false , unique = false)
	private boolean active;

	public FoodPrice() {}
	
	public FoodPrice(Long foodPrice, Date dateOfCreated , boolean active) {
		super();
		this.foodPrice = foodPrice;
		this.dateOfCreated = dateOfCreated;
		this.active = active;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(Long foodPrice) {
		this.foodPrice = foodPrice;
	}

	public Date getDateOfCreated() {
		return dateOfCreated;
	}

	public void setDateOfCreated(Date dateOfCreated) {
		this.dateOfCreated = dateOfCreated;
	}


	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "FoodPrice [id=" + id + ", foodPrice=" + foodPrice + ", dateOfCreated=" + dateOfCreated + "]";
	}
	
	

	
}
