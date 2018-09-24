package com.zahariaca.springdemo.annotations.activity7;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.zahariaca.springdemo.annotations.activity7")
@PropertySource("sports.properties")
public class ActivityConfig {

}
