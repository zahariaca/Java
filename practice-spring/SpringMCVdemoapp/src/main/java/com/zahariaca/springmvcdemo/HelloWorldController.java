package com.zahariaca.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Alex on 04.07.2017.
 */
@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    // controller method to show the initial form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    // controller method to process the form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    // new controller method to read form data and
    // add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");
        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String message = "Yo! " + theName;

        //add message to model
        model.addAttribute("message", message);

        return "helloworld";
    }

    // We use the @RequestParam to bind the data from the HTML form
    // in the field "studentName" to the String variable "theName"
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model){

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String message = "Hello " + theName + " from .v3! ";

        //add message to model
        model.addAttribute("message", message);

        return "helloworld";
    }

}
