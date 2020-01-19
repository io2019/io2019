package net.io.kino.model.loggingaction;

public enum EventType {

    MOVIE_ADDED(EventTypeNames.MOVIE_ADDED),
    SHOWROOM_ADDED(EventTypeNames.SHOWROOM_ADDED),
    SHOW_TIME_ADDED(EventTypeNames.SHOW_TIME_ADDED),
    MOVIE_UPDATED(EventTypeNames.MOVIE_UPDATED),
    SHOWROOM_UPDATED(EventTypeNames.SHOWROOM_UPDATED),
    SHOW_TIME_UPDATED(EventTypeNames.SHOW_TIME_UPDATED);

    private String eventTypeName;

    EventType(String eventTypeName) {
        this.eventTypeName = eventTypeName;
        EventTypeNames a = new EventTypeNames();
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    private static final class EventTypeNames {
        public static final String MOVIE_ADDED = "Movie has been added";
        public static final String SHOWROOM_ADDED = "Showroom has been added";
        public static final String SHOW_TIME_ADDED = "Show time has been added";
        public static final String MOVIE_UPDATED = "Movie has been updated";
        public static final String SHOWROOM_UPDATED = "Showroom has been updated";
        public static final String SHOW_TIME_UPDATED = "Show time has been updated";
    }
}
