package com.agelgil.agelgil.client.controllers.home;

import java.util.Arrays;
import java.util.List;

import com.agelgil.agelgil.hotel.data.models.City;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientHomeRestController {

	@Value("${com.agelgil.agelgil.host}")
	private String host;


	
	@GetMapping("/api/client/home/cities")
	public ResponseEntity<List<City>> getCities(){
		
		return ResponseEntity.ok(
			Arrays.asList(
				new City(1l, "Addis Ababa",  String.format("%s/static/res/client/home/images/addis-ababa.jpg", host)),
				new City(2l, "Hawassa", String.format("%s/static/res/client/home/images/hawassa.jpg", host)),
				new City(3l, "Debre Zeit", String.format("%s/static/res/client/home/images/bahirdar.jpg", host))
			)
		);

	}

}
