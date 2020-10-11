package com.spring.controller;

import com.spring.entity.CarEntity;
import com.spring.entity.MenuEntity;
import com.spring.entity.RoomEntity;
import com.spring.service.AdminCarService;
import com.spring.service.AdminMenuService;
import com.spring.service.AdminRoomService;
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
    private AdminMenuService adminMenuService;

    @GetMapping("")
    public String addForms(Model model) {
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
        //model.addAttribute("newRoom", new RoomEntity());
        adminRoomService.saveUpdateRoom(room);
        return "redirect:/adminRoom";
    }

    @GetMapping("addCar")
    public String addCarForm(@ModelAttribute("newCar") CarEntity car) { return "adminAdd"; }

    @PostMapping("addCar")
    public String addCar(@ModelAttribute("newCar") CarEntity car) {
        adminCarService.saveUpdateCar(car);
        return "redirect:/adminCar";
    }

    @GetMapping("addFood")
    public String addFoodForm(@ModelAttribute("newDish") MenuEntity food) { return "adminAdd"; }

    @PostMapping("addFood")
    public String addFood(@ModelAttribute("newDish") MenuEntity food) {
        adminMenuService.saveUpdateFood(food);
        return "redirect:/adminMenu";
    }
}
