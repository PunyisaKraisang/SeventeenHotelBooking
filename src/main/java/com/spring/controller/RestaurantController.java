package com.spring.controller;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.dto.KeywordCategory;
import com.spring.model.MenuCheckoutListModel;
import com.spring.model.MenuKeywordListModel;
import com.spring.model.MenuModel;
import com.spring.model.SaveMenuOrderModel;
import com.spring.model.SearchMenuModel;
import com.spring.service.RestaurantService;

@Controller
@RequestMapping("/restaurant")
@SessionAttributes("keywordList")
public class RestaurantController {

	private static final Logger LOGGER = Logger.getLogger(RestaurantController.class);
	
	@Autowired
	private RestaurantService service;
	
	@ModelAttribute("keywordList")
	public MenuKeywordListModel keywordList() {
		return new MenuKeywordListModel();
	}
	
	@GetMapping
	public String goToRestaurantPage(
			@ModelAttribute(name = "searchModel") SearchMenuModel searchModel, 
			@ModelAttribute("keywordList") MenuKeywordListModel keywordList,
			@ModelAttribute("checkoutList") MenuCheckoutListModel checkoutList,
			Model model) {
		
		LOGGER.info("Enter first time without search criteria, default as recommended");
		searchModel.setRecommended(true);
		
		LOGGER.info("Fetch menu list with criteria: " + searchModel);
		List<MenuModel> menuList = service.fetchMenu(searchModel);
		
		// Extra load the keyword for drop down only when first load
		if (keywordList.getEthnicKeywords().size() == 0) {
			keywordList.setEthnicKeywords(service.fetchMenuKeyword(KeywordCategory.ETHNIC));
		}
		
		if (keywordList.getDietaryKeywords().size() == 0) {
			keywordList.setDietaryKeywords(service.fetchMenuKeyword(KeywordCategory.DIETARY));
		}
		
		LOGGER.info("Pass menu and keyword list through model");
		model.addAttribute("menuList", menuList);
		model.addAttribute("keywordList", keywordList);
		
		return "restaurant";
	}
	
	@PostMapping
	public String searchMenu(
			@ModelAttribute(name = "searchModel") SearchMenuModel searchModel, 
			@ModelAttribute("checkoutList") MenuCheckoutListModel checkoutList,
			Model model) {
		
		//TODO: Validate searchModel
		LOGGER.info("Fetch menu list with criteria: " + searchModel);
		List<MenuModel> menuList = service.fetchMenu(searchModel);
		
		LOGGER.info("Pass menu list through model");
		model.addAttribute("menuList", menuList);
		
		return "restaurant";
	}

	@PostMapping("/checkout")
	public String checkout(
			@ModelAttribute("checkoutList") MenuCheckoutListModel checkoutList,
			@ModelAttribute("menuOrder") SaveMenuOrderModel menuOrder, 
			Model model) {
		
		LOGGER.info("Checkout with " + checkoutList.getItems().size() + " menu(s)");
		
		LOGGER.info("Retrieve ongoing or pending reservation for user: " + "dummy");
		//TODO: Make search

		LOGGER.info("Pass data to checkput page");
		model.addAttribute("checkoutList", checkoutList);
		
		return "restaurantCheckout";
	}

	@PostMapping("/order")
	public String order(@ModelAttribute("menuOrder") SaveMenuOrderModel menuOrder, Model model) {
		
		//TODO: Validate menuOrder
		
		service.makeOrder("dummy", menuOrder);
		
		LOGGER.info("Save order success");
		return "orderSuccess";
	}
}
