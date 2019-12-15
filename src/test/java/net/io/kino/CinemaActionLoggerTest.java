package net.io.kino;

import net.io.kino.model.loggingaction.EventType;
import net.io.kino.service.ActionLogger;
import net.io.kino.service.impl.CinemaActionImpl;
import net.io.kino.service.impl.LocalDestinationLogWriterImpl;

import java.util.Map;
import java.util.TreeMap;

class CinemaActionLoggerTest {

    private static final String testLogFilePath = "../../testLogFile.txt";

    @org.junit.jupiter.api.Test
    void logEventEventTypeOnly() {
        ActionLogger logger = MockMainClassWithLocalDestinationSavingController();

    }

    @org.junit.jupiter.api.Test
    void logEventEventTypeAndResult() {
        ActionLogger logger = MockMainClassWithLocalDestinationSavingController();

    }

    @org.junit.jupiter.api.Test
    void logEventEventTypeAndResultAndAdditionalData() {
        ActionLogger logger = MockMainClassWithLocalDestinationSavingController();
        Map<String, Object> additionalData = new TreeMap<>();
        additionalData.put("title", "Jaws");

        logger.logEvent(EventType.ShowroomAdded, true, additionalData);
    }

    ActionLogger MockMainClassWithLocalDestinationSavingController() {
        return new CinemaActionImpl(new LocalDestinationLogWriterImpl(testLogFilePath));
    }
}