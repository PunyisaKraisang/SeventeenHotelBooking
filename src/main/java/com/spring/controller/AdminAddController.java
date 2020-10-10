package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/adminAdd")
public class AdminAddController {

    @GetMapping("")
    public String addForms() {
        return "adminAdd";
    }

    @PostMapping("addRoom")
    @ResponseBody
    public String addRoom() {
        return "add room...";
    }

    @PostMapping("addFood")
    @ResponseBody
    public String addFood() {
        return "add room...";
    }
}
