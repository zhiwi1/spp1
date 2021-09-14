package edu.bsuir.spplab.impl;


import edu.bsuir.spplab.TraceResult;
import edu.bsuir.spplab.Tracer;

import java.time.Duration;
import java.time.Instant;

public class TracerImpl implements Tracer {
    private final TraceResult traceResult = new TraceResult();
    private Instant startTime = Instant.ofEpochSecond(0);
    private Instant endTime = Instant.ofEpochSecond(0);
    private static long fullTimeOfExecutiongMethods;

    public TracerImpl() {
    }

    @Override
    public void startTrace() {
        startTime = Instant.now();
    }

    @Override
    public void stopTrace() {
        endTime = Instant.now();
        long elapsed = Duration.between(startTime, endTime).toMillis();
        fullTimeOfExecutiongMethods += elapsed;
    }

    @Override
    public TraceResult getTraceResult() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String nameOfTracingMethod = stackTrace[2].getMethodName();
        String classOfTracingMethod = stackTrace[2].getClassName();
        long elapsed = Duration.between(startTime, endTime).toMillis();
        this.traceResult.setMethodName(nameOfTracingMethod);
        this.traceResult.setClassName(classOfTracingMethod);
        this.traceResult.setMethodExecutionTime(elapsed);
        this.traceResult.setFullTimeOfMethodsExecution(fullTimeOfExecutiongMethods);
        return this.traceResult;
    }
}
