package com.zahariaca.reactivespringandnflow.workflow;

import io.nflow.engine.workflow.definition.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import static com.zahariaca.reactivespringandnflow.workflow.PersonWorkFlow.MyState.*;
import static io.nflow.engine.workflow.definition.NextAction.moveToStateAfter;
import static io.nflow.engine.workflow.definition.WorkflowStateType.*;

@Slf4j
@Component
public class PersonWorkFlow extends WorkflowDefinition<PersonWorkFlow.MyState> {
    public static final String TYPE = "personWorkFLow";

    @RequiredArgsConstructor
    public enum MyState implements WorkflowState {
        my_start(start, "Start state"),
        my_end(end, "End state"),
        my_error(manual, "Error state");

        private final WorkflowStateType type;
        private final String description;

        @Override
        public WorkflowStateType getType() {
            return type;
        }

        @Override
        public String getDescription() {
            return description;
        }
    }

    public PersonWorkFlow() {
        super(TYPE, my_start, my_error);
        permit(my_start, my_end);
    }

    public NextAction my_start(StateExecution execution) {
        log.info("NextAction: -> my_start");
        execution.setVariable("test", "//set in my_start//");
        return moveToStateAfter(my_end, DateTime.now().plusSeconds(10), "Moving to my_end state");
    }

    public void my_end(StateExecution execution) {
        log.info("NextAction: -> my_end");
        log.info("Get variable set by my_start: " + execution.getVariable("test"));
    }

}
