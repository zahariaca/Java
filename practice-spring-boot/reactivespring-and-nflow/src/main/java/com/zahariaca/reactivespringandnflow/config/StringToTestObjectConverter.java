package com.zahariaca.reactivespringandnflow.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class StringToTestObjectConverter implements Converter<String, TestObject> {
    @Override
    public TestObject convert(String s) {
        return TestObject.builder()
                .key1(s)
                .build();
    }
}
