package pl.jtat.logger;

import pl.jtat.logger.model.EventType;
import pl.jtat.logger.model.KeyValueData;
import pl.jtat.logger.logwriter.LocalDestinationLogWriter;

import java.util.ArrayList;
import java.util.List;

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
        List<KeyValueData> additionalData = new ArrayList<>();
        additionalData.add(new KeyValueData<>("title", "Jaws"));

        logger.logEvent(EventType.ShowroomAdded, true, additionalData);
    }

    ActionLogger MockMainClassWithLocalDestinationSavingController() {
        return new CinemaActionLogger(new LocalDestinationLogWriter(testLogFilePath));
    }

    String readLogFromFile() {
        String data = null;
        return data;
    }
}