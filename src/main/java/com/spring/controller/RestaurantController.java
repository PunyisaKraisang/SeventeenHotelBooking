package com.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dto.KeywordCategory;
import com.spring.model.MenuKeywordListModel;
import com.spring.model.MenuKeywordModel;
import com.spring.model.MenuModel;
import com.spring.model.SearchMenuModel;
import com.spring.service.RestaurantService;

@Controller
@SessionAttributes("keywordList")
public class RestaurantController {

	private static final Logger LOGGER = Logger.getLogger(RestaurantController.class);
	
	@Autowired
	private RestaurantService service;
	
	@ModelAttribute("keywordList")
	public MenuKeywordListModel keywordList() {
		return new MenuKeywordListModel();
	}
	
	@GetMapping("/restaurant")
	public String goToRestaurantPage(
			@ModelAttribute(name = "searchModel") SearchMenuModel searchModel, 
			@ModelAttribute("keywordList") MenuKeywordListModel keywordList,
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
	
	@PostMapping("/restaurant")
	public String searchMenu(@ModelAttribute(name = "searchModel") SearchMenuModel searchModel, Model model) {
		
		//TODO: Validate searchModel
		LOGGER.info("Fetch menu list with criteria: " + searchModel);
		List<MenuModel> menuList = service.fetchMenu(searchModel);
		
		LOGGER.info("Pass menu list through model");
		model.addAttribute("menuList", menuList);
		
		return "restaurant";
	}
}
