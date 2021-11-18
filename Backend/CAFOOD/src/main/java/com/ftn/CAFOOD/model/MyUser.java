package com.ftn.CAFOOD.model;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "MyUser")
public class MyUser implements Serializable{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "user_id")
	private Long user_id;
	
	@Column(name="username" , nullable = false , unique = true)
	private String username;
	
	@Column(name="password" , nullable = false , unique = false)
	private String password;
	
	@Column(name="firstName" , nullable = false , unique = false)
	private String firstName;
	
	@Column(name="lastName" , nullable = false , unique = false)
	private String lastName;
	
	@Column(name="delete" , nullable = false , unique = false)
	private boolean delete;
	 
	@Column(name="user_role" , nullable = false , unique = false)
	private String role;
	
	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name="image_id")
	private Image user_image;
	   
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
//	@JoinColumn(name="price_id")
	public List<Salary> salary = new ArrayList<Salary>();
	
//	@OneToMany(mappedBy =  "id", cascade =  CascadeType.ALL , fetch = FetchType.LAZY)
//	public List<Salary> salaryHistory = new ArrayList<Salary>();
	   
	public MyUser() {}


	public MyUser(String username, String password, String firstName, String lastName, boolean delete, String role,
			Image user_image) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.delete = delete;
		this.role = role;
		this.user_image = user_image;
		this.salary = salary;
	}


	public List<Salary> getSalary() {
		return salary;
	}


	public void setSalary(List<Salary> salary) {
		this.salary = salary;
	}


	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Image getUser_image() {
		return user_image;
	}

	public void setUser_image(Image user_image) {
		this.user_image = user_image;
	}

	
	
	
	   
	
}
