package com.zahariaca.learnreactivespring.initialize;

import com.zahariaca.learnreactivespring.document.Item;
import com.zahariaca.learnreactivespring.repository.ItemReactiveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
@Profile("!test")
public class ItemDataInitializer implements CommandLineRunner {

    private final ItemReactiveRepository itemReactiveRepository;

    @Override
    public void run(String... args) throws Exception {
        initalDataSetup();
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

    private void initalDataSetup() {
        itemReactiveRepository.deleteAll()
                .thenMany(Flux.fromIterable(data()))
                .flatMap(itemReactiveRepository::save)
                .thenMany(itemReactiveRepository.findAll())
                .subscribe(item -> System.out.println("Item inserted from CLR: " + item));
    }
}
