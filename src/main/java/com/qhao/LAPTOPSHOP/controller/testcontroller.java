package com.qhao.LAPTOPSHOP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qhao.LAPTOPSHOP.service.UserService;

@Controller
public class testcontroller {
    // DI: dependency injection
    private final UserService userService;

    public testcontroller(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/gqh")
    public String testController() {
        return "homepage";
    }
}