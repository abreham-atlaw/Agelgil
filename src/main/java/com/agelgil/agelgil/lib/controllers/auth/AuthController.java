package com.agelgil.agelgil.lib.controllers.auth;

import com.agelgil.agelgil.client.controllers.ClientController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AuthController extends ClientController { //TODO: FIND A WAY TO MAKE IT WORK BY JUST EXTENDING AgelgilContoller

	
	@GetMapping("/login")
	public String login(@RequestParam(name = "error", required = false) Object error, ModelMap modelMap){
		
		if(error != null)
			modelMap.addAttribute("loginError", true);


		return "lib/auth/login.html";
	}

	@PostMapping("/logout")
	public String logout(String redirectUrl){
		return "redirect";
	}



}
