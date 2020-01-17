package net.io.kino.model.loggingaction;

import net.io.kino.util.C;

public enum EventType {

    MOVIE_ADDED(C.EventTypeNames.MOVIE_ADDED),
    SHOWROOM_ADDED(C.EventTypeNames.SHOWROOM_ADDED),
    SHOW_TIME_ADDED(C.EventTypeNames.SHOW_TIME_ADDED),
    MOVIE_UPDATED(C.EventTypeNames.MOVIE_UPDATED),
    SHOWROOM_UPDATED(C.EventTypeNames.SHOWROOM_UPDATED),
    SHOW_TIME_UPDATED(C.EventTypeNames.SHOW_TIME_UPDATED);

    private String eventTypeName;

    EventType(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }
}
