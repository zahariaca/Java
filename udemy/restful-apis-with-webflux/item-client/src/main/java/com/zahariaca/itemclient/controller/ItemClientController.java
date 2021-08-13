package com.zahariaca.itemclient.controller;

import com.zahariaca.itemclient.domain.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestController
@Slf4j
public class ItemClientController {
    private final WebClient webClient = WebClient.create("http://localhost:8080");

    @GetMapping("/client/retrieve")
    public Flux<Item> getAllItemsUsingRetrieve() {
        return webClient.get().uri("/v1/items/")
                .retrieve()
                .bodyToFlux(Item.class)
                .log("Items in client project -- retrieve: ");
    }

    @GetMapping("/client/exchange")
    public Flux<Item> getAllItemsUsingExchange() {
        return webClient.get().uri("/v1/items/")
                .exchangeToFlux(clientResponse -> clientResponse.bodyToFlux(Item.class))
                .log("Items in client project -- exchange: ");
    }

    @GetMapping("/client/retrieve/singleItem/{id}")
    public Mono<Item> getOneItemUsingRetrieve(@PathVariable String id) {
        return webClient.get().uri("/v1/items/{id}", id)
                .retrieve()
                .bodyToMono(Item.class)
                .log("Items in client project -- retrieve 1 item");
    }

    @PostMapping("/client/createItem")
    public Mono<Item> createItem(@RequestBody Item item) {
        return webClient.post().uri("/v1/items/")
                .contentType(APPLICATION_JSON)
                .body(Mono.just(item), Item.class)
                .retrieve()
                .bodyToMono(Item.class)
                .log("Created item is: ");
    }

    @PutMapping("/client/updateItem/{id}")
    public Mono<Item> updateItem(@PathVariable String id,
                                 @RequestBody Item item) {
        return webClient.put().uri("/v1/items/{id}", id)
                .body(Mono.just(item), Item.class)
                .retrieve()
                .bodyToMono(Item.class)
                .log("Updated item is: ");
    }

    @DeleteMapping("/client/deleteItem/{id}")
    public Mono<Void> deleteItem(@PathVariable String id) {
        return webClient.delete().uri("/v1/items/{id}", id)
                .retrieve()
                .bodyToMono(Void.class)
                .log("Delete item is: ");
    }

    @GetMapping("/client/retrieve/error")
    public Flux<Item> errorRetrieve() {
        return webClient.get().uri("/v1/items/runtimeException")
                .retrieve()
                .onStatus(HttpStatus::is5xxServerError, clientResponse -> {
                    Mono<String> errorMono = clientResponse.bodyToMono(String.class);
                    return errorMono.flatMap(errorMessage -> {
                        log.error("The error message is: " + errorMessage);
                        return Mono.error(new RuntimeException(errorMessage));
                    });
                })
                .bodyToFlux(Item.class);
    }
}
