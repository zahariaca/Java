package com.zahariaca.eurekaclient;

import org.springframework.web.bind.annotation.RequestMapping;

public interface GreetingController {
    @RequestMapping("/greeting")
    String greeting();
}
