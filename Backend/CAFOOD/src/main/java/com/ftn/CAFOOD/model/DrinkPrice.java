package com.ftn.CAFOOD.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "drink_price")
public class DrinkPrice implements Serializable{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "drink_price_id")
	private Long id;
	
	@Column(name="drink_price" , nullable = false , unique = false)
	private Long drinkPrice;
	
	@Column(name="price_date_of_created" , nullable = false , unique = false)
	private Date dateOfCreated;
	
	@Column(name="drink_active" , nullable = false , unique = false)
	private Boolean active;
	
//	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
//	private Drink drink;
	
	public DrinkPrice() {}

	public DrinkPrice(Long drinkPrice, Date dateOfCreated,Boolean act) {
		super();
		this.drinkPrice = drinkPrice;
		this.dateOfCreated = dateOfCreated;
		this.active = act;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDrinkPrice() {
		return drinkPrice;
	}

	public void setDrinkPrice(Long drinkPrice) {
		this.drinkPrice = drinkPrice;
	}

	public Date getDateOfCreated() {
		return dateOfCreated;
	}

	public void setDateOfCreated(Date dateOfCreated) {
		this.dateOfCreated = dateOfCreated;
	}

	@Override
	public String toString() {
		return "DrinkPrice [id=" + id + ", drinkPrice=" + drinkPrice + ", dateOfCreated=" + dateOfCreated + "]";
	}
	
	
	
}
