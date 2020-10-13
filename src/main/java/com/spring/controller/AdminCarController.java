package com.spring.controller;

import com.spring.entity.CarEntity;
import com.spring.service.AdminCarService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/adminCar")
public class AdminCarController {
    @Autowired
    private AdminCarService adminCarService;
    private static final Logger LOGGER = Logger.getLogger(AdminCarController.class);

    @GetMapping("")
    public String listCar(Model model) {
        LOGGER.info("Get list of all cars");
        List<CarEntity> cars = adminCarService.fetchAll();
        model.addAttribute("carList", cars);
        return "adminCar";
    }

    @GetMapping("availability")
    public String changeCarAvailability(int carId) {
        LOGGER.info("Change availability of car with id: " + carId);
        adminCarService.changeCarStatus(carId);
        return "redirect:/adminCar";
    }

    @GetMapping("edit")
    public String editCarInfo(Model model, int carId) {
        LOGGER.info("Get car with id: " + carId);
        CarEntity updatingCar = adminCarService.getById(carId);
        LOGGER.info("Pass car entity to ModelAttribute");
        model.addAttribute("updatingCar", updatingCar);
        return "adminCarEditing";
    }

    @PostMapping("edit")
    public String editCar(@ModelAttribute("updatingCar") CarEntity car) {
        LOGGER.info("Updating car information");
        adminCarService.updateExistEntity(car);
        return "redirect:/adminCar";
    }

    @GetMapping("delete")
    public String deleteCar(int carId) {
        LOGGER.info("Delete car entity with id: " + carId);
        adminCarService.deleteEntity(carId);
        return "redirect:/adminCar";
    }
}
