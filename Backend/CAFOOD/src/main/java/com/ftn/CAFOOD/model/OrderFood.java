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
@Table(name = "order_food")
public class OrderFood implements Serializable{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "order_food_id")  
	private Long id;
  
	@Column(name="food_count" , nullable = false , unique = false)
	private int count;
   
	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name="food_id")
	public Food food;

//	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
//	private Order order;
	
	public OrderFood() {
		
	}
	
	
	

	public OrderFood(int count, Food food) {
		super();
		this.count = count;
		this.food = food;
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

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}




	@Override
	public String toString() {
		return "OrderFood [id=" + id + ", count=" + count + ", food=" + food + "]";
	}


	
	
	
}
