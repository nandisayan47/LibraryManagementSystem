
package com.sayan.project.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name =  "users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fname;
	private String lname;
	private String city;
	private String username;
	private String password;
	private boolean enabled;
	
	@CreationTimestamp //This annotation will automatically insert the time and date when a user registers in our web site
	private LocalDateTime dateCreated;//We don't need to add it in the constructor as it will be auto generated like the id field
	
	
	//We can reduce the boilerplate code for getters and setters by using @Getter @Setter annotation by adding dependency for Lombok
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	
	
	public User(String fname, String lname, String city,String username, String password, boolean enabled, Set<Role> roles) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.city=city;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
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

	public User() {
		super();
	}

	public Long getId() {
	        return id;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setId(Long id) {
		this.id = id;
	}
}