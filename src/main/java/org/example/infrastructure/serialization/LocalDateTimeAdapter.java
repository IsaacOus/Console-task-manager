package org.example.infrastructure.serialization;

import com.google.gson.TypeAdapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {
    // Formatter for this localDateTime format 2022-02-15T22:14:30.486798+01:00
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSxxx");

    @Override
    public void write(com.google.gson.stream.JsonWriter out, LocalDateTime value) throws java.io.IOException {
        if (value != null) {
            out.value(formatter.format(value));
        } else {
            out.nullValue();
        }
    }

    @Override
    public LocalDateTime read(com.google.gson.stream.JsonReader in) throws java.io.IOException {
        if (in.peek() == com.google.gson.stream.JsonToken.NULL) {
            in.nextNull();
            return null;
        } else {
            String str = in.nextString();
            return LocalDateTime.parse(str, formatter);
        }
    }
}
