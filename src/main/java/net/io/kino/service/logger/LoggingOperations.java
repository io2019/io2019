package net.io.kino.service.logger;

import net.io.kino.model.loggingaction.EventData;
import net.io.kino.model.loggingaction.EventType;

import java.time.LocalDateTime;
import java.util.List;

public interface LoggingOperations {

    void saveLog(EventData eventData);

    List<EventData> getAllLogs();
    List<EventData> getLogByEventDateAfter(LocalDateTime date);
    List<EventData> getLogByEventDateBetween(LocalDateTime after, LocalDateTime before);
    List<EventData> getLogByEventType(EventType eventType);
}
