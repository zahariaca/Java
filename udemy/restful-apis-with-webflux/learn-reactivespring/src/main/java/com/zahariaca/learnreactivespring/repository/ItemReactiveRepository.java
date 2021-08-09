package com.zahariaca.learnreactivespring.repository;

import com.zahariaca.learnreactivespring.document.Item;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ItemReactiveRepository extends ReactiveMongoRepository<Item, String> {
}
