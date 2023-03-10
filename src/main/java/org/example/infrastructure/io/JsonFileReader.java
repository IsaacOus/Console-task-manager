package org.example.infrastructure.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.application.io.Reader;
import org.example.domain.TaskState;
import org.example.domain.model.Task;
import org.example.infrastructure.serialization.OffsetDateTimeAdapter;
import org.example.infrastructure.serialization.TaskStateAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;

public class JsonFileReader implements Reader {

    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeAdapter())
            .registerTypeAdapter(TaskState.class, new TaskStateAdapter())
            .create();

    private final JsonFile jsonFile;

    public JsonFileReader(JsonFile jsonFile) {
        this.jsonFile = jsonFile;
    }

    @Override
    public List<Task> read() {
        StringBuilder json = new StringBuilder();

        try {
            BufferedReader reader = jsonFile.openReader();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        if (json.toString().isEmpty()) {
            return List.of();
        }

        return gson.fromJson(String.valueOf(json), new TypeToken<List<Task>>(){}.getType());
    }
}
