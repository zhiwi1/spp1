package edu.bsuir.spplab.serialization;

import edu.bsuir.spplab.tracer.TraceResult;

import java.util.Optional;

@FunctionalInterface
public interface BaseSerializer {
   Optional<String> serialize(TraceResult traceResult);
}
