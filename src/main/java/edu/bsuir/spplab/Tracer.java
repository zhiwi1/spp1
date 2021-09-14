package edu.bsuir.spplab;

public interface Tracer {
    void startTrace();

    void stopTrace();

    TraceResult getTraceResult();
}
