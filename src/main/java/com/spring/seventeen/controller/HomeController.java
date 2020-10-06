package com.spring.seventeen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String goToLandingPage() {
		return "home";
	}
	
	@GetMapping("/home")
	public String goToHomePage() {
		return "home";
	}
	
	@GetMapping("/admin")
	public String goToAdminPage() {
		return "admin";
	}
}
