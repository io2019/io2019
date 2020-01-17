package net.io.kino.service;

import net.io.kino.model.loggingaction.EventData;

public interface LogWriter {

    void saveLog(EventData eventData);
}
