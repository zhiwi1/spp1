package edu.bsuir.spplab;

import java.util.ArrayList;
import java.util.List;

public class CustomThreadWrapper {
    private long id;
    private List<TraceDataOfMethod> list = new ArrayList<>();
    private Thread thread;

    public CustomThreadWrapper(Thread thread) {
        this.thread = thread;
    }

}
