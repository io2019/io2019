package net.io.kino.service.impl.logger;

import net.io.kino.model.loggingaction.EventData;
import net.io.kino.model.loggingaction.EventType;
import net.io.kino.service.logger.Logger;
import net.io.kino.service.logger.LoggingOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class LoggerImpl implements Logger {

    private LoggingOperations loggingOperations;

    public LoggerImpl(@Qualifier("logWriter") @Autowired LoggingOperations loggingOperations) {
        this.loggingOperations = loggingOperations;
    }

    @Override
    public List<EventData> getAllLogs() {
        return loggingOperations.getAllLogs();
    }

    @Override
    public List<EventData> getLogByEventDateAfter(LocalDateTime date) {
        return loggingOperations.getLogByEventDateAfter(date);
    }

    @Override
    public List<EventData> getLogByEventDateBetween(LocalDateTime after, LocalDateTime before) {
        return loggingOperations.getLogByEventDateBetween(after, before);
    }

    @Override
    public List<EventData> getLogByEventType(EventType eventType) {
        return loggingOperations.getLogByEventType(eventType);
    }

    @Override
    public void logEvent(String authUser, EventType eventType) {
        addToLog(new EventData(authUser, eventType));
    }

    @Override
    public void logEvent(String authUser, EventType eventType, Boolean result) {
        addToLog(new EventData(authUser, eventType, result));
    }

    @Override
    public void logEvent(String authUser, EventType eventType, Map<String, String> additionalEventDataList) {
        addToLog(new EventData(authUser, eventType, additionalEventDataList));
    }

    @Override
    public void logEvent(String authUser, EventType eventType, Boolean result, Map<String, String> additionalEventDataList) {
        addToLog(new EventData(authUser, eventType, result, additionalEventDataList));
    }

    private void addToLog(EventData event) {
        loggingOperations.saveLog(event);
    }
}
