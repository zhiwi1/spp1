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
    private final XmlMapper xmlMapper = new XmlMapper();
    private static final Logger logger = LogManager.getLogger();
    private static final String RELATIVE_PATH = "src/main/resources/xmlSerialization.xml";

    @Override
    public Optional<String> serialize(TraceResult traceResult) {
        Optional<String> xmlResult = Optional.empty();
        try {
            String xmlString = xmlMapper.writeValueAsString(traceResult);
            xmlResult = Optional.ofNullable(xmlString);
        } catch (JsonProcessingException e) {
            logger.log(Level.ERROR, String.format("Can't serialize %s", e.getMessage()));
        }
        if (xmlResult.isPresent()) {
            try (FileWriter writer = new FileWriter(RELATIVE_PATH, false)) {
                writer.write(xmlResult.get());
            } catch (IOException e) {
                logger.log(Level.ERROR, String.format("Can't serialize %s", e.getMessage()));
            }
        }
        return xmlResult;
    }

}
