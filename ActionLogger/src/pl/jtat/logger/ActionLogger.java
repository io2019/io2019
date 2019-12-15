package pl.jtat.logger;

import pl.jtat.logger.model.EventType;
import pl.jtat.logger.model.KeyValueData;

import java.util.List;

public interface ActionLogger {

    void logEvent(EventType eventType);

    void logEvent(EventType eventType, Boolean result);

    void logEvent(EventType eventType, Boolean result, List<KeyValueData> additionalEventDataList);
}
