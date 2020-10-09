package com.spring.controller;


import com.spring.service.AdminLoginService;
import com.spring.entity.AdminEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    private static final Logger LOGGER = Logger.getLogger(AdminController.class);

    @Autowired
    AdminLoginService adminLoginService;

    @GetMapping("/adminLogin")
    public String adminLogin() {
        return "admin";
    }

    @PostMapping("/adminLogin")
    public String verifyLogin(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        System.out.println("u: " + username + ", p: " + password);
        //AdminEntity admin = adminLoginService.getAdmin(username, password);
        if (!adminLoginService.getAdmin(username, password)) {
            model.addAttribute("adminError", "Invalid Admin Login");
            return "admin";
        }
        session.setAttribute("loggedAdmin", true);
        return "redirect:/hotelStatus/";
    }
}
