package com.spring.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.model.LoginModel;

@Controller
public class AuthenticationController {

	private static final Logger LOGGER = Logger.getLogger(AuthenticationController.class);
	
	@GetMapping("login")
	public String goToLoginPage(Model model) {
		return "login";
	}
	
	@PostMapping("login")
	public String login(@ModelAttribute("loginModel") LoginModel loginModel, Model model) {
		
		LOGGER.info("Login with " + loginModel);
		
		return "redirect:/home";
	}
}
