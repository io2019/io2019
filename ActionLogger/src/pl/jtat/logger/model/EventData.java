package pl.jtat.logger.model;

import pl.jtat.logger.C;
import pl.jtat.logger.util.DateFormatter;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class EventData {

    private UUID eventId;
    private EventType eventType;
    private Date eventDate;
    private Boolean eventResult;
    private List<KeyValueData> additionalEventData;

    public EventData(EventType eventType) {
        this(eventType, null, null);
    }

    public EventData(EventType eventType, List<KeyValueData> additionalEventData) {
        this(eventType, null, additionalEventData);
    }

    public EventData(EventType eventType, Boolean result, List<KeyValueData> additionalEventData) {
        eventId = UUID.randomUUID();
        eventDate = Calendar.getInstance().getTime();
        this.eventType = eventType;
        this.eventResult = result;
        this.additionalEventData = additionalEventData;
    }

    private String getAdditionalEventDataString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C.Strings.BRACKET_CURLY_LEFT_WITH_SPACE);
        for(int i = 0; i < additionalEventData.size(); i++) {
            stringBuilder.append(additionalEventData.get(i).getKey().toString());
            stringBuilder.append(C.Strings.COLON_SPACED);
            stringBuilder.append(additionalEventData.get(i).getValue().toString());
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
