import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.SharedMetricRegistries;

import java.util.logging.Filter;

public class Main {
    public static void main(String[] args) {
        MetricRegistry metricRegistry = new MetricRegistry();
        Meter meter1 = new Meter();
        metricRegistry.register("meter1", meter1);

        Meter meter2 = metricRegistry.meter("meter2");

        String name1 = MetricRegistry.name(Filter.class, "request", "count");
        String name2 = MetricRegistry.name("CustomFilter", "response", "count");

        System.out.println("name1: " + name1);
        System.out.println("name2: " + name2);

        SharedMetricRegistries.add("default", metricRegistry);
        MetricRegistry retrievedMetricRegistry = SharedMetricRegistries.getOrCreate("default");
        SharedMetricRegistries.remove("default");
    }
}
