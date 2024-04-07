package com.hotel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hotelId;

	private String name;

	private String address;

	private int rating;
	// Add more attributes as needed

	// Constructors, getters, and setters
	public Hotel() {
	}

	public Hotel(String name, String address, int rating) {
		this.name = name;
		this.address = address;
		this.rating = rating;
	}

	// Getters and setters
	public Long getId() {
		return hotelId;
	}

	public void setId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	// Add more getters and setters for other attributes
}
