package edu.bsuir.spplab.tracer;

import edu.bsuir.spplab.tracer.CustomThreadWrapper;

import java.util.ArrayList;
import java.util.List;

public class TraceResult {
    List<CustomThreadWrapper> listOfCustomThreads = new ArrayList<>();

    public void add(CustomThreadWrapper threadWrapper) {
        listOfCustomThreads.add(threadWrapper);
    }

    public List<CustomThreadWrapper> getListOfCustomThreads() {
        return listOfCustomThreads;
    }

    public void setListOfCustomThreads(List<CustomThreadWrapper> listOfCustomThreads) {
        this.listOfCustomThreads = listOfCustomThreads;
    }
}
