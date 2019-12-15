package net.io.kino.service.impl;

import net.io.kino.model.loggingaction.EventData;
import net.io.kino.model.loggingaction.EventType;
import net.io.kino.service.ActionLogger;
import net.io.kino.service.LogWriter;

import java.util.Map;

public class CinemaActionImpl implements ActionLogger {

    private LogWriter logWriter;

    public CinemaActionImpl(LogWriter logWriter) {
        this.logWriter = logWriter;
    }

    @Override
    public void logEvent(EventType eventType) {
        addToLog(new EventData(eventType, null, null));
    }

    @Override
    public void logEvent(EventType eventType, Boolean result) {
        addToLog(new EventData(eventType, result, null));
    }

    @Override
    public void logEvent(EventType eventType, Boolean result, Map<String, Object> additionalEventDataList) {
        addToLog(new EventData(eventType, result, additionalEventDataList));
    }

    private void addToLog(EventData event) {
        logWriter.saveLog(event);
    }
}
