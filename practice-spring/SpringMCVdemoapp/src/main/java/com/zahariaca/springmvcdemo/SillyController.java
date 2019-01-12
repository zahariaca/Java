package com.zahariaca.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Alex on 09.07.2017.
 */
@Controller
public class SillyController {

    @RequestMapping("/showForm")
    public String displayForm(){
        return "silly";
    }

}
