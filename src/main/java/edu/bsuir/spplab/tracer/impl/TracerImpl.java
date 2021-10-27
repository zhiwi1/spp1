package edu.bsuir.spplab.tracer.impl;


import edu.bsuir.spplab.tracer.ThreadResult;
import edu.bsuir.spplab.tracer.ThreadTracer;
import edu.bsuir.spplab.tracer.TraceResult;
import edu.bsuir.spplab.tracer.Tracer;


import java.util.*;

public class TracerImpl implements Tracer<TraceResult> {
    private final Map<Long, ThreadTracer> mapOfTracers;

    public TracerImpl() {
        this.mapOfTracers = new HashMap<>();
    }

    @Override
    public void startTrace() {
        Long threadId = Thread.currentThread().getId();
        ThreadTracer threadTrace;
        if (mapOfTracers.containsKey(threadId)) {
            threadTrace = mapOfTracers.get(threadId);
        } else {
            threadTrace = new ThreadTracer(threadId);
            mapOfTracers.put(threadId, threadTrace);
        }
        threadTrace.startTrace();
    }

    @Override
    public void stopTrace() {
        long threadId = Thread.currentThread().getId();
        ThreadTracer threadTrace = mapOfTracers.get(threadId);
        Optional.ofNullable(threadTrace).ifPresent(ThreadTracer::stopTrace);
    }

    @Override
    public TraceResult getTraceResult() {
        var values = mapOfTracers.values();
        List<ThreadResult> listResults = new ArrayList<>();
        values.forEach(value -> listResults.add(value.getTraceResult()));
        return new TraceResult(listResults);
    }
}
