package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.model.Hotel;
import com.hotel.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels() {
		List<Hotel> hotels = hotelService.getAllHotels();
		return new ResponseEntity<>(hotels, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
		Hotel hotel = hotelService.getHotelById(id);
		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		Hotel createdHotel = hotelService.createHotel(hotel);
		return new ResponseEntity<>(createdHotel, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
		Hotel updatedHotel = hotelService.updateHotel(id, hotel);
		return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
		hotelService.deleteHotel(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}