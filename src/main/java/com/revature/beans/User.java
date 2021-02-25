package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	// INSTANCE VARIABLES //

	@Id
	@Column(updatable = false, name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 64, unique = true, name = "EMAIL")
	private String email;
	@Column(length = 32, name = "PASSWORD")
	private String password;
	@Column(length = 32, name = "FIRST_NAME")
	private String firstName;
	@Column(length = 32, name = "LAST_NAME")
	private String lastName;
	@Column(name = "ADMIN_STATUS")
	private boolean admin;

	// CONSTRUCTORS //
	// No args
	public User() {
		super();
	}

	// id-less
	public User(String email, String password, String firstName, String lastName, boolean admin) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.admin = admin;
	}

	// Full args
	public User(int id, String email, String password, String firstName, String lastName, boolean admin) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.admin = admin;
	}

	// -----GETTERS AND SETTERS----- //
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", admin=" + admin + "]";
	}

}
