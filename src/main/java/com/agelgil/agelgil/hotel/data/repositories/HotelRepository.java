package com.agelgil.agelgil.hotel.data.repositories;

import com.agelgil.agelgil.hotel.data.models.Hotel;

import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, String>{
	
}
