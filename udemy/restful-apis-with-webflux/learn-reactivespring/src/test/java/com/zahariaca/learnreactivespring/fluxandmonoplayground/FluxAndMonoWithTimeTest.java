package com.zahariaca.learnreactivespring.fluxandmonoplayground;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class FluxAndMonoWithTimeTest {

    @SneakyThrows
    @Test
    void infiniteSequence() {
        Flux<Long> infiniteFlux = Flux.interval(Duration.ofMillis(200))
                .log();

        infiniteFlux.subscribe(aLong -> System.out.println("Value is: " + aLong));

        Thread.sleep(3000);
    }

    @SneakyThrows
    @Test
    void infiniteSequenceTest() {
        Flux<Long> finiteFlux = Flux.interval(Duration.ofMillis(200))
                .take(3)
                .log();

        StepVerifier.create(finiteFlux)
                .expectSubscription()
                .expectNext(0L, 1L, 2L)
                .verifyComplete();
    }

    @SneakyThrows
    @Test
    void infiniteSequenceTest_Map() {
        Flux<Integer> finiteFlux = Flux.interval(Duration.ofMillis(200))
                .map(l -> l.intValue())
                .take(3)
                .log();

        StepVerifier.create(finiteFlux)
                .expectSubscription()
                .expectNext(0, 1, 2)
                .verifyComplete();
    }

    @SneakyThrows
    @Test
    void infiniteSequenceTest_Map_withDelay() {
        Flux<Integer> finiteFlux = Flux.interval(Duration.ofMillis(200))
                .delayElements(Duration.ofSeconds(1))
                .map(l -> l.intValue())
                .take(3)
                .log();

        StepVerifier.create(finiteFlux)
                .expectSubscription()
                .expectNext(0, 1, 2)
                .verifyComplete();
    }
}
