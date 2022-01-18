package com.agelgil.agelgil.hotel.controllers.dashboard;

import java.security.Principal;

import com.agelgil.agelgil.hotel.controllers.HotelController;
import com.agelgil.agelgil.hotel.data.models.Hotel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class DashboardController  extends HotelController{
	


	@ModelAttribute
	protected void setupModelMap(ModelMap modelMap){

	}

	@ModelAttribute
	protected Hotel hotel(Principal principal){
		Hotel hotel = getHotel(principal);

		if(hotel == null)
			return hotel;//TODO HANDLE ERROR BETTER;

		return hotel;

	}

}
