/*
package com.zahariaca.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .httpBasic()
          .and()
          .authorizeRequests()
          .antMatchers("/index.html", "/", "/home", "/login").permitAll()
          .anyRequest().authenticated();
    }
}*/
