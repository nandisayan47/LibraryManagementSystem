package com.sayan.project.controller.dto;

public class UserRegistrationDto {
	private String fname;
	private String lname;
	private String city;
	private String username;
	private String password;
	
	
	
	public UserRegistrationDto(String fname, String lname,String city, String username, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.city=city;
		this.username = username;
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public UserRegistrationDto() {
		// TODO Auto-generated constructor stub
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
	
}
