package com.agelgil.agelgil.lib.controllers;


import com.agelgil.agelgil.lib.data.repositories.webcontent.ContactInformationRespository;
import com.agelgil.agelgil.lib.services.FileStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;


public class AgelgilController {
	
	@Autowired
	private ContactInformationRespository contactInformationRespository;

	@Autowired
	private FileStorageService storageService;

	@ModelAttribute
	protected void setupModelMap(ModelMap modelMap){
		modelMap.addAttribute(
			"contactInformations", contactInformationRespository.findAll()
		);
	}

	@ModelAttribute("media")
	protected FileStorageService fetchStorageService(){
		return storageService;
	}

}
