package net.io.kino;

public final class C {

    public interface Strings {
        String BRACKET_CURLY_LEFT_WITH_SPACE = "{ ";
        String BRACKET_CURLY_RIGHT_WITH_SPACE = " }";
        String COLON_SPACED = " : ";
        String NEW_LINE = "\r\n";
    }

    public interface LogFormat {
        String ID_DATE_EVENT_TYPE_RESULT_ADDITIONAL_DATA_LOG_FORMAT = "%s | %s | %s | %s | %s";
    }

    public interface EventTypeNames {
        String MOVIE_ADDED = "Movie has been added";
        String SHOWROOM_ADDED = "Showroom has been added";
        String SHOW_TIME_ADDED = "Show time has been added";
    }

    public interface ResultStrings {
        String SUCCESS = "Success";
        String FAILURE = "Failure";
        String NOT_DESCRIBED = "Not described";
    }
}
