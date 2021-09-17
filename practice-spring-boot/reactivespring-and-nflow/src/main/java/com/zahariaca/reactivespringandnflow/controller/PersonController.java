package com.zahariaca.reactivespringandnflow.controller;

import com.zahariaca.reactivespringandnflow.document.Person;
import com.zahariaca.reactivespringandnflow.repository.PersonReactiveRepository;
import com.zahariaca.reactivespringandnflow.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PersonController {
    private final PersonService personService;

    @GetMapping("/v1/person/all")
    public Flux<Person> getAllPersons() {
        log.info("getAllPersons controller method");
        return personService.findAll();
    }

    @PostMapping("/v1/person")
    @ResponseStatus(CREATED)
    public Mono<Person> createPerson(@RequestBody Person person) {
        return personService.save(person);
    }

}
