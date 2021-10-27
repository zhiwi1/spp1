package edu.bsuir.spplab.tracer.impl;

import edu.bsuir.spplab.tracer.TraceResult;
import edu.bsuir.spplab.tracer.Tracer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class TracerImplTest {
    private Tracer<TraceResult> tracer;


    @ParameterizedTest
    @ValueSource(longs = {100, 200, 300})
    void shouldNonNullWhenGetTraceResult(long time) throws InterruptedException {
        tracer = new TracerImpl();
        tracer.startTrace();
        TimeUnit.MILLISECONDS.sleep(time);
        tracer.stopTrace();
        assertNotNull(tracer.getTraceResult());
    }

    @Test
    void shouldReturnNameOfMethodWhenTracerGetTraceResultTest() throws InterruptedException {
        tracer = new TracerImpl();
        tracer.startTrace();
        TimeUnit.SECONDS.sleep(1);
        tracer.stopTrace();
        String nameOfMethodExpected = "shouldReturnNameOfMethodWhenTracerGetTraceResultTest";
        String nameOfMethodActual = tracer.getTraceResult().getThreadResults().get(0).getMethodsResult().get(0).getName();
        assertEquals(nameOfMethodExpected, nameOfMethodActual);
    }

    @Test
    void shouldReturnClassNameOfMethodWhenTracerGetTraceResultTest() throws InterruptedException {
        tracer = new TracerImpl();
        tracer.startTrace();
        TimeUnit.SECONDS.sleep(1);
        tracer.stopTrace();
        String nameOfClassActual = tracer.getTraceResult().getThreadResults().get(0).getMethodsResult().get(0).getClassName();
        String nameOfClassExpected = "edu.bsuir.spplab.tracer.impl.TracerImplTest";
        assertEquals(nameOfClassExpected, nameOfClassActual);
    }

    @Test
    void shouldReturnSizeOfThreadsWhenTracerGetTraceResultTest() throws InterruptedException {
        tracer = new TracerImpl();
        innerMethod();
        new Thread(() -> {
            try {
                innerMethod();
            } catch (InterruptedException e) {
            }
        }).start();
        int expected = 2;
        int actual = tracer.getTraceResult().getThreadResults().size();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnSizeOfMethodsWhenTracerGetTraceResultTest() throws InterruptedException {
        tracer = new TracerImpl();
        innerMethod();
        innerMethod();
        innerMethod();
        int actual = tracer.getTraceResult().getThreadResults().get(0).getMethodsResult().size();
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void shouldNonNullOfMethodWhenTracerGetTraceResult() throws InterruptedException {
        tracer = new TracerImpl();
        innerMethod();
        assertNotNull(tracer.getTraceResult().getThreadResults().get(0).getMethodsResult().get(0));
    }

    @Test
    void shouldNonNullOfClassWhenTracerGetTraceResult() throws InterruptedException {
        tracer = new TracerImpl();
        innerMethod();
        assertNotNull(tracer.getTraceResult().getThreadResults().get(0));
    }

    private void innerMethod() throws InterruptedException {
        tracer.startTrace();
        TimeUnit.MILLISECONDS.sleep(500);
        tracer.stopTrace();
    }

}
