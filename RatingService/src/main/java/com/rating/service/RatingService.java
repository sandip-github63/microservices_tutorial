package com.rating.service;

import java.util.List;
import java.util.Optional;

import com.rating.model.Rating;

public interface RatingService {

	Rating saveRating(Rating rating);

	Optional<Rating> getRatingById(Long ratingId);

	List<Rating> getAllRatings();

	List<Rating> getRatingsByUserId(Long userId);

	List<Rating> getRatingsByHotelId(Long hotelId);

	void deleteRating(Long ratingId);

}
