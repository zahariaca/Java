package org.zahariaca.springmodulithdemo;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

public class ModularityTest {
    @Test
    void verifyModularity() {
        ApplicationModules.of(SpringModulithDemoApplication.class).verify();
    }
}
