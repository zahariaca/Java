package com.zahariaca.reactivespringandnflow;

import io.nflow.rest.config.RestConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({RestConfiguration.class})
@EnableAspectJAutoProxy
public class ReactivespringAndNflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactivespringAndNflowApplication.class, args);
    }

}
