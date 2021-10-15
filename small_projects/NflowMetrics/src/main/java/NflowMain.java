import io.nflow.engine.internal.executor.WorkflowStateProcessorFactory;
import io.nflow.jetty.StartNflow;

public class NflowMain {
    public static void main(String[] args) throws Exception {
        new StartNflow().startJetty(7500, "local", "metrics");
    }
}
