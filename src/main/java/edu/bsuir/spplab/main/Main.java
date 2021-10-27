package edu.bsuir.spplab.main;


import edu.bsuir.spplab.tracer.TraceResult;
import edu.bsuir.spplab.tracer.impl.TracerImpl;
import edu.bsuir.spplab.serialization.BaseSerializator;
import edu.bsuir.spplab.serialization.impl.JsonSerializer;
import edu.bsuir.spplab.serialization.impl.XmlSerializer;
import edu.bsuir.spplab.tracer.Tracer;

import java.util.concurrent.TimeUnit;

public class Main {
    static Tracer<TraceResult> tracer = new TracerImpl();

    public static void main(String[] args) throws InterruptedException {

        tracer.startTrace();
        innerMethod();
        innerMethod();
        TimeUnit.SECONDS.sleep(1);
        tracer.stopTrace();


        BaseSerializator serializator = new JsonSerializer();
        BaseSerializator serializator1 = new XmlSerializer();

        System.out.println(serializator1.serialize(tracer.getTraceResult()));
        System.out.println(serializator.serialize(tracer.getTraceResult()));

    }

    public static void innerMethod() throws InterruptedException {
        tracer.startTrace();
        TimeUnit.SECONDS.sleep(3);
        tracer.stopTrace();
    }
}
