package net.io.kino.service.logger;

import net.io.kino.model.loggingaction.EventData;
import net.io.kino.model.loggingaction.EventType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface Logger {

    List<EventData> getAllLogs();
    List<EventData> getLogByEventDateAfter(LocalDateTime date);
    List<EventData> getLogByEventDateBetween(LocalDateTime after, LocalDateTime before);
    List<EventData> getLogByEventType(EventType eventType);

    void logEvent(String authUser, EventType eventType);

    void logEvent(String authUser, EventType eventType, Boolean result);

    void logEvent(String authUser, EventType eventType, Map<String, String> additionalEventDataList);

    void logEvent(String authUser, EventType eventType, Boolean result, Map<String, String> additionalEventDataList);
}
