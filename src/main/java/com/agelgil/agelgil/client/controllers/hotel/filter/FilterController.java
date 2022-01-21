package com.agelgil.agelgil.client.controllers.hotel.filter;

import java.util.List;

import com.agelgil.agelgil.client.controllers.ClientController;
import com.agelgil.agelgil.hotel.data.models.Hotel;
import com.agelgil.agelgil.hotel.data.repositories.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FilterController extends ClientController{

	@Autowired
	protected HotelRepository hotelRepository;

	@GetMapping("/client/filter/top-rated")
	private String displayTopRated(
		ModelMap modelMap
	){

		setFilterResults(
			hotelRepository.findTop10ByVerifiedOrderByRating(true),
			modelMap
			);

		return "client/hotel/filter/filter_view.html";

	}

	@GetMapping("/client/search/")
	public String search(
		@RequestParam(name = "q") String query,
		ModelMap modelMap
		){
			setFilterResults(hotelRepository.findByVerifiedAndNameContaining(true, query), modelMap);
			modelMap.addAttribute("searchQuery", query);
			return "client/hotel/filter/search.html";
	}

	@GetMapping("/client/filter/location")
	public String filterByLocation(
		@RequestParam(name = "city") String city,
		ModelMap modelMap
	){
		setFilterResults(
			hotelRepository.findByLocationCityAndVerified(city, true), 
			modelMap
		);

		return "client/hotel/filter/filter_view.html";
	}

	private void setFilterResults(List<Hotel> filterResult, ModelMap modelMap){
		modelMap.addAttribute("filterResults", filterResult);
	}

}
