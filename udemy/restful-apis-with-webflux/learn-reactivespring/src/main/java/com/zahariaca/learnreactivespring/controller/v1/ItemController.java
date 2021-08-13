package com.zahariaca.learnreactivespring.controller.v1;

import com.zahariaca.learnreactivespring.document.Item;
import com.zahariaca.learnreactivespring.repository.ItemReactiveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.zahariaca.learnreactivespring.constants.ItemConstants.ITEM_END_POINT_V1;
import static org.springframework.http.HttpStatus.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ItemController {
    private final ItemReactiveRepository itemReactiveRepository;

    @GetMapping(ITEM_END_POINT_V1)
    public Flux<Item> getAllItems() {
        return itemReactiveRepository.findAll();
    }

    @GetMapping(ITEM_END_POINT_V1 + "/{id}")
    public Mono<ResponseEntity<Item>> getOneItem(@PathVariable String id) {
        return itemReactiveRepository.findById(id)
                .map(item -> new ResponseEntity<>(item, OK))
                .defaultIfEmpty(new ResponseEntity<>(NOT_FOUND));
    }

    @GetMapping(ITEM_END_POINT_V1 + "/runtimeException")
    public Flux<Item> runtimeException() {
        return itemReactiveRepository.findAll()
                .concatWith(Mono.error(new RuntimeException("RuntimeException occurred")));
    }

    @PostMapping(ITEM_END_POINT_V1)
    @ResponseStatus(CREATED)
    public Mono<Item> createItem(@RequestBody Item item) {
        return itemReactiveRepository.save(item);
    }

    @DeleteMapping(ITEM_END_POINT_V1 + "/{id}")
    public Mono<Void> deleteItem(@PathVariable String id) {
        return itemReactiveRepository.deleteById(id);
    }

    // id and item to be updated in the req = path variable and request body
    // using the id get the item from the database
    // update the item retrieved with the value from the request body
    // save the item
    // return the saved item
    @PutMapping(ITEM_END_POINT_V1 + "/{id}")
    public Mono<ResponseEntity<Item>> updateItem(@PathVariable String id, @RequestBody Item item) {
        return itemReactiveRepository.findById(id)
                .flatMap(currentItem -> {
                    currentItem.setPrice(item.getPrice());
                    currentItem.setDescription(item.getDescription());
                    return itemReactiveRepository.save(currentItem);
                })
                .map(updatedItem -> new ResponseEntity<>(updatedItem, OK))
                .defaultIfEmpty(new ResponseEntity<>(NOT_FOUND));
    }
}
