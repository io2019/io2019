package net.io.kino.controller;

import net.io.kino.model.loggingaction.EventData;
import net.io.kino.model.loggingaction.EventType;
import net.io.kino.repository.LogRepository;
import net.io.kino.service.impl.logger.DatabaseLoggingOperationsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogsController {

    @Autowired
    LogRepository logRepository;

    @GetMapping
    public List<EventData> getAllExistingLogs() { return logRepository.findAll(); }

    @GetMapping(params = {"date"})
    public List<EventData> getLogsByDate(@RequestParam LocalDateTime date) {
        return logRepository.getLogByEventDateAfter(date);
    }

    @GetMapping(params = {"after", "before"})
    public List<EventData> getLogsByPeriod(@RequestParam LocalDateTime after, @RequestParam LocalDateTime before) {
        return logRepository.getLogByEventDateBetween(after, before);
    }

    @GetMapping(params = {"eventType"})
    public List<EventData> getLogsByEventType(@RequestParam EventType eventType) {
        return logRepository.getLogByEventType(eventType);
    }
    
}