package com.zahariaca.reactivespringandnflow.service;

import com.zahariaca.reactivespringandnflow.document.Person;
import com.zahariaca.reactivespringandnflow.repository.PersonReactiveRepository;
import com.zahariaca.reactivespringandnflow.workflow.PersonWorkFlow;
import io.nflow.engine.service.WorkflowInstanceService;
import io.nflow.engine.workflow.instance.WorkflowInstanceFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonReactiveRepository personReactiveRepository;
    private final WorkflowInstanceService workflowInstanceService;
    private final WorkflowInstanceFactory workflowInstanceFactory;

    public Flux<Person> findAll() {
        workflowInstanceService.insertWorkflowInstance(workflowInstanceFactory.newWorkflowInstanceBuilder()
                .setType(PersonWorkFlow.TYPE)
                .setExternalId("person-workflow-test")
                .build());
        return personReactiveRepository.findAll();
    }

    public Mono<Person> save(Person person) {
        return null;
    }
}
