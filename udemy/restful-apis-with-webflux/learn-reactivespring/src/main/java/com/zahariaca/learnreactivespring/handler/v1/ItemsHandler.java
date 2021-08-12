package com.zahariaca.learnreactivespring.handler.v1;

import com.zahariaca.learnreactivespring.document.Item;
import com.zahariaca.learnreactivespring.repository.ItemReactiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
@RequiredArgsConstructor
public class ItemsHandler {
    private final ItemReactiveRepository itemReactiveRepository;
    private final Mono<ServerResponse> notFound = ServerResponse.notFound().build();

    public Mono<ServerResponse> getAllItems(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(itemReactiveRepository.findAll(), Item.class);
    }

    public Mono<ServerResponse> getOneItem(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        // also works like this...
//        return ServerResponse.ok()
//                .contentType(APPLICATION_JSON)
//                .body(itemReactiveRepository.findById(id), Item.class)
//                .switchIfEmpty(notFound);;

        Mono<Item> itemMono = itemReactiveRepository.findById(id);
        return itemMono.flatMap(item ->
                        ServerResponse.ok()
                                .contentType(APPLICATION_JSON)
                                .bodyValue(item))
                .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> createItem(ServerRequest serverRequest) {
        Mono<Item> itemToBeInserted = serverRequest.bodyToMono(Item.class);

        return itemToBeInserted.flatMap(item ->
                ServerResponse.ok()
                        .contentType(APPLICATION_JSON)
                        .body(itemReactiveRepository.save(item), Item.class));
    }

    public Mono<ServerResponse> deleteItem(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        Mono<Void> deletedItem = itemReactiveRepository.deleteById(id);

        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(deletedItem, Void.class);
    }

    public Mono<ServerResponse> updateItem(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");

        Mono<Item> updatedItem = serverRequest.bodyToMono(Item.class).flatMap(item -> {
            Mono<Item> itemMono = itemReactiveRepository.findById(id)
                    .flatMap(currentItem -> {
                        currentItem.setDescription(item.getDescription());
                        currentItem.setPrice(item.getPrice());
                        return itemReactiveRepository.save(currentItem);
                    });
            return itemMono;
        });

        return updatedItem.flatMap(item ->
                        ServerResponse.ok()
                                .contentType(APPLICATION_JSON)
                                .bodyValue(item))
                .switchIfEmpty(notFound);
    }
}
