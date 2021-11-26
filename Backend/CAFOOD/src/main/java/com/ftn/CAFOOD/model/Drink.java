package com.ftn.CAFOOD.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Drink")
public class Drink implements Serializable{
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "drink_id")
	private Long id;
	
	@Column(name="drink_name" , nullable = false , unique = true)
	private String name;
	
	@Column(name="drink_description" , nullable = false , unique = false)
	private String description;
	
	@Column(name="drink_time_of_preparation" , nullable = false , unique = false)
	private Date timeOfPreparation;
	
	@Column(name="drink_in_menu" , nullable = false , unique = false)
	private boolean inMenu;
	
	@Column(name="drink_deleted" , nullable = false , unique = false)
	private boolean deleted;
	
//	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
//	@JoinColumn(name="price_id")
//	private DrinkPrice price;
	
	
	@OneToMany(cascade =  CascadeType.ALL , fetch = FetchType.LAZY)
	private List<DrinkPrice> pricesHistory = new ArrayList<DrinkPrice>();

	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name="image_id")
	private Image drinkImage; // image of the food.
	
	

	public Drink() {
	}

	public Drink(String name, String description, Date timeOfPreparation, boolean inMenu, boolean deleted,
			  Image drinkImage) {
		super();
		this.name = name;
		this.description = description;
		this.timeOfPreparation = timeOfPreparation;
		this.inMenu = inMenu;
		this.deleted = deleted;
		this.drinkImage = drinkImage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getTimeOfPreparation() {
		return timeOfPreparation;
	}

	public void setTimeOfPreparation(Date timeOfPreparation) {
		this.timeOfPreparation = timeOfPreparation;
	}

	public boolean isInMenu() {
		return inMenu;
	}

	public void setInMenu(boolean inMenu) {
		this.inMenu = inMenu;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public List<DrinkPrice> getPricesHistory() {
		return pricesHistory;
	}

	public void setPricesHistory(ArrayList<DrinkPrice> pricesHistory) {
		this.pricesHistory = pricesHistory;
	}

	public Image getDrinkImage() {
		return drinkImage;
	}

	public void setDrinkImage(Image drinkImage) {
		this.drinkImage = drinkImage;
	}

	@Override
	public String toString() {
		return "Drink [id=" + id + ", name=" + name + ", description=" + description + ", timeOfPreparation="
				+ timeOfPreparation + ", inMenu=" + inMenu + ", deleted=" + deleted + 
				 ", pricesHistory=" + pricesHistory + ", drinkImage=" + drinkImage + "]";
	}





}
