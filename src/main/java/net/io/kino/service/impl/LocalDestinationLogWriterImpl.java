package net.io.kino.service.impl;

import net.io.kino.model.loggingaction.EventData;
import net.io.kino.service.LogWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LocalDestinationLogWriterImpl implements LogWriter {

    private String localLogFilePath;

    public LocalDestinationLogWriterImpl(String localLogFilePath) {
        this.localLogFilePath = localLogFilePath;
    }

    public void saveLog(EventData eventData) {
        saveLog(eventData.parseDataToString());
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
