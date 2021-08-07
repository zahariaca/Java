package com.zahariaca.learnreactivespring.fluxandmonoplayground;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class ColdAndHotPublisherTest {

    @SneakyThrows
    @Test
    void coldPublisherTest() {
        Flux<String> stringFlux = Flux.just("A", "B", "C", "D", "E", "F")
                .delayElements(Duration.ofSeconds(1))
                .log();

        stringFlux.subscribe(s -> System.out.println("Subscriber 1: " + s));

        Thread.sleep(2000);

        stringFlux.subscribe(s -> System.out.println("Subscriber 2: " + s));

        Thread.sleep(4000);
    }

    @SneakyThrows
    @Test
    void hotPublisherTest() {
        Flux<String> stringFlux = Flux.just("A", "B", "C", "D", "E", "F")
                .delayElements(Duration.ofSeconds(1))
                .log();

        ConnectableFlux<String> connectableFlux = stringFlux.publish();
        connectableFlux.connect();
        connectableFlux.subscribe(s -> System.out.println("Subscriber 1: " + s));

        Thread.sleep(3000);

        connectableFlux.subscribe(s -> System.out.println("Subscriber 2: " + s));

        Thread.sleep(4000);
    }
}
