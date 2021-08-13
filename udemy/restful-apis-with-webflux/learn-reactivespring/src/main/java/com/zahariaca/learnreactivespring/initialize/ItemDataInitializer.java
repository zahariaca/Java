package com.zahariaca.learnreactivespring.initialize;

import com.zahariaca.learnreactivespring.document.Item;
import com.zahariaca.learnreactivespring.document.ItemCapped;
import com.zahariaca.learnreactivespring.repository.ItemCappedReactiveRepository;
import com.zahariaca.learnreactivespring.repository.ItemReactiveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
@Profile("!test")
public class ItemDataInitializer implements CommandLineRunner {

    private final ItemReactiveRepository itemReactiveRepository;
    private final ItemCappedReactiveRepository itemCappedReactiveRepository;
    private final ReactiveMongoOperations mongoOperations;

    @Override
    public void run(String... args) {
        initialDataSetup();
        createCappedCollection();
        dataSetupForCappedCollection();
    }

    private void createCappedCollection() {
        mongoOperations.dropCollection(ItemCapped.class)
                .then(mongoOperations.createCollection(ItemCapped.class, CollectionOptions.empty().capped().maxDocuments(20).size(50000)))
                .subscribe();
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

    private void initialDataSetup() {
        itemReactiveRepository.deleteAll()
                .thenMany(Flux.fromIterable(data()))
                .flatMap(itemReactiveRepository::save)
                .thenMany(itemReactiveRepository.findAll())
                .subscribe(item -> System.out.println("Item inserted from CLR: " + item));
    }

    public void dataSetupForCappedCollection() {
        Flux<ItemCapped> itemCappedFlux = Flux.interval(Duration.ofSeconds(1))
                .map(i -> new ItemCapped(null, "Random Item " + i, 100.00 + i));
        itemCappedReactiveRepository.insert(itemCappedFlux)
                .subscribe(itemCapped -> {
                    log.info("Inserted item is: " + itemCapped);
                });
    }
}
