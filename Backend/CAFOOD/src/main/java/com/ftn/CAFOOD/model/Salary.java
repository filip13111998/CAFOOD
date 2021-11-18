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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Salary")
public class Salary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "salary_id")
	private Long id;
	
	@Column(name="salary_price" ,  nullable = false, unique = false)
	private Long price;
	
	@Column(name="salary_date_of_created" , nullable = false , unique = false)
	private Date dateOfCreated;

	@Column(name="active" , nullable = false , unique = false)
	private boolean active;
	
//	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
//	@OneToOne(mappedBy = "username",cascade = CascadeType.ALL , fetch = FetchType.LAZY)
////	@JoinColumn(name="username",referencedColumnName = "username" )
//	private MyUser my_user;

	
	public Salary() {
		
	}
	
	

	public Salary(Long price, Date dateOfCreated,Boolean active) {
		super();
		this.price = price;
		this.dateOfCreated = dateOfCreated;
//		this.my_user = my_user;
		this.active = active;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Date getDateOfCreated() {
		return dateOfCreated;
	}

	public void setDateOfCreated(Date dateOfCreated) {
		this.dateOfCreated = dateOfCreated;
	}

	
	
//	public MyUser getMy_user() {
//		return my_user;
//	}
//
//
//
//	public void setMy_user(MyUser my_user) {
//		this.my_user = my_user;
//	}




	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}




	
	
}
