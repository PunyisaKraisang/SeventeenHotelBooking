package com.spring.controller;

import com.spring.entity.CarEntity;
import com.spring.entity.MenuEntity;
import com.spring.entity.RoomEntity;
import com.spring.service.AdminCarService;
import com.spring.service.AdminRoomService;
import com.spring.service.AdminService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/adminAdd")
public class AdminAddController {

    @Autowired
    private AdminRoomService adminRoomService;

    @Autowired
    private AdminCarService adminCarService;

    @Autowired
    private AdminService<MenuEntity> adminMenuService;

    private static final Logger LOGGER = Logger.getLogger(AdminAddController.class);

    @GetMapping("")
    public String addForms(Model model) {
        LOGGER.info("Pass entities to ModelAttribute");
        model.addAttribute("newRoom", new RoomEntity());
        model.addAttribute("newCar", new CarEntity());
        model.addAttribute("newDish", new MenuEntity());
        return "adminAdd";
    }

    @GetMapping("addRoom")
    public String addRoomForm(@ModelAttribute("newRoom") RoomEntity room) {
        return "adminAdd";
    }

    @PostMapping("addRoom")
    public String addRoom(@ModelAttribute("newRoom") RoomEntity room, Model model) {
        LOGGER.info("Adding a new room: " + room);
        adminRoomService.saveNewEntity(room);
        return "redirect:/adminRoom";
    }

    @GetMapping("addCar")
    public String addCarForm(@ModelAttribute("newCar") CarEntity car) { return "adminAdd"; }

    @PostMapping("addCar")
    public String addCar(@ModelAttribute("newCar") CarEntity car) {
        LOGGER.info("Adding a new Car: " + car);
        adminCarService.saveNewEntity(car);
        return "redirect:/adminCar";
    }

    @GetMapping("addFood")
    public String addFoodForm(@ModelAttribute("newDish") MenuEntity food) { return "adminAdd"; }

    @PostMapping("addFood")
    public String addFood(@ModelAttribute("newDish") MenuEntity food) {
        LOGGER.info("Adding a new dish: " + food);
        adminMenuService.saveNewEntity(food);
        return "redirect:/adminMenu";
    }
}
