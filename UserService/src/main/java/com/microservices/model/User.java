package com.microservices.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "User_Info")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "about")
	private String about;

	@Transient
	private List<Rating> ratings;

	// Constructors, getters, and setters

	public User() {
	}

	public User(String name, String email, String about) {
		this.name = name;
		this.email = email;
		this.about = about;
	}

	// Getters and setters

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	// toString, equals, and hashCode methods

	@Override
	public String toString() {
		return "User{" + "userId=" + userId + ", name='" + name + '\'' + ", email='" + email + '\'' + ", about='"
				+ about + '\'' + '}';
	}

}
