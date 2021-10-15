package com.zahariaca.reactivespringandnflow.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "test")
@Data
public class TestProperties {
    private Map<String, String> application;
    private Map<String, List<String>> config;
    private Map<String, Credential> users;
    private Map<String, Map<String, String>> testMap;
    private Map<String, TestObject> testMap2;
    private TestObject testObject;

    // getters and setters

    public static class Credential {

        private String username;
        private String password;

        // getters and setters

    }
}
