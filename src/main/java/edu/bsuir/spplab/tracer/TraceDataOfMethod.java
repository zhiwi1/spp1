package edu.bsuir.spplab.tracer;

import java.util.List;

public class TraceDataOfMethod {
    private String methodData;
    private String classData;
    private long methodExecutionTime;

    public String getMethodData() {
        return methodData;
    }

    public void setMethodData(String methodData) {
        this.methodData = methodData;
    }

    public String getClassData() {
        return classData;
    }

    public void setClassData(String classData) {
        this.classData = classData;
    }

    public long getMethodExecutionTime() {
        return methodExecutionTime;
    }

    public void setMethodExecutionTime(long methodExecutionTime) {
        this.methodExecutionTime = methodExecutionTime;
    }


}
