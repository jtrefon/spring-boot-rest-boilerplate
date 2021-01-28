package com.boilerplate.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	public User()
	{}	
	public User(String username, String password) {
		super();
		this.setUsername(username);
		this.setPassword(password);
	}
	
@Id 
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String username;
private String password;
private boolean active;

/**
 * @return user id
 */
public Long getId() {
	return id;
}
/**
 * @return the userName
 */
public String getUsername() {
	return username;
}
/**
 * @param username the userName to set
 */
public void setUsername(String username) {
	this.username = username;
}
/**
 * @return the password
 */
public String getPassword() {
	return password;
}
/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}
/**
 * @return the active
 */
public boolean isActive() {
	return active;
}
/**
 * @param active the active to set
 */
public void setActive(boolean active) {
	this.active = active;
}
}
