package com.zahariaca.learnreactivespring.fluxandmonoplayground;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static reactor.core.scheduler.Schedulers.parallel;

public class FluxAndMonoTransformTest {
    List<String> names = Arrays.asList("adam", "anna", "jack", "jenny");

    @Test
    void transformUsingMap() {
        Flux<String> namesFlux = Flux.fromIterable(names)
                .map(s -> s.toUpperCase(Locale.ROOT))
                .log();

        StepVerifier.create(namesFlux)
                .expectNext("ADAM", "ANNA", "JACK", "JENNY")
                .verifyComplete();
    }

    @Test
    void transformUsingMap_Length_repeat() {
        Flux<Integer> namesFlux = Flux.fromIterable(names)
                .map(String::length)
                .repeat(1)
                .log();

        StepVerifier.create(namesFlux)
                .expectNext(4, 4, 4, 5, 4, 4, 4, 5)
                .verifyComplete();
    }

    @Test
    void transformUsingMap_Filter() {
        Flux<String> namesFlux = Flux.fromIterable(names)
                .filter(s -> s.length() > 4)
                .map(s -> s.toUpperCase(Locale.ROOT))
                .log();

        StepVerifier.create(namesFlux)
                .expectNext("JENNY")
                .verifyComplete();
    }

    @Test
    void transformUsingFlatMap() {
        Flux<String> namesFlux = Flux.fromIterable(Arrays.asList("A", "B", "C", "D", "E", "F"))
                .flatMap(s -> {
                    return Flux.fromIterable(converToList(s));
                }) // db or external service cal that return a flux -> s -> Flux<String>
                .log();

        StepVerifier.create(namesFlux)
                .expectNextCount(12)
                .verifyComplete();
    }

    @SneakyThrows
    private List<String> converToList(String s) {
        Thread.sleep(1000);
        return Arrays.asList(s, "newValue");
    }

    @Test
    void transformUsingFlatMap_usingParallel() {
        Flux<String> namesFlux = Flux.fromIterable(Arrays.asList("A", "B", "C", "D", "E", "F"))
                .window(2) // Flux<Flux<String> -> (A,B) (C,D)..
                .flatMap(s -> s.map(this::converToList).subscribeOn(parallel())) // Flux<List<String>>
                .flatMap(s -> Flux.fromIterable(s)) // Flux<String>
                .log();

        StepVerifier.create(namesFlux)
                .expectNextCount(12)
                .verifyComplete();
    }

    @Test
    void transformUsingFlatMap_usingParallel_maintain_order() {
        Flux<String> namesFlux = Flux.fromIterable(Arrays.asList("A", "B", "C", "D", "E", "F"))
                .window(2) // Flux<Flux<String> -> (A,B) (C,D)..
//                .concatMap(s -> s.map(this::converToList).subscribeOn(parallel())) // Flux<List<String>> -- like flatMap but maintains order
                .flatMapSequential(s -> s.map(this::converToList).subscribeOn(parallel())) // Flux<List<String>> -- like flatMap but maintains order
                .flatMap(s -> Flux.fromIterable(s)) // Flux<String>
                .log();

        StepVerifier.create(namesFlux)
                .expectNextCount(12)
                .verifyComplete();
    }
}
