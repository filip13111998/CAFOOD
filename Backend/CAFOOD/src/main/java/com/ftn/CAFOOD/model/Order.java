package com.ftn.CAFOOD.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

@Entity
@Table(name = "orders")
public class Order implements Serializable{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "order_id")
	private Long id;
	   
	@Column(name="order_name" , nullable = false , unique = false)
    private String name;
   
	@Column(name="barmen_licitation" , nullable = false , unique = false)
    private Date barmenLicitation;
   
	@Column(name="cook_lic1" , nullable = false , unique = false)
    private Date cookAppetLicitation;
   
	@Column(name="cook_lic2" , nullable = false , unique = false)
    private Date cookMainLicitation;
	
	@Column(name="cook_lic3" , nullable = false , unique = false)
    private Date cookDesertLicitation;
    
	@Column(name="appe_act" , nullable = false , unique = false)
    private boolean appe_act;
    
	@Column(name="main_act" , nullable = false , unique = false)
    private boolean main_act;
    
	@Column(name="des_act" , nullable = false , unique = false)
    private boolean des_act;
    
	@Column(name="barmen_act" , nullable = false , unique = false)
    private boolean barmen_act;
	
	@Enumerated(EnumType.ORDINAL)
    public STATE state;
   
	@OneToMany(mappedBy =  "id", cascade =  CascadeType.ALL , fetch = FetchType.LAZY)
    public List<OrderFood> orderFood =  new ArrayList<OrderFood>();
   
	@OneToMany(mappedBy =  "id", cascade =  CascadeType.ALL , fetch = FetchType.LAZY)
    public List<OrderDrink> orderDrink = new ArrayList<OrderDrink>();
    
    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name="order_price_id")
    public OrderPrice price;
    
    public Order() {
    	
    }

	public Order(String name, Date barmenLicitation, Date cookAppetLicitation, Date cookMainLicitation,
			Date cookDesertLicitation, boolean appe_act, boolean main_act, boolean des_act, boolean barmen_act,
			STATE state, List<OrderFood> orderFood, List<OrderDrink> orderDrink, OrderPrice price) {
		super();
		this.name = name;
		this.barmenLicitation = barmenLicitation;
		this.cookAppetLicitation = cookAppetLicitation;
		this.cookMainLicitation = cookMainLicitation;
		this.cookDesertLicitation = cookDesertLicitation;
		this.appe_act = appe_act;
		this.main_act = main_act;
		this.des_act = des_act;
		this.barmen_act = barmen_act;
		this.state = state;
		this.orderFood = orderFood;
		this.orderDrink = orderDrink;
		this.price = price;
	}

	public boolean isBarmen_act() {
		return barmen_act;
	}

	public void setBarmen_act(boolean barmen_act) {
		this.barmen_act = barmen_act;
	}


	public void setOrderFood(List<OrderFood> orderFood) {
		this.orderFood = orderFood;
	}


	public void setOrderDrink(List<OrderDrink> orderDrink) {
		this.orderDrink = orderDrink;
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




	public Date getBarmenLicitation() {
		return barmenLicitation;
	}




	public void setBarmenLicitation(Date barmenLicitation) {
		this.barmenLicitation = barmenLicitation;
	}




	public Date getCookAppetLicitation() {
		return cookAppetLicitation;
	}




	public void setCookAppetLicitation(Date cookAppetLicitation) {
		this.cookAppetLicitation = cookAppetLicitation;
	}




	public Date getCookMainLicitation() {
		return cookMainLicitation;
	}




	public void setCookMainLicitation(Date cookMainLicitation) {
		this.cookMainLicitation = cookMainLicitation;
	}




	public Date getCookDesertLicitation() {
		return cookDesertLicitation;
	}




	public void setCookDesertLicitation(Date cookDesertLicitation) {
		this.cookDesertLicitation = cookDesertLicitation;
	}




	public boolean isAppe_act() {
		return appe_act;
	}




	public void setAppe_act(boolean appe_act) {
		this.appe_act = appe_act;
	}




	public boolean isMain_act() {
		return main_act;
	}




	public void setMain_act(boolean main_act) {
		this.main_act = main_act;
	}




	public boolean isDes_act() {
		return des_act;
	}




	public void setDes_act(boolean des_act) {
		this.des_act = des_act;
	}




	public STATE getState() {
		return state;
	}




	public void setState(STATE state) {
		this.state = state;
	}




	public List<OrderFood> getOrderFood() {
		return orderFood;
	}




	public void setOrderFood(ArrayList<OrderFood> orderFood) {
		this.orderFood = orderFood;
	}




	public List<OrderDrink> getOrderDrink() {
		return orderDrink;
	}




	public void setOrderDrink(ArrayList<OrderDrink> orderDrink) {
		this.orderDrink = orderDrink;
	}




	public OrderPrice getPrice() {
		return price;
	}




	public void setPrice(OrderPrice price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", barmenLicitation=" + barmenLicitation
				+ ", cookAppetLicitation=" + cookAppetLicitation + ", cookMainLicitation=" + cookMainLicitation
				+ ", cookDesertLicitation=" + cookDesertLicitation + ", appe_act=" + appe_act + ", main_act=" + main_act
				+ ", des_act=" + des_act + ", barmen_act=" + barmen_act + ", state=" + state + ", orderFood="
				+ orderFood + ", orderDrink=" + orderDrink + ", price=" + price + "]";
	}
	
}
