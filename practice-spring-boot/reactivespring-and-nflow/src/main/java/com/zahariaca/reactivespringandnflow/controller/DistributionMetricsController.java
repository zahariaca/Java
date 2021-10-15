package com.zahariaca.reactivespringandnflow.controller;

import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DistributionMetricsController {
    private final MeterRegistry meterRegistry;

    @PostMapping("/v1/distribution/{increment}")
    public String incremenetDistribution(@PathVariable int increment) {
        DistributionSummary distributionSummary = DistributionSummary
                .builder("az.test.distribution")
                .baseUnit("retries")
                .register(meterRegistry);

        distributionSummary.record(increment);

        return "SUCCESS";
    }

    @PostMapping("/v1/gauge/{increment}")
    public String incremenetGauge(@PathVariable int increment) {
        DistributionSummary distributionSummary = DistributionSummary
                .builder("az.test.distribution")
                .baseUnit("retries")
                .register(meterRegistry);

        distributionSummary.record(increment);

        return "SUCCESS";
    }
}
