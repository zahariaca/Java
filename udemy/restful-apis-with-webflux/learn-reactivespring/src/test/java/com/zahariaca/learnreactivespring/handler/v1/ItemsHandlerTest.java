package com.zahariaca.learnreactivespring.handler.v1;

import com.zahariaca.learnreactivespring.document.Item;
import com.zahariaca.learnreactivespring.repository.ItemReactiveRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static com.zahariaca.learnreactivespring.constants.ItemConstants.ITEM_END_POINT_V1;
import static com.zahariaca.learnreactivespring.constants.ItemConstants.ITEM_FUNCTIONAL_END_POINT_V1;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient
@ActiveProfiles("test")
class ItemsHandlerTest {

    @Autowired
    WebTestClient webTestClient;
    @Autowired
    ItemReactiveRepository itemReactiveRepository;

    @BeforeEach
    void setUp() {
        itemReactiveRepository.deleteAll()
                .thenMany(Flux.fromIterable(data()))
                .flatMap(itemReactiveRepository::save)
                .doOnNext(item -> System.out.println("Inserted item is: " + item))
                .blockLast();
    }

    public List<Item> data() {
        return List.of(
                new Item(null, "Samsung TV", 400.0),
                new Item(null, "LG TV", 420.0),
                new Item(null, "Apple Watch", 299.99),
                new Item(null, "Beats Headphones", 149.99),
                new Item("ABC", "Bose Headphones", 149.99)
        );
    }

    @Test
    void getAllItems() {
        webTestClient.get().uri(ITEM_FUNCTIONAL_END_POINT_V1)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(APPLICATION_JSON)
                .expectBodyList(Item.class)
                .hasSize(5);
    }

    @Test
    void getAllItems_approach2() {
        webTestClient.get().uri(ITEM_FUNCTIONAL_END_POINT_V1)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(APPLICATION_JSON)
                .expectBodyList(Item.class)
                .hasSize(5)
                .consumeWith(response -> {
                    List<Item> items = response.getResponseBody();
                    assert items != null;
                    items.forEach(item -> assertNotNull(item.getId()));
                });
    }

    @Test
    void getAllItems_approach3() {
        Flux<Item> itemsFlux = webTestClient.get().uri(ITEM_FUNCTIONAL_END_POINT_V1)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(APPLICATION_JSON)
                .returnResult(Item.class)
                .getResponseBody();

        StepVerifier.create(itemsFlux.log("value from network: "))
                .expectSubscription()
                .expectNextCount(5)
                .verifyComplete();
    }

    @Test
    void getOneItem() {
        webTestClient.get().uri(ITEM_FUNCTIONAL_END_POINT_V1.concat("/{id}"), "ABC")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.price", 149.99);
    }

    @Test
    void getOneItem_notFound() {
        webTestClient.get().uri(ITEM_END_POINT_V1.concat("/{id}"), "XXX")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void createItem() {
        Item item = new Item(null, "Iphone X", 999.99);
        webTestClient.post().uri(ITEM_FUNCTIONAL_END_POINT_V1)
                .contentType(APPLICATION_JSON)
                .body(Mono.just(item), Item.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isNotEmpty()
                .jsonPath("$.description").isEqualTo("Iphone X")
                .jsonPath("$.price").isEqualTo(999.99);
    }

    @Test
    void deleteItem() {
        webTestClient.delete().uri(ITEM_FUNCTIONAL_END_POINT_V1.concat("/{id}"), "ABC")
                .accept(APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Void.class);
    }

    @Test
    void updateItem() {
        double newPrice = 139.99;
        Item item = new Item("ABC", "Bose Headphones", newPrice);
        webTestClient.put().uri(ITEM_FUNCTIONAL_END_POINT_V1.concat("/{id}"), "ABC")
                .contentType(APPLICATION_JSON)
                .body(Mono.just(item), Item.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.price").isEqualTo(newPrice);
    }

    @Test
    void updateItem_notFound() {
        double newPrice = 139.99;
        Item item = new Item("ABC", "Bose Headphones", newPrice);
        webTestClient.put().uri(ITEM_FUNCTIONAL_END_POINT_V1.concat("/{id}"), "XXX")
                .contentType(APPLICATION_JSON)
                .body(Mono.just(item), Item.class)
                .exchange()
                .expectStatus().isNotFound();
    }

}