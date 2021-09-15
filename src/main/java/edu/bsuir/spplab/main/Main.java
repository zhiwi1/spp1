package edu.bsuir.spplab.main;


import edu.bsuir.spplab.tracer.impl.TracerImpl;
import edu.bsuir.spplab.serialization.BaseSerializator;
import edu.bsuir.spplab.serialization.impl.JsonSerializer;
import edu.bsuir.spplab.serialization.impl.XmlSerializer;
import edu.bsuir.spplab.tracer.Tracer;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Tracer tracer = new TracerImpl();
        tracer.startTrace();
        TimeUnit.SECONDS.sleep(1);
        tracer.stopTrace();
        tracer.startTrace();
        TimeUnit.MILLISECONDS.sleep(500);
        tracer.stopTrace();
        Thread thread = new Thread() {
            @Override
            public void run() {
                tracer.startTrace();
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tracer.stopTrace();
            }
        };
        thread.start();
        thread.join();

        BaseSerializator serializator = new JsonSerializer();
        BaseSerializator serializator1 = new XmlSerializer();

        System.out.println(serializator1.serialize(tracer.getTraceResult()));
        System.out.println(serializator.serialize(tracer.getTraceResult()));

    }
}
