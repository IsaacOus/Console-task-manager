package org.example.infrastructure.io;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.application.io.Reader;
import org.example.domain.model.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class JsonFileReader implements Reader {

    private final Gson gson = new Gson();
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
        return gson.fromJson(String.valueOf(json), new TypeToken<List<Task>>(){}.getType());
    }

}
