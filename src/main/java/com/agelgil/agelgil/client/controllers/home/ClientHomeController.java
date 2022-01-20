package com.agelgil.agelgil.client.controllers.home;

import com.agelgil.agelgil.client.controllers.ClientController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientHomeController extends ClientController{


	@GetMapping("/")
	public String home(){
		return "/client/home/home.html";
	}
	
}
