package org.example.infrastructure.serialization;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class OffsetDateTimeAdapter extends TypeAdapter<OffsetDateTime> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSxxx");

    @Override
    public void write(JsonWriter out, OffsetDateTime value) throws IOException {
        if (value != null) {
            out.value(formatter.format(value));
        } else {
            out.nullValue();
        }
    }

    @Override
    public OffsetDateTime read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        } else {
            String str = in.nextString();
            return OffsetDateTime.parse(str, formatter);
        }
    }
}
