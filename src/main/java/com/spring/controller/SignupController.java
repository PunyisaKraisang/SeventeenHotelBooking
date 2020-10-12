package com.spring.controller;

import com.spring.entity.AccountEntity;
import com.spring.entity.CustomerEntity;
import com.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SignupController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/signup")
    public String signupForm() {
        return "signupProgress";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam Map<String, Object> allParams, Model model) {
        System.out.println("post");
        try {
            customerService.newSignUp(allParams);
            return "redirect:/login";
        } catch (Exception e) {
            System.out.println("error " +  e.getMessage());
            model.addAttribute("signupFail", "Sign up failed, please try again");
            return "signupProgress";
        }
    }

}
