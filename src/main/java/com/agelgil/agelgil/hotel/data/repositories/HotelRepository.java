package com.agelgil.agelgil.hotel.data.repositories;

import com.agelgil.agelgil.hotel.data.models.Hotel;
import com.agelgil.agelgil.lib.data.models.auth.User;

import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, String>{
	
	public Hotel findByUser(User user);

}
