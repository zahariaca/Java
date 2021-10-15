import io.nflow.engine.listener.WorkflowExecutorListener;

public class TestWorkflowExecutorListener implements WorkflowExecutorListener {
    @Override
    public void beforeProcessing(ListenerContext listenerContext) {
        System.out.println("AZ");
    }

    @Override
    public void afterFailure(ListenerContext listenerContext, Throwable throwable) {
        System.out.println("AZ: Failure");
    }
}
