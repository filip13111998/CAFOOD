package com.ftn.CAFOOD.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_drink")
public class OrderDrink implements Serializable{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "order_drink_id")
	private Long id;
	 
	@Column(name="drink_count" , nullable = false , unique = false)
	private int count;
	  
	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name="drink_id")
	private Drink drink;

//	@ManyToOne(fetch =  FetchType.LAZY , cascade = CascadeType.ALL)
//	private Order order;
	
	public OrderDrink(){
		
	}
	
	public OrderDrink(int count, Drink drink) {
		super();
		this.count = count;
		this.drink = drink;
//		this.order = order;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}


	@Override
	public String toString() {
		return "OrderDrink [id=" + id + ", count=" + count + ", drink=" + drink +  "]";
	}

	

	 
	 
	
}
