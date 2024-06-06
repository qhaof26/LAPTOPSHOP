package com.qhao.LAPTOPSHOP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qhao.LAPTOPSHOP.domain.User;

@Controller
public class UserController {
    // default method GET
    // admin request create user -> Controller(userpage.jsp) -> action: home
    @RequestMapping(value = "/admin/user")
    public String createUser(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/userpage";
    }

    @RequestMapping(value = "/homepage", method = RequestMethod.POST)
    public String result(@ModelAttribute("newUser") User user) {
        System.out.println("user " + user.toString());
        return "homepage";
    }
}
