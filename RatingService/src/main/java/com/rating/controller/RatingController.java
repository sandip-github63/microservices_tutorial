package com.rating.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.model.Rating;
import com.rating.service.RatingService;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

	private final RatingService ratingService;

	@Autowired
	public RatingController(RatingService ratingService) {
		this.ratingService = ratingService;
	}

	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		Rating savedRating = ratingService.saveRating(rating);
		return new ResponseEntity<>(savedRating, HttpStatus.CREATED);
	}

	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> getRatingById(@PathVariable Long ratingId) {
		Optional<Rating> rating = ratingService.getRatingById(ratingId);
		return rating.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings() {
		List<Rating> ratings = ratingService.getAllRatings();
		return new ResponseEntity<>(ratings, HttpStatus.OK);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable Long userId) {
		List<Rating> ratings = ratingService.getRatingsByUserId(userId);
		return new ResponseEntity<>(ratings, HttpStatus.OK);
	}

	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable Long hotelId) {
		List<Rating> ratings = ratingService.getRatingsByHotelId(hotelId);
		return new ResponseEntity<>(ratings, HttpStatus.OK);
	}

	@DeleteMapping("/{ratingId}")
	public ResponseEntity<Void> deleteRating(@PathVariable Long ratingId) {
		ratingService.deleteRating(ratingId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
