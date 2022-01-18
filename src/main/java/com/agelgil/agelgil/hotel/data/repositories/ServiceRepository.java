package com.agelgil.agelgil.hotel.data.repositories;

import java.util.List;

import com.agelgil.agelgil.hotel.data.models.Hotel;
import com.agelgil.agelgil.hotel.data.models.Service;

import org.springframework.data.repository.CrudRepository;


public interface ServiceRepository extends CrudRepository<Service, Long>{

	public List<Service> findByHotel(Hotel hotel);
	
}
