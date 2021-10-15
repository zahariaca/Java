package com.zahariaca.reactivespringandnflow.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationPropertiesBinding
public class MapToTestObjectConverter implements Converter<Map<String, String>, TestObject> {
    @Override
    public TestObject convert(Map<String, String> stringStringMap) {
        return TestObject.builder()
                .key1(stringStringMap.get("key1"))
                .key2(stringStringMap.get("key2"))
                .key3(stringStringMap.get("key3"))
                .build();
    }
}
