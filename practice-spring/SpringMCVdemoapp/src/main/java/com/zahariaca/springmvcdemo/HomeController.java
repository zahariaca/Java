package com.zahariaca.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Alex on 02.07.2017.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String showPage(){
        return "main-menu";
    }
}
