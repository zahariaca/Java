package com.zahariaca.springboot.tutorial.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 12.05.2019
 */
@RestController
public class FunRestController {
    // expose a '/' endpoint and return Hello World

    @GetMapping("/")
    public String sayHello() {
        return "Hello World! Time on server is: " + LocalDateTime.now();
    }

    // expose a new endpoint  for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    // expose a new endpoint  for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day!";
    }
}