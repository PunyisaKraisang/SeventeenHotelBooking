package com.spring.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.spring.model.AccountModel;
import com.spring.model.LoginModel;
import com.spring.service.AuthenticationService;


@Controller
@SessionAttributes("accountModel")
public class AuthenticationController {

	private static final Logger LOGGER = Logger.getLogger(AuthenticationController.class);
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@ModelAttribute("accountModel")
	public AccountModel accountModel() {
		return new AccountModel();
	}
	
	@GetMapping("login")
	public String goToLoginPage(Model model) {
		return "login";
	}
	
	@PostMapping("login")
	public String login(
			@ModelAttribute("loginModel") LoginModel loginModel, 
			@ModelAttribute("accountModel") AccountModel accountModel,
			Model model) {
		
		LOGGER.info("Login with " + loginModel);
		AccountModel account = authenticationService.login(loginModel);
		
		if (account == null) {
			LOGGER.info("Login error: username or password does not exist");
			model.addAttribute("error", "Username or password does not exist");
			
			// CLear session
			accountModel.setUsername("");

			return "login";
		}
		
		// Save account in session model
		accountModel.setUsername(account.getUsername());;
		accountModel.setCustomerId(account.getCustomerId());;
		return "redirect:/home";
	}

	@GetMapping("logout")
	public String logout(
			@ModelAttribute("accountModel") AccountModel accountModel, 
			SessionStatus status,
			Model model) {
		
		LOGGER.info("Clear session for " + accountModel);
		status.setComplete();
		
		return "redirect:/home";
	}
}
