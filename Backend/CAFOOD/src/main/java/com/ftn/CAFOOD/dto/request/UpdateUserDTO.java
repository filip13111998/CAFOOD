package com.ftn.CAFOOD.dto.request;

public class UpdateUserDTO {
	private String username;
	private String password;
	private String fn;
	private String ln;
	private Long salary;
	public UpdateUserDTO(String username, String password, String fn, String ln, 
			Long salary) {
		super();
		this.username = username;
		this.password = password;
		this.fn = fn;
		this.ln = ln;
		this.salary = salary;
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
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
	
	
}
