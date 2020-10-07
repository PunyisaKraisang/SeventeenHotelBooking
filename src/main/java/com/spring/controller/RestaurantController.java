package com.spring.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.MenuModel;
import com.spring.service.RestaurantService;

@Controller
public class RestaurantController {

	private static final Logger LOGGER = Logger.getLogger(RestaurantController.class);
	
	@Autowired
	RestaurantService service;
	
	@GetMapping("/restaurant")
	public String goToRestaurantPage(Model model) {
		
		List<MenuModel> menuList = service.fetchMenu();
		
		LOGGER.info("Pass menu list through model");
		model.addAttribute("menuList", menuList);
		
		return "restaurant";
	}
	
}
