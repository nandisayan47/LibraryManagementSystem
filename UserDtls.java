package com.sayan.lms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_details")
public class UserDtls {

	private String  fullname;
	@Id
	private String email;
	private String  password;
	private String role;
	

	@Override
	public String toString() {
		return "UserDtls [fullname=" + fullname + ", email=" + email + ", password=" + password + ", role=" + role
				+ "]";
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
