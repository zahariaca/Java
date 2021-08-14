package com.zahariaca.learnreactivespring.handler.v1;

import com.zahariaca.learnreactivespring.constants.ItemConstants;
import com.zahariaca.learnreactivespring.document.ItemCapped;
import com.zahariaca.learnreactivespring.repository.ItemCappedReactiveRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient
@ActiveProfiles("test")
@Slf4j
class ItemsCappedHandlerTest {

    @Autowired
    WebTestClient webTestClient;
    @Autowired
    ItemCappedReactiveRepository itemCappedReactiveRepository;
    @Autowired
    ReactiveMongoOperations mongoOperations;

    @BeforeEach
    void setUp() {
        mongoOperations.dropCollection(ItemCapped.class)
                .then(mongoOperations.createCollection(ItemCapped.class, CollectionOptions.empty().capped().maxDocuments(20).size(50000)))
                .subscribe();
        Flux<ItemCapped> itemCappedFlux = Flux.interval(Duration.ofSeconds(1))
                .map(i -> new ItemCapped(null, "Random Item " + i, 100.00 + i))
                .take(5);
        itemCappedReactiveRepository.insert(itemCappedFlux)
                .doOnNext(itemCapped -> {
                    log.info("Inserted item is: " + itemCapped);
                })
                .blockLast();
    }

    @Test
    void testStreamAllItems() {
        Flux<ItemCapped> itemCappedFlux = webTestClient.get().uri(ItemConstants.ITEM_STREAM_FUNCTIONAL_END_POINT_V1)
                .exchange()
                .expectStatus().isOk()
                .returnResult(ItemCapped.class)
                .getResponseBody()
                .take(5);

        StepVerifier.create(itemCappedFlux)
                .expectSubscription()
                .expectNextCount(5)
                .verifyComplete();
    }

}