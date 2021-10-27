package edu.bsuir.spplab.tracer;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ThreadResult {
    private final long id;
    private double time;
    private final List<MethodResult> methodsResult;

    public ThreadResult(Long id) {
        this.id = id;
        this.time = 0;
        this.methodsResult = new ArrayList<>();
    }

    public void addMethod(MethodResult methodResult) {
        methodsResult.add(methodResult);
    }

    public void addTime(double time) {
        this.time += time;
    }
}

