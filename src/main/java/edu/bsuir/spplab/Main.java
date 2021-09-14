package edu.bsuir.spplab;


import edu.bsuir.spplab.impl.TracerImpl;
import edu.bsuir.spplab.serialization.BaseSerializator;
import edu.bsuir.spplab.serialization.impl.JsonSerializer;
import edu.bsuir.spplab.serialization.impl.XmlSerializer;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Tracer tracer = new TracerImpl();
        tracer.startTrace();
        TimeUnit.SECONDS.sleep(1);
        tracer.stopTrace();
        Tracer tracer2 = new TracerImpl();
        tracer2.startTrace();
        TimeUnit.SECONDS.sleep(1);

        System.out.println(tracer.getTraceResult());
        BaseSerializator serializator=new JsonSerializer();
        BaseSerializator serializator1=new XmlSerializer();
        System.out.println(serializator1.serialize(tracer2.getTraceResult()));
        System.out.println(serializator.serialize(tracer2.getTraceResult()));
    }
}
