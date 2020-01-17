package net.io.kino.controller.converter;

import net.io.kino.model.loggingaction.EventType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToEventTypeConverter implements Converter<String, EventType> {

    @Override
    public EventType convert(String source) {
        try {
            return EventType.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
