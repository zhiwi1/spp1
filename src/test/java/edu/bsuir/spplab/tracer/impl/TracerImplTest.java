package edu.bsuir.spplab.tracer.impl;

import edu.bsuir.spplab.tracer.Tracer;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TracerImplTest {
    Tracer tracer;

    @BeforeTest
    public void init() {
        tracer = new TracerImpl();
    }

    @Test
    public void getTraceResultCheckRunTimeTest() throws InterruptedException {
        tracer.startTrace();
        TimeUnit.SECONDS.sleep(1);
        tracer.stopTrace();
        long actualResult = tracer.getTraceResult().getListOfCustomThreads().get(0).getListOfTraceData().get(0).getMethodExecutionTime();
        long expectedResult = 1000;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getTraceResultCheckNameOfMethodTest() throws InterruptedException {
        tracer.startTrace();
        TimeUnit.SECONDS.sleep(1);
        tracer.stopTrace();
        String nameOfMethodExpected = "getTraceResultCheckNameOfMethodTest";
        String nameOfMethodActual = tracer.getTraceResult().getListOfCustomThreads().get(0).getListOfTraceData().get(0).getMethodData();
        Assert.assertEquals(nameOfMethodActual, nameOfMethodExpected);
    }

    @Test
    public void getTraceResultCheckNameOfClassTest() throws InterruptedException {
        tracer.startTrace();
        TimeUnit.SECONDS.sleep(1);
        tracer.stopTrace();
        String nameOfClassActual = tracer.getTraceResult().getListOfCustomThreads().get(0).getListOfTraceData().get(0).getClassData();
        String nameOfClassExpected="edu.bsuir.spplab.tracer.impl.TracerImplTest";
        System.out.println(tracer.getTraceResult().getListOfCustomThreads().get(0).getListOfTraceData().get(0).getClassData());
        Assert.assertEquals(nameOfClassActual, nameOfClassExpected);
    }
}