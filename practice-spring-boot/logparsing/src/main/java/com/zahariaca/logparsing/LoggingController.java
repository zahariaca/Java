package com.zahariaca.logparsing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zaharia Costin-Alexandru (zaharia.c.alexandru@gmail.com) on 23.05.2019
 */
@RestController
public class LoggingController {
    Logger logger = LoggerFactory.getLogger("jsonLogger");

    @RequestMapping("/test")
    public String test(){
        logger.debug("Debug message");
        return "Test";
    }

    @RequestMapping("/exception")
    public String ex(){
        try {
            throw new NullPointerException("MEGA NULL POINTER!");
        } catch (NullPointerException e) {
            logger.debug(">E: ", e);
        }
        return "Ex";
    }
}
