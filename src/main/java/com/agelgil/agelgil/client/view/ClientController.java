package com.agelgil.agelgil.client.view;

import java.util.Arrays;

import com.agelgil.agelgil.lib.data.models.webcontent.Tab;
import com.agelgil.agelgil.lib.view.AgelgilController;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;


public class ClientController extends AgelgilController {
	
	@ModelAttribute
	public void setupModelMap(ModelMap modelMap){
		super.setupModelMap(modelMap);
		modelMap.addAttribute(
			"headerTabs", Arrays.asList(
				new Tab(0, "Home", "/", 0, "header"),
				new Tab(1, "Top Rated", "/top-rated", 1, "header"),
				new Tab(2,"About Us", "/about-us", 2, "header"),
				new Tab(3, "Contact Us", "/contact-us", 3, "header")
			)
		);

		modelMap.addAttribute(
			"footerTabs", Arrays.asList(
				new Tab(0, "Home", "/", 0, "footer"),
				new Tab(1, "Top Rated", "/top-rated", 1, "footer"),
				new Tab(2, "FAQs", "/about-us/faqs", 2, "footer"),
				new Tab(3, "About Us", "/about-us", 3, "footer"),
				new Tab(4, "Contact Us", "/contact-us", 4, "footer")
			)
		);

	} 

}
