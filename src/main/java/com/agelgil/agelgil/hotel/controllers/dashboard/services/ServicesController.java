package com.agelgil.agelgil.hotel.controllers.dashboard.services;

import java.security.Principal;
import java.util.List;

import com.agelgil.agelgil.hotel.controllers.dashboard.DashboardController;
import com.agelgil.agelgil.hotel.data.models.Service;
import com.agelgil.agelgil.hotel.data.models.Service.ServiceType;
import com.agelgil.agelgil.hotel.data.repositories.ServiceRepository;
import com.agelgil.agelgil.hotel.data.repositories.ServiceTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


public class ServicesController extends DashboardController{
	
	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private ServiceTypeRepository serviceTypeRepository;


	@GetMapping("/hotel/dashboard/services")
	public String displayServices(){

		return "hotel/dashboard/services.html";
	}

	@PostMapping("/hotel/dashboard/services")
	public String handleServicesForm(){


		return "hotel/dashboard/services.html";
	}

	@ModelAttribute("services")
	public List<Service> fetchServices(Principal principal){
		return serviceRepository.findByHotel(getHotel(principal));
	}

	@ModelAttribute
	public Iterable<ServiceType> fetchServiceTypes(){
		return serviceTypeRepository.findAll();
	}

}
