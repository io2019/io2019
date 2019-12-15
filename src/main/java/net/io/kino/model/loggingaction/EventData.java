package net.io.kino.model.loggingaction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import net.io.kino.C;
import net.io.kino.util.DateFormatter;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "useractions")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EventData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID eventId;
    private EventType eventType;
    private LocalDateTime eventDate;
    private Boolean eventResult;
    private Map<String, Object> additionalEventData;

    public EventData(EventType eventType) {
        this(eventType, null, null);
    }

    public EventData(EventType eventType, Map<String, Object> additionalEventData) {
        this(eventType, null, additionalEventData);
    }

    public EventData(EventType eventType, Boolean result, Map<String, Object> additionalEventData) {
        eventId = UUID.randomUUID();
        eventDate =  LocalDateTime.now();
        this.eventType = eventType;
        this.eventResult = result;
        this.additionalEventData = additionalEventData;
    }

    private String getAdditionalEventDataString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C.Strings.BRACKET_CURLY_LEFT_WITH_SPACE);
        for (Map.Entry<String, Object> entry : additionalEventData.entrySet()) {
            stringBuilder.append(entry.getKey());
            stringBuilder.append(C.Strings.COLON_SPACED);
            stringBuilder.append(entry.getValue().toString());
        }
        stringBuilder.append(C.Strings.BRACKET_CURLY_RIGHT_WITH_SPACE);

        return stringBuilder.toString();
    }

    public String parseDataToString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(
                String.format(C.LogFormat.ID_DATE_EVENT_TYPE_RESULT_ADDITIONAL_DATA_LOG_FORMAT,
                        eventId,
                        DateFormatter.formatToStandardDate(eventDate),
                        eventType.getEventTypeName(),
                        eventResult == null ?
                                C.ResultStrings.NOT_DESCRIBED : eventResult ?
                                C.ResultStrings.SUCCESS : C.ResultStrings.FAILURE,
                        getAdditionalEventDataString())
        ).append(C.Strings.NEW_LINE);
        return stringBuilder.toString();
    }
}
