package edu.bsuir.spplab.tracer;

public interface Tracer<T> {
    void startTrace();

    void stopTrace();

    T getTraceResult();
}
