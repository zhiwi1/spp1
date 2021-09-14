package edu.bsuir.spplab;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class TraceResult {
    BlockingQueue<CustomThreadWrapper> queue = new LinkedBlockingDeque<>();

    public void add(CustomThreadWrapper threadWrapper) {
        try {
            queue.put(threadWrapper);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
