package edu.bsuir.spplab.tracer;

import lombok.Getter;


import java.util.List;

@Getter
public class TraceResult {

    private final List<ThreadResult> threadResults;

    public TraceResult(List<ThreadResult> threadResults) {
        this.threadResults = threadResults;
    }
}
