package com.agelgil.agelgil.client.view.about;

import com.agelgil.agelgil.client.view.ClientController;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@Component
class AboutUsController extends ClientController{

	@GetMapping("/client/about-us")
	public String displayAboutUs(
		ModelMap modelMap
	){

		return "client/about/about.html";
	}

	@ModelAttribute
	@Override
	public void setupModelMap(ModelMap modelMap){
		super.setupModelMap(modelMap);
	}

}
