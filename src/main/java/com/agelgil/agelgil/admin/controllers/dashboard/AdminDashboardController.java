package com.agelgil.agelgil.admin.controllers.dashboard;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import com.agelgil.agelgil.admin.controllers.AdminController;
import com.agelgil.agelgil.admin.controllers.dashboard.forms.VertifyHotelForm;
import com.agelgil.agelgil.hotel.data.repositories.HotelRepository;
import com.agelgil.agelgil.lib.data.models.webcontent.Tab;
import com.agelgil.agelgil.lib.exceptions.httperror.InternalServerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AdminDashboardController extends AdminController{

	@Autowired
	private HotelRepository hotelRepository;

	@GetMapping("/admin/dashboard")
	public String displayUnverifiedHotels(ModelMap modelMap){

		modelMap.addAttribute(
			"hotels", hotelRepository.findByVerified(false)
		);

		return "/admin/dashboard/dashboard.html";

	}

	@PostMapping("/admin/dashboard/verify")
	public String handleVerifyHotelForm(
		@Valid VertifyHotelForm vertifyHotelForm,
		BindingResult bindingResult
	){

		if(bindingResult.hasErrors())
			throw new InternalServerException();
		
		vertifyHotelForm.handle(hotelRepository);

		return "redirect:/admin/dashboard";
	}


	@ModelAttribute(name = "verifyHotelForm")
	private VertifyHotelForm vertifyHotelForm(){
		return new VertifyHotelForm();
	}

	
	@ModelAttribute(name = "navTabs")
	public List<Tab> navTabs(){
		return Arrays.asList(
			new Tab(0, "VERIFY", "/admin/dashboard/", 1, "nav", "fas fa-user-check")
		);
	}

}
