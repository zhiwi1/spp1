package edu.bsuir.spplab.tracer;

import java.time.Duration;
import java.time.Instant;

public class MethodTracer implements Tracer<MethodResult> {

    private final MethodResult methodResult;
    private Instant startTime;

    public MethodTracer() {
        this.startTime = Instant.now();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String nameOfTracingMethod = stackTrace[4].getMethodName();
        String classOfTracingMethod = stackTrace[4].getClassName();
        this.methodResult = new MethodResult(nameOfTracingMethod, classOfTracingMethod);
    }

    @Override
    public void startTrace() {
        startTime = Instant.now();
    }

    @Override
    public void stopTrace() {
        long elapsed = Duration.between(startTime, Instant.now()).toMillis();
        methodResult.setTime(elapsed);
    }

    @Override
    public MethodResult getTraceResult() {
        return methodResult;
    }

    public void addChildResult(MethodResult methodResult) {
        this.methodResult.addChildMethod(methodResult);
    }

}
