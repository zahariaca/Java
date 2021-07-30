package com.zahariaca.learnreactivespring.fluxandmonoplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class FluxAndMonoFactoryTest {

    @Test
    void fluxUsingIterable() {
        List<String> names = Arrays.asList("adam", "anna", "jack", "jenny");
        Flux<String> namesFlux = Flux.fromIterable(names).log();

        StepVerifier.create(namesFlux)
                .expectNext("adam", "anna", "jack", "jenny")
                .verifyComplete();

    }

    @Test
    void fluxUsingArray() {
        String[] names = new String[]{"adam", "anna", "jack", "jenny"};
        Flux<String> namesFlux = Flux.fromArray(names).log();

        StepVerifier.create(namesFlux)
                .expectNext("adam", "anna", "jack", "jenny")
                .verifyComplete();
    }

    @Test
    void fluxUsingStream() {
        List<String> names = Arrays.asList("adam", "anna", "jack", "jenny");
        Flux<String> namesFlux = Flux.fromStream(names.stream()).log();

        StepVerifier.create(namesFlux)
                .expectNext("adam", "anna", "jack", "jenny")
                .verifyComplete();

    }

    @Test
    void monoUsingJustOrEmpty() {
        Mono<String> stringMono = Mono.justOrEmpty(null); // Mono.empty()

        StepVerifier.create(stringMono.log())
                .verifyComplete();
    }

    @Test
    void monoUsingSupplier() {
        Supplier<String> stringSupplier = () -> "adam";
        Mono<String> stringMono = Mono.fromSupplier(stringSupplier);

        StepVerifier.create(stringMono.log())
                .expectNext("adam")
                .verifyComplete();
    }

    @Test
    void fluxUsingRange() {
        Flux<Integer> integerFlux = Flux.range(1, 5).log();

        StepVerifier.create(integerFlux)
                .expectNext(1, 2, 3, 4, 5)
                .verifyComplete();
    }
}
