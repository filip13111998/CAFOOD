package com.ftn.CAFOOD.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ftn.CAFOOD.converter.StringListConverter;

@Entity
@Table(name = "Food")
public class Food implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "food_id")
	private Long id;
	
	@Column(name="food_name" , nullable = false , unique = true)
	private String name;
	

	@Column(name="food_description" , nullable = false , unique = false)
	private String description;
	
	@Column(name="food_allergens" , nullable = false , unique = false)
	@Convert(converter = StringListConverter.class)
	private ArrayList<String> foodAllergens;
	
	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name="image_id")
    private Image foodImage; // image of the food.
	
	@Column(name="food_of_preparation" , nullable = false , unique = false)
	private Date timeOfPreparation;
	
//	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
//	@JoinColumn(name="food_price_id")
//    private FoodPrice price;
//	
	@Column(name="food_delete" , nullable = false , unique = false)
	private boolean delete;
	
	@Column(name="food_in_menu" , nullable = false , unique = false)
	private boolean inMenu;
	
	@OneToMany(cascade =  CascadeType.ALL , fetch = FetchType.EAGER)
	private List<FoodPrice> pricesHistory = new ArrayList<FoodPrice>();

	@Enumerated(EnumType.ORDINAL)
	public FOOD_TYPE food_type;
	
	public Food() {
		
	}
	
	
	

	public Food(String name, String description, ArrayList<String> foodAllergens, Image foodImage,
			Date timeOfPreparation, boolean delete, boolean inMenu,
			FOOD_TYPE food_type) {
		super();
		this.name = name;
		this.description = description;
		this.foodAllergens = foodAllergens;
		this.foodImage = foodImage;
		this.timeOfPreparation = timeOfPreparation;
		
		this.delete = delete;
		this.inMenu = inMenu;
//		this.pricesHistory = pricesHistory;
		this.food_type = food_type;
	}




	public void setPricesHistory(List<FoodPrice> pricesHistory) {
		this.pricesHistory = pricesHistory;
	}




	public FOOD_TYPE getFood_type() {
		return food_type;
	}




	public void setFood_type(FOOD_TYPE food_type) {
		this.food_type = food_type;
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

	public ArrayList<String> getFoodAllergens() {
		return foodAllergens;
	}

	public void setFoodAllergens(ArrayList<String> foodAllergens) {
		this.foodAllergens = foodAllergens;
	}

	public Image getFoodImage() {
		return foodImage;
	}

	public void setFoodImage(Image foodImage) {
		this.foodImage = foodImage;
	}

	public Date getTimeOfPreparation() {
		return timeOfPreparation;
	}

	public void setTimeOfPreparation(Date timeOfPreparation) {
		this.timeOfPreparation = timeOfPreparation;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public boolean isInMenu() {
		return inMenu;
	}

	public void setInMenu(boolean inMenu) {
		this.inMenu = inMenu;
	}

	public List<FoodPrice> getPricesHistory() {
		return pricesHistory;
	}

	public void setPricesHistory(ArrayList<FoodPrice> pricesHistory) {
		this.pricesHistory = pricesHistory;
	}




	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", description=" + description + ", foodAllergens=" + foodAllergens
				+ ", foodImage=" + foodImage + ", timeOfPreparation=" + timeOfPreparation + ", price=" + ", delete=" + delete + ", inMenu=" + inMenu + ", pricesHistory=" + pricesHistory + ", food_type="
				+ food_type + "]";
	}


	

	
}
