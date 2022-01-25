package com.agelgil.agelgil.hotel.data.repositories;

import java.util.List;

import com.agelgil.agelgil.hotel.data.models.Hotel;
import com.agelgil.agelgil.lib.data.models.auth.User;

import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, Long>{
	
	public Hotel findByIdAndVerified(Long id, Boolean verified);

	public Hotel findByUser(User user);

	public List<Hotel> findByVerifiedAndNameContaining(Boolean verified, String name);

	public List<Hotel> findTop10ByVerifiedOrderByRating(Boolean verified);

	public List<Hotel> findByLocationCityAndVerified(String city, Boolean verified);

	public List<Hotel> findByVerified(Boolean verified);

}
