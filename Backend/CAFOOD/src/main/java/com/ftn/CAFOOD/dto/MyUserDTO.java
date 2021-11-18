package com.ftn.CAFOOD.dto;

public class MyUserDTO {
	
	private String username;
	private String pass;
	private String fn;
	private String ln;
	private String role;
	private Long salary;
	public MyUserDTO(String username, String pass, String fn, String ln, String role, Long salary) {
		super();
		this.username = username;
		this.pass = pass;
		this.fn = fn;
		this.ln = ln;
		this.role = role;
		this.salary = salary;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Long getSal_id() {
		return salary;
	}
	public void setSal_id(Long sal_id) {
		this.salary = sal_id;
	}
	
	
	
}
