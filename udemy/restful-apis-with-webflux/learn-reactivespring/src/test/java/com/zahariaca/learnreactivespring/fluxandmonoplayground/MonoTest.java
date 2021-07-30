package com.zahariaca.learnreactivespring.fluxandmonoplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class MonoTest {

    @Test
    void monoTest_WithoutError() {
        Mono<String> stringMono = Mono.just("Spring").log();

        StepVerifier.create(stringMono)
                .expectNext("Spring")
                .verifyComplete();
    }

    @Test
    void monoTest_WithError() {
        StepVerifier.create(Mono.error(new RuntimeException("Exception Occurred")).log())
                .expectErrorMessage("Exception Occurred")
                .verify();
    }
}
