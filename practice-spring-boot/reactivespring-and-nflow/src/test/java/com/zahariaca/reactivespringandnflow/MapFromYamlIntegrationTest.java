package com.zahariaca.reactivespringandnflow;

import com.zahariaca.reactivespringandnflow.config.TestProperties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MapFromYamlIntegrationTest {

    @Autowired
    private TestProperties serverProperties;

    @Test
    public void whenYamlFileProvidedThenInjectSimpleMap() {
        assertThat(serverProperties.getApplication())
                .containsOnlyKeys("name", "url", "description");

        assertThat(serverProperties.getApplication()
                .get("name")).isEqualTo("InjectMapFromYAML");
    }
}