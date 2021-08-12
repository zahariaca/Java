package com.zahariaca.learnreactivespring.repository;

import com.zahariaca.learnreactivespring.document.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class ItemReactiveRepositoryTest {
    @Autowired
    ItemReactiveRepository itemReactiveRepository;
    List<Item> itemList = List.of(
            new Item(null, "Samsung TV", 400.0),
            new Item(null, "LG TV", 420.0),
            new Item(null, "Apple Watch", 299.99),
            new Item(null, "Beats Headphones", 149.99),
            new Item("ABC", "Bose Headphones", 149.99)
    );

    @BeforeEach
    public void setUp() {
        itemReactiveRepository.deleteAll()
                .thenMany(Flux.fromIterable(itemList))
                .flatMap(itemReactiveRepository::save)
                .doOnNext(item -> System.out.println("Inserted item is: " + item))
                .blockLast();
    }

    @Test
    void getAllItems() {
        StepVerifier.create(itemReactiveRepository.findAll().log())
                .expectSubscription()
                .expectNextCount(5)
                .verifyComplete();
    }

    @Test
    void getItemById() {
        StepVerifier.create(itemReactiveRepository.findById("ABC").log())
                .expectSubscription()
                .expectNextMatches(item -> item.getDescription().equals("Bose Headphones"))
                .verifyComplete();
    }

    @Test
    void getItemByDescription() {
        StepVerifier.create(itemReactiveRepository.findByDescription("Apple Watch").log("findItemByDescription: "))
                .expectSubscription()
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void saveItem() {
        Item item = new Item(null, "Google Mini Home", 30.0);
        Mono<Item> savedItem = itemReactiveRepository.save(item);

        StepVerifier.create(savedItem.log())
                .expectSubscription()
                .expectNextMatches(item1 -> item1.getId() != null && item1.getDescription().equals("Google Mini Home"))
                .verifyComplete();
    }

    @Test
    void updateItem() {
        double newPrice = 520.00;
        Mono<Item> updatedItem = itemReactiveRepository.findByDescription("LG TV")
                .map(item -> {
                    item.setPrice(newPrice); // setting the new price
                    return item;
                })
                .flatMap(item -> itemReactiveRepository.save(item)); // saving the updated item

        StepVerifier.create(updatedItem)
                .expectSubscription()
                .expectNextMatches(item -> item.getPrice() == newPrice)
                .verifyComplete();
    }

    @Test
    void deleteItemById() {
        Mono<Void> deletedItem = itemReactiveRepository.findById("ABC")// Mono<Item>
                .map(Item::getId) // Transform from one type to another Item -> String
                .flatMap(id -> {
                    return itemReactiveRepository.deleteById(id);
                });

        StepVerifier.create(deletedItem.log())
                .expectSubscription()
                .verifyComplete();

        StepVerifier.create(itemReactiveRepository.findAll().log())
                .expectSubscription()
                .expectNextCount(4)
                .verifyComplete();
    }

    @Test
    void deleteItem() {
        Mono<Void> deletedItem = itemReactiveRepository.findByDescription("LG TV")// Mono<Item>
                .flatMap(item -> {
                    return itemReactiveRepository.delete(item);
                });

        StepVerifier.create(deletedItem.log())
                .expectSubscription()
                .verifyComplete();

        StepVerifier.create(itemReactiveRepository.findAll().log())
                .expectSubscription()
                .expectNextCount(4)
                .verifyComplete();
    }
}