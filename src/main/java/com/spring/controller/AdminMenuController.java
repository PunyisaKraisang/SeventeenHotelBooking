package com.spring.controller;

import com.spring.entity.MenuEntity;
import com.spring.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/adminMenu")
public class AdminMenuController {
    @Autowired
    private AdminMenuService adminMenuService;

    @GetMapping("")
    public String listAllFoods(Model model) {
        List<MenuEntity> foodList = adminMenuService.listAllFoods();
        model.addAttribute("foodList", foodList);
        return "adminMenu";
    }

    @GetMapping("edit")
    public String editFood() {
        return "adminMenuEditing";
    }

    @GetMapping("delete")
    public String deleteFood(int menuId) {
        adminMenuService.deleteFood(menuId);
        return "redirect:/adminMenu";
    }
}
