package edu.bsuir.spplab.tracer.impl;


import edu.bsuir.spplab.tracer.CustomThreadWrapper;
import edu.bsuir.spplab.tracer.TraceDataOfMethod;
import edu.bsuir.spplab.tracer.TraceResult;
import edu.bsuir.spplab.tracer.Tracer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.time.Instant;

public class TracerImpl implements Tracer {
    private final TraceResult traceResult = new TraceResult();
    private Instant startTime = Instant.ofEpochSecond(0);
    private Instant endTime = Instant.ofEpochSecond(0);
    private static final Logger logger= LogManager.getLogger();

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
        CustomThreadWrapper threadWrapper = new CustomThreadWrapper(Thread.currentThread());
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String nameOfTracingMethod = stackTrace[2].getMethodName();
        String classOfTracingMethod = stackTrace[2].getClassName();

        TraceDataOfMethod traceDataOfMethod = new TraceDataOfMethod();

        traceDataOfMethod.setMethodData(nameOfTracingMethod);
        traceDataOfMethod.setClassData(classOfTracingMethod);
        traceDataOfMethod.setMethodExecutionTime(elapsed);

        threadWrapper.getListOfTraceData().add(traceDataOfMethod);
        logger.info(threadWrapper.getRuntimeOfMethodsInThread());
        threadWrapper.setRuntimeOfMethodsInThread(threadWrapper.getRuntimeOfMethodsInThread() + traceDataOfMethod.getMethodExecutionTime());
        traceResult.add(threadWrapper);
    }

    @Override
    public TraceResult getTraceResult() {
        return this.traceResult;
    }
}
