package com.spring.controller;

import com.spring.entity.CarEntity;
import com.spring.service.AdminCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/adminCar")
public class AdminCarController {
    @Autowired
    private AdminCarService adminCarService;

    @GetMapping("")
    public String listCar(Model model) {
        List<CarEntity> cars = adminCarService.listAllCars();
        model.addAttribute("carList", cars);
        return "adminCar";
    }

    @GetMapping("edit")
    public String changeCarAvailability(int carId) {
        adminCarService.changeCarStatus(carId);
        return "redirect:/adminCar";
    }

    @GetMapping("delete")
    public String deleteCar(int carId) {
        adminCarService.deleteCar(carId);
        return "redirect:/adminCar";
    }
}
