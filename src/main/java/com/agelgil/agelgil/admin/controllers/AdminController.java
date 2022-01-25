package com.agelgil.agelgil.admin.controllers;

import java.security.Principal;

import com.agelgil.agelgil.admin.data.models.Admin;
import com.agelgil.agelgil.admin.data.repositories.AdminRepository;
import com.agelgil.agelgil.lib.controllers.AgelgilController;
import com.agelgil.agelgil.lib.data.repositories.auth.UserRepository;
import com.agelgil.agelgil.lib.extra.auth.UserManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class AdminController extends AgelgilController{
	
	
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private UserRepository userRepository;


	@ModelAttribute(name = "admin")
	public Admin admin(Principal principal){
		if(principal == null)
			return null;
		return adminRepository.findByUser(
			userRepository.findByUsername(principal.getName())
		);
	}

}
