package pl.jtat.logger.logwriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LocalDestinationLogWriter extends LogWriter {

    private String localLogFilePath;

    public LocalDestinationLogWriter(String localLogFilePath) {
        this.localLogFilePath = localLogFilePath;
    }

    @Override
    public void saveLog(String formattedEventData) {
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
