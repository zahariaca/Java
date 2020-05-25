package com.zahariaca.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 02.06.2019
 */
@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

}
