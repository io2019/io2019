package net.io.kino.model.loggingaction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import net.io.kino.util.C;
import net.io.kino.util.DateFormatter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@Entity(name = "logs")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EventData {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String authUser;

    @Column
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column
    private LocalDateTime eventDate;

    @Column(nullable = true)
    private Boolean eventResult;

    @MapKeyColumn(name = "name")
    @Column(name = "data")
    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name = "additional_logs_data")
    private Map<String, String> additionalLogData;

    public EventData() { }

    public EventData(String authUser, EventType eventType) {
        this(authUser, eventType, null, null);
    }

    public EventData(String authUser, EventType eventType, Boolean result) {
        this(authUser, eventType, result, null);
    }

    public EventData(String authUser, EventType eventType, Map<String, String> additionalEventData) {
        this(authUser, eventType, null, additionalEventData);
    }

    //todo: Missing user identification
    public EventData(@NonNull String authUser, EventType eventType, Boolean result, Map<String, String> additionalEventData) {
        eventDate =  LocalDateTime.now();

        this.authUser = authUser;
        this.eventType = eventType;
        this.eventResult = result;
        this.additionalLogData = additionalEventData;
    }

    private String getAdditionalEventDataString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C.Strings.BRACKET_CURLY_LEFT_WITH_SPACE);
        for (Map.Entry<String, String> entry : additionalLogData.entrySet()) {
            stringBuilder.append(entry.getKey());
            stringBuilder.append(C.Strings.COLON_SPACED);
            stringBuilder.append(entry.getValue());
        }
        stringBuilder.append(C.Strings.BRACKET_CURLY_RIGHT_WITH_SPACE);

        return stringBuilder.toString();
    }

    public String parseDataToString() {
       return String.format(C.LogFormat.ID_DATE_EVENT_TYPE_RESULT_ADDITIONAL_DATA_LOG_FORMAT,
               id,
               DateFormatter.formatToStandardDate(eventDate),
               eventType.getEventTypeName(),
               eventResult == null ?
                       C.ResultStrings.NOT_DESCRIBED : eventResult ?
                       C.ResultStrings.SUCCESS : C.ResultStrings.FAILURE,
               additionalLogData != null ? getAdditionalEventDataString() : C.Messages.NO_ADDITIONAL_DATA_FOUND)
               .concat(C.Strings.NEW_LINE);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthUser() {
        return authUser;
    }

    public void setAuthUser(String authUser) {
        this.authUser = authUser;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public Boolean getEventResult() {
        return eventResult;
    }

    public void setEventResult(Boolean eventResult) {
        this.eventResult = eventResult;
    }

    public Map<String, String> getAdditionalLogData() {
        return additionalLogData;
    }

    public void setAdditionalLogData(Map<String, String> additionalLogData) {
        this.additionalLogData = additionalLogData;
    }
}
