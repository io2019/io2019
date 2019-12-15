package pl.jtat.logger.model;

import pl.jtat.logger.C;

public enum EventType {

    MovieAdded(C.EventTypeNames.MOVIE_ADDED),
    ShowroomAdded(C.EventTypeNames.SHOWROOM_ADDED),
    ShowTimeAdded(C.EventTypeNames.SHOW_TIME_ADDED);

    private String eventTypeName;

    EventType(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }
}
