package net.io.kino.service.impl.logger;

import net.io.kino.model.loggingaction.EventData;
import net.io.kino.model.loggingaction.EventType;
import net.io.kino.repository.LogRepository;
import net.io.kino.service.logger.LoggingOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DatabaseLoggingOperationsImpl implements LoggingOperations {

    @Autowired
    private LogRepository logRepository;

    @Override
    public void saveLog(EventData eventData) {
        logRepository.save(eventData);
    }

    @Override
    public List<EventData> getAllLogs() {
        return logRepository.findAll();
    }

    @Override
    public List<EventData> getLogByEventDateAfter(LocalDateTime date) {
        return logRepository.getLogByEventDateAfter(date);
    }

    @Override
    public List<EventData> getLogByEventDateBetween(LocalDateTime after, LocalDateTime before) {
        return logRepository.getLogByEventDateBetween(after, before);
    }

    @Override
    public List<EventData> getLogByEventType(EventType eventType) {
        return logRepository.getLogByEventType(eventType);
    }
}
