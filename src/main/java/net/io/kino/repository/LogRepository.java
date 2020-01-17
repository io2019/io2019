package net.io.kino.repository;

import net.io.kino.model.loggingaction.EventData;
import net.io.kino.model.loggingaction.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LogRepository extends JpaRepository<EventData, Long> {

    List<EventData> getLogByEventDateAfter(LocalDateTime date);
    List<EventData> getLogByEventDateBetween(LocalDateTime after, LocalDateTime before);
    List<EventData> getLogByEventType(EventType eventType);
}
