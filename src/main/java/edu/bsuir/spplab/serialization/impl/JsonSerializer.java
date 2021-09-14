package edu.bsuir.spplab.serialization.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bsuir.spplab.TraceResult;
import edu.bsuir.spplab.serialization.BaseSerializator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;


public class JsonSerializer implements BaseSerializator {
    private static final Logger logger = LogManager.getLogger();
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Optional<String> serialize(TraceResult traceResult) {
        Optional<String> jsonResult = Optional.empty();
        try {
            jsonResult = Optional.ofNullable(mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(traceResult));

        } catch (JsonProcessingException e) {
            logger.log(Level.ERROR, "Can't serialize" + e.getMessage());
        }
        return jsonResult;
    }

}
