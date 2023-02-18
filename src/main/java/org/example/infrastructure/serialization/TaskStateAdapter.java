package org.example.infrastructure.serialization;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import org.example.domain.TaskState;

import java.io.IOException;

public class TaskStateAdapter extends TypeAdapter<TaskState> {
    @Override
    public void write(JsonWriter out, TaskState value) throws IOException {
        if (value != null) {
            out.value(value.getValue());
        } else {
            out.nullValue();
        }
    }

    @Override
    public TaskState read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        } else {
            String str = in.nextString();
            return TaskState.fromInteger(Integer.parseInt(str));
        }
    }
}
