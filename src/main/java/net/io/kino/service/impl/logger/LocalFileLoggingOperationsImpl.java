package net.io.kino.service.impl.logger;

import net.io.kino.model.loggingaction.EventData;
import net.io.kino.model.loggingaction.EventType;
import net.io.kino.service.logger.LoggingOperations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class LocalFileLoggingOperationsImpl implements LoggingOperations {

    private String localLogFilePath;

    public LocalFileLoggingOperationsImpl(@Value("${logs.path}") String localLogFilePath) {
        this.localLogFilePath = localLogFilePath;
    }

    public void saveLog(EventData eventData) {
        saveLog(eventData.parseDataToString());
    }

    @Override
    public List<EventData> getAllLogs() {
        return null;
    }

    @Override
    public List<EventData> getLogByEventDateAfter(LocalDateTime date) {
        return null;
    }

    @Override
    public List<EventData> getLogByEventDateBetween(LocalDateTime after, LocalDateTime before) {
        return null;
    }

    @Override
    public List<EventData> getLogByEventType(EventType eventType) {
        return null;
    }

    private void saveLog(String formattedEventData) {
        System.out.println(formattedEventData);

        File logFile = new File(localLogFilePath);
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileWriter fileWriter = new FileWriter(logFile, true)) {
            fileWriter.write(formattedEventData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
