package com.zahariaca.reactivespringandnflow.repository;

import com.zahariaca.reactivespringandnflow.document.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class PersonInitializer implements CommandLineRunner {
    private final PersonReactiveRepository personReactiveRepository;

    @Override
    public void run(String... args) throws Exception {
        initialDataSetup();
    }

    private void initialDataSetup() {
        personReactiveRepository.deleteAll()
                .thenMany(Flux.fromIterable(data()))
                .flatMap(personReactiveRepository::save)
                .thenMany(personReactiveRepository.findAll())
                .subscribe(person -> System.out.println("Person inserted from CLR: " + person));
    }

    private List<Person> data() {
        return List.of(
                new Person(null, "Alexandru", "Zaharia", 29),
                new Person(null, "Alexandru", "Cristocea", 30),
                new Person(null, "John", "Doe", 45),
                new Person(null, "Jane", "Doe", 56)
        );
    }
}
