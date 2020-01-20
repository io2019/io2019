package net.io.kino.controller;

import net.io.kino.model.loggingaction.EventData;
import net.io.kino.model.loggingaction.EventType;
import net.io.kino.repository.LogRepository;
import net.io.kino.service.impl.logger.DatabaseLoggingOperationsImpl;
import net.io.kino.service.logger.LoggingOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/logs")
@PreAuthorize("isAuthenticated()")
public class LogsController {

    LoggingOperations loggingOperations;

    @GetMapping
    public List<EventData> getAllExistingLogs() {
        return loggingOperations.getAllLogs();
    }

    @GetMapping(params = {"date"})
    public List<EventData> getLogsByDate(@RequestParam LocalDateTime date) {
        return loggingOperations.getLogByEventDateAfter(date);
    }

    @GetMapping(params = {"after", "before"})
    public List<EventData> getLogsByPeriod(@RequestParam LocalDateTime after, @RequestParam LocalDateTime before) {
        return loggingOperations.getLogByEventDateBetween(after, before);
    }

    @GetMapping(params = {"eventType"})
    public List<EventData> getLogsByEventType(@RequestParam EventType eventType) {
        return loggingOperations.getLogByEventType(eventType);
    }

}
