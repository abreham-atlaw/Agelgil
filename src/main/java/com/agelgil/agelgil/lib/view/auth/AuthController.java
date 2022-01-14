package com.agelgil.agelgil.lib.view.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthController {

	
	@PostMapping("/login")
	public String login(String redirectUrl){
		return "";
	}


	@PostMapping("/logout")
	public String logout(String redirectUrl){
		return "";
	}

}
