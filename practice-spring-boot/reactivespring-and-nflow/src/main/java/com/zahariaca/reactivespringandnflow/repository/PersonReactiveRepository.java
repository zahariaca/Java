package com.zahariaca.reactivespringandnflow.repository;

import com.zahariaca.reactivespringandnflow.document.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PersonReactiveRepository extends ReactiveMongoRepository<Person, String> {
}
