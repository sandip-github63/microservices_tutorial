package com.hotel.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.model.Hotel;
import com.hotel.repository.HotelRepostiory;
import com.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepostiory hotelRepository;

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(Long id) {
		Optional<Hotel> hotelOptional = hotelRepository.findById(id);
		return hotelOptional.orElseThrow(() -> new RuntimeException("Hotel not found with id: " + id));
	}

	@Override
	public Hotel createHotel(Hotel hotel) {
		// You can add any business logic/validation here before saving the hotel
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel updateHotel(Long id, Hotel updatedHotel) {
		Hotel existingHotel = getHotelById(id);
		// Update the existing hotel entity with the updated values
		existingHotel.setName(updatedHotel.getName());
		existingHotel.setAddress(updatedHotel.getAddress());
		existingHotel.setRating(updatedHotel.getRating());
		// You can update other attributes as needed
		return hotelRepository.save(existingHotel);
	}

	@Override
	public void deleteHotel(Long id) {
		hotelRepository.deleteById(id);
	}
}
