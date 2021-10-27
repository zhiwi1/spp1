package edu.bsuir.spplab.tracer;

import java.util.ArrayDeque;
import java.util.Deque;

public class ThreadTracer implements Tracer<ThreadResult> {
    private final ThreadResult threadResult;
    private final Deque<MethodTracer> dequeOfMethodTracers;

    public ThreadTracer(Long id) {
        this.threadResult = new ThreadResult(id);
        this.dequeOfMethodTracers = new ArrayDeque<>();
    }

    @Override
    public void startTrace() {
        var newMethodTracer = new MethodTracer();
        dequeOfMethodTracers.push(newMethodTracer);
        newMethodTracer.startTrace();

    }

    @Override
    public void stopTrace() {
        MethodTracer lastTracer = dequeOfMethodTracers.poll();
        if (lastTracer != null) {
            lastTracer.stopTrace();
            MethodResult result = lastTracer.getTraceResult();
            if (!dequeOfMethodTracers.isEmpty()) {
                MethodTracer newLastTracer = dequeOfMethodTracers.peek();
                newLastTracer.addChildResult(result);
            } else {
                this.threadResult.addTime(result.getTime());
                this.threadResult.addMethod(result);
            }
        }
    }

    @Override
    public ThreadResult getTraceResult() {
        return threadResult;
    }

}
