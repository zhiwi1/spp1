package edu.bsuir.spplab.serialization;

import edu.bsuir.spplab.TraceResult;

import java.util.Optional;

@FunctionalInterface
public interface BaseSerializator {
    public Optional<String> serialize(TraceResult traceResult);

}