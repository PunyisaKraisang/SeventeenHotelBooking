package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.model.CarModel;
import com.spring.model.SearchCarModel;
import com.spring.service.CarService;

@Controller
@RequestMapping("/car-rental")
public class CarController {

	@Autowired
	CarService carService;
	
	//Access car rental page
	@GetMapping
	public String goToCarRentalPage(@ModelAttribute(name = "searchCarModel") SearchCarModel searchCarModel, Model model) {
		
		List<CarModel> carList = carService.fetchCar(searchCarModel);
		model.addAttribute("carList", carList);
		
		return "car-rental";
	}
	
	//Search car
	@PostMapping
	public String searchCar(@ModelAttribute(name = "searchCarModel") SearchCarModel searchCarModel, Model model) {
		
		List<CarModel> carList = carService.fetchCar(searchCarModel);
		model.addAttribute("carList", carList);
		
		return "car-rental";
	}
	
	//Rent car
    @GetMapping("car-availability")
    public String changeCarAvailabilityController(int carId) {
    	carService.changeCarStatus(carId);
        return "redirect:/car-rental";
    }
	

}
