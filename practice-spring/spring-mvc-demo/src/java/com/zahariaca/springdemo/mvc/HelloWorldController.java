package com.zahariaca.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        // read the request parameter from HTML form
        String theName = request.getParameter("studentName");

        // convert the data to upper case
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo! " + theName;

        // add the message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
        // convert the data to upper case
        theName = theName.toUpperCase();

        // create the message
        String result = "Hello my friend from V3! " + theName;

        // add the message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }


}
