package net.io.kino.configuration;

import net.io.kino.service.impl.logger.DatabaseLoggingOperationsImpl;
import net.io.kino.service.impl.logger.LocalFileLoggingOperationsImpl;
import net.io.kino.service.logger.LoggingOperations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {
        "net.io.kino.repository"
})
@PropertySource("classpath:logger.properties")
public class BeansSourceConfiguration {

    @Value("${logs.path}")
    private String localSavePath;

    @Bean
    public LoggingOperations logWriter(@Value("${logs.logToDatabase}") boolean logToDatabase) {
        if (logToDatabase) {
            return databaseLogWriter();
        } else {
            return fileLogWriter();
        }
    }

    private LoggingOperations databaseLogWriter() {
        return new DatabaseLoggingOperationsImpl();
    }

    private LoggingOperations fileLogWriter() {
        return new LocalFileLoggingOperationsImpl(localSavePath);
    }
}
