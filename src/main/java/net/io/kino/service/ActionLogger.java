package net.io.kino.service;

import net.io.kino.model.loggingaction.EventType;

import java.util.Map;

public interface ActionLogger {

    void logEvent(EventType eventType);

    void logEvent(EventType eventType, Boolean result);

    void logEvent(EventType eventType, Boolean result, Map<String, Object> additionalEventDataList);
}
