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
@Table(name = "order_price")
public class OrderPrice implements Serializable{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "order_price_id")
	private Long id;
	
	@Column(name="order_price" , nullable = false , unique = false)
	private Long foodPrice;
	
	@Column(name="price_date_of_created" , nullable = false , unique = false)
	private Date dateOfCreated;
	
	public OrderPrice() {}

	public OrderPrice(Long foodPrice, Date dateOfCreated) {
		super();
		this.foodPrice = foodPrice;
		this.dateOfCreated = dateOfCreated;
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

	@Override
	public String toString() {
		return "OrderPrice [id=" + id + ", foodPrice=" + foodPrice + ", dateOfCreated=" + dateOfCreated + "]";
	}
	
	
}
