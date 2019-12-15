package pl.jtat.logger;

import pl.jtat.logger.model.EventData;
import pl.jtat.logger.model.EventType;
import pl.jtat.logger.model.KeyValueData;
import pl.jtat.logger.logwriter.LogWriter;

import java.util.List;

public class CinemaActionLogger implements ActionLogger {

    private LogWriter logWriter;

    public CinemaActionLogger(LogWriter logWriter) {
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
    public void logEvent(EventType eventType, Boolean result, List<KeyValueData> additionalEventDataList) {
        addToLog(new EventData(eventType, result, additionalEventDataList));
    }

    private void addToLog(EventData event) {
        logWriter.saveLog(event.parseDataToString());
    }
}
