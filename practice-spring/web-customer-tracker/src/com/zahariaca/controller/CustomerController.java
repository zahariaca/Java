package com.zahariaca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 10.03.2019
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @RequestMapping("/list")
    public String listCustomers(Model model) {
        return "list-customers";
    }
}
