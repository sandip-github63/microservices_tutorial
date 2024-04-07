package com.hotel.service;

import java.util.List;

import com.hotel.model.Hotel;

public interface HotelService {

	List<Hotel> getAllHotels();

	Hotel getHotelById(Long id);

	Hotel createHotel(Hotel hotel);

	Hotel updateHotel(Long id, Hotel hotel);

	void deleteHotel(Long id);
}
