package edu.bsuir.spplab.tracer;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MethodResult {
    private String name;
    private String className;
    private double time;
    private List<MethodResult> childMethodsResult;

    public MethodResult(String name, String className) {
        this.name = name;
        this.className = className;
        this.time = 0;
        this.childMethodsResult = new ArrayList<>();
    }

    public void addChildMethod(MethodResult childMethod) {
        this.childMethodsResult.add(childMethod);
    }

}

