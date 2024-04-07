package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.model.Hotel;

public interface HotelRepostiory extends JpaRepository<Hotel, Long> {

}
