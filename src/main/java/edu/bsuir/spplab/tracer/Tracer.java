package edu.bsuir.spplab.tracer;

public interface Tracer {
    void startTrace();

    void stopTrace();

    TraceResult getTraceResult();
}
