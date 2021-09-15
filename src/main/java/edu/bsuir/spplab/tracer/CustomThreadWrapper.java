package edu.bsuir.spplab.tracer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CustomThreadWrapper {
    private List<TraceDataOfMethod> listOfTraceData = new ArrayList<>();
    private Thread thread;
    private long runtimeOfMethodsInThread;
    private static final Logger logger = LogManager.getLogger();

    public CustomThreadWrapper(Thread thread) {
        this.thread = thread;
    }

    public List<TraceDataOfMethod> getListOfTraceData() {

        return listOfTraceData;
    }

    private long executeRuntimeOfMethodsInThread() {
        for (TraceDataOfMethod dataOfMethod : listOfTraceData) {
            runtimeOfMethodsInThread += dataOfMethod.getMethodExecutionTime();
        }
        return runtimeOfMethodsInThread;
    }

    public void setListOfTraceData(List<TraceDataOfMethod> listOfTraceData) {
        this.listOfTraceData = listOfTraceData;
    }

    public long getRuntimeOfMethodsInThread() {
        return runtimeOfMethodsInThread;
    }

    public void setRuntimeOfMethodsInThread(long runtimeOfMethodsInThread) {
        this.runtimeOfMethodsInThread = runtimeOfMethodsInThread;
    }
}
