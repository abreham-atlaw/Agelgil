package com.agelgil.agelgil.client.controllers.search;

import com.agelgil.agelgil.client.controllers.ClientController;
import com.agelgil.agelgil.hotel.data.repositories.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SearchController extends ClientController{

	@Autowired
	private HotelRepository hotelRepository;

	@GetMapping("/client/search/")
	public String search(
		@RequestParam(name = "q") String query,
		ModelMap modelMap
		){

			modelMap.addAttribute("searchResults", hotelRepository.findByVerifiedAndNameContaining(true, query));
			modelMap.addAttribute("searchQuery", query);
			return "client/search/search.html";
	}
	
}
