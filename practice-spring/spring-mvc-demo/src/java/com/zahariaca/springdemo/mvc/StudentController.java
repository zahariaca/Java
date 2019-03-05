package com.zahariaca.springdemo.mvc;

import com.zahariaca.springdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    // populate countryOptions from .properties file
    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @Value("#{languageOptions}")
    private Map<String, String> languageOptions;

    @RequestMapping("/showForm")
    public String showForm(Model theModel) {

        // create a student object
        Student theStudent = new Student();

        // add the Student object as model attribute
        theModel.addAttribute("student", theStudent);

        // add the country options to the model attributes
        theModel.addAttribute("theCountryOptions", countryOptions);

        // add the language options to the model attributes
        theModel.addAttribute("languageOptions", languageOptions);

        return "student-form";
    }

    @RequestMapping("processForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        // log the input data
        System.out.println("The Student: " + theStudent);


        return "student-confirmation";
    }

}
