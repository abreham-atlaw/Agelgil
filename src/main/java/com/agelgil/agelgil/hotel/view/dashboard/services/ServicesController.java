package com.agelgil.agelgil.hotel.view.dashboard.services;

import com.agelgil.agelgil.hotel.data.models.Service;
import com.agelgil.agelgil.hotel.data.models.Service.ServiceType;
import com.agelgil.agelgil.hotel.data.repositories.ServiceRepository;
import com.agelgil.agelgil.hotel.view.dashboard.DashboardController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public class ServicesController extends DashboardController{
	
	@Autowired
	private ServiceRepository serviceRepository;


	@GetMapping("/hotel/dashboard/services")
	public String displayServices(){

		return "hotel/dashboard/services.html";
	}

	@PostMapping("/hotel/dashboard/services")
	public String handleServicesForm(){


		return "hotel/dashboard/services.html";
	}

	@ModelAttribute
	public Iterable<Service> fetchServices(){
		return serviceRepository.findAll();
	}

	@ModelAttribute
	public Iterable<ServiceType> fetchServiceTypes(){
		
	}

}
