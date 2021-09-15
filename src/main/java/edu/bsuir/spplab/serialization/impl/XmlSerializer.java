package edu.bsuir.spplab.serialization.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import edu.bsuir.spplab.tracer.TraceResult;
import edu.bsuir.spplab.serialization.BaseSerializator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class XmlSerializer implements BaseSerializator {
    private static final XmlMapper xmlMapper = new XmlMapper();
    private static final Logger logger = LogManager.getLogger();

    @Override
    public Optional<String> serialize(TraceResult traceResult) {
        Optional<String> xmlResult = Optional.empty();
        try {
            String xmlString = xmlMapper.writeValueAsString(traceResult);
//            xmlString = formatString(xmlString);
            xmlResult = Optional.ofNullable(xmlString);
        } catch (JsonProcessingException e) {
            logger.log(Level.ERROR, "Can't serialize" + e.getMessage());
        }
        try (FileWriter writer = new FileWriter("src/main/resources/xmlSerialization.xml", false)) {
            writer.write(xmlResult.get());
        } catch (IOException e) {
            logger.log(Level.ERROR, "Can't serialize" + e.getMessage());
        }
        return xmlResult;
    }

//    private String formatString(String s) {
//        s= s.replaceAll("<listOfCustomThreads><listOfCustomThreads>", "<listOfCustomThreads>");
//        s=s.replaceAll("</listOfCustomThreads></listOfCustomThreads>", "</listOfCustomThreads>");
//        s=s.replaceAll("<listOfTraceData><listOfTraceData>", " <listOfTraceData>");
//        return s.replaceAll("</listOfTraceData></listOfTraceData>", " </listOfTraceData>");
//    }
}
