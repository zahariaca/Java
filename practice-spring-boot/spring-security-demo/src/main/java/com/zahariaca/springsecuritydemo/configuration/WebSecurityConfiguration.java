package com.zahariaca.springsecuritydemo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 02.06.2019
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder builder = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(builder.username("john").password("test123").roles("EMPLOYEE"))
                .withUser(builder.username("mary").password("test123").roles("MANAGER"))
                .withUser(builder.username("susan").password("test123").roles("ADMIN"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authenticationProvider()
    }
}
