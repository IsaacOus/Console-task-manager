package org.example.infrastructure.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.application.io.Writer;
import org.example.domain.model.Task;
import org.example.infrastructure.serialization.OffsetDateTimeAdapter;

import java.io.FileWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;

public class JsonFileWriter implements Writer {

    private final Gson gson = new GsonBuilder().registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeAdapter()).create();
    private final JsonFile jsonFile;

    public JsonFileWriter(JsonFile jsonFile) {
        this.jsonFile = jsonFile;
    }

    @Override
    public boolean save(List<Task> tasks) {
        try {
            FileWriter fileWriter = new FileWriter(jsonFile.getFilePath(), false);
            this.clear(fileWriter);
            fileWriter.write(gson.toJson(tasks));
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return true;
    }

    void clear(FileWriter fileWriter) throws IOException {
        fileWriter.write("");
    }
}
