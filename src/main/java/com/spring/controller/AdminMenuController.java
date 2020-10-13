package com.spring.controller;

import com.spring.entity.MenuEntity;
import com.spring.service.AdminService;
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
@RequestMapping("/adminMenu")
public class AdminMenuController {
    @Autowired
    private AdminService<MenuEntity> adminMenuService;
    private static final Logger LOGGER = Logger.getLogger(AdminMenuController.class);


    @GetMapping("")
    public String listAllFoods(Model model) {
        LOGGER.info("Fetch list of foods");
        List<MenuEntity> foodList = adminMenuService.fetchAll();
        LOGGER.info("Pass food list to ModelAttribute");
        model.addAttribute("foodList", foodList);
        return "adminMenu";
    }

    @GetMapping("edit")
    public String editFoodForm(Model model, int menuId) {
        LOGGER.info("Get food with id: " + menuId);
        MenuEntity updatingDish = adminMenuService.getById(menuId);
        LOGGER.info("Pass food to ModelAttribute");
        model.addAttribute("updatingDish", updatingDish);
        return "adminMenuEditing";
    }

    @PostMapping("edit")
    public String editFood(@ModelAttribute("updatingDish") MenuEntity food, int menuId) {
        LOGGER.info("Updating food with id: " + menuId);
        adminMenuService.updateExistEntity(food);
        return "redirect:/adminMenu";
    }

    @GetMapping("delete")
    public String deleteFood(int menuId) {
        LOGGER.info("Delete food with id: " + menuId);
        adminMenuService.deleteEntity(menuId);
        return "redirect:/adminMenu";
    }
}
