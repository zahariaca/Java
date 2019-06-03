package com.zahariaca.springsecuritydemo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 03.06.2019
 */
@Controller
public class LoginController{

    @RequestMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "plain-login";
    }

    @RequestMapping("/userAccountInfo")
    public String showUserAccountInfo(Model model, Principal principal) {
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        model.addAttribute("userInfo", userName);
        return "user-page";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "plain-login";
    }

}
