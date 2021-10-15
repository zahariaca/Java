package com.zahariaca.reactivespringandnflow.service;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Tags;
import io.nflow.engine.listener.ListenerChain;
import io.nflow.engine.listener.WorkflowExecutorListener;
import io.nflow.engine.workflow.definition.NextAction;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class TestWorkflowExecutorListener implements WorkflowExecutorListener {
    private final MeterRegistry meterRegistry;

    public TestWorkflowExecutorListener(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Override
    public void beforeProcessing(ListenerContext listenerContext) {
        incrementNflowEventCounter(listenerContext, "before-processing");
    }

    @Override
    public void afterFailure(ListenerContext listenerContext, Throwable throwable) {
        incrementNflowEventCounter(listenerContext, "error-counter");
    }

    @Override
    public NextAction process(ListenerContext listenerContext, ListenerChain chain) {
        incrementNflowEventCounter(listenerContext, "process");
        return WorkflowExecutorListener.super.process(listenerContext, chain);
    }

    @Override
    public void afterProcessing(ListenerContext listenerContext) {
        incrementNflowEventCounter(listenerContext, "success-counter");
    }

    private void incrementNflowEventCounter(ListenerContext listenerContext, String processingStep) {
        var workflowName = listenerContext.definition.getType();
        var state = listenerContext.originalState;

        Counter.builder(getCounterName(workflowName))
                .description(getCounterDescription(workflowName))
                .tags(getNflowTags(workflowName, state, processingStep))
                .register(meterRegistry)
                .increment();
    }

    private String getCounterName(String workflowName) {
        return format("nflow.metrics.%s", workflowName);
    }

    private String getCounterDescription(String workflowName) {
        return format("NFlow metrics counters for Workflow: %s", workflowName);
    }

    private Iterable<Tag> getNflowTags(String workflowName, String state, String processingStep) {
        return Tags.of(
                Tag.of("nflow.workflowName", workflowName),
                Tag.of("nflow.state", state),
                Tag.of("nflow.step", processingStep)
        );
    }

}
