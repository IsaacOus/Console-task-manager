package org.example.infrastructure.io;

import com.google.gson.Gson;
import org.example.application.io.Writer;
import org.example.domain.model.Task;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonFileWriter implements Writer {

    private final Gson gson = new Gson();
    private final JsonFile jsonFile = new JsonFile();

    @Override
    public boolean save(List<Task> tasks) {
        try {
            FileWriter fileWriter = new FileWriter(jsonFile.getFilePath(), false);
            this.clear(fileWriter);
            fileWriter.write(gson.toJson(tasks));
        }catch (IOException e){
            e.printStackTrace();
        }
        return true;
    }

    void clear(FileWriter fileWriter) throws IOException {
        fileWriter.write("");
        fileWriter.close();
    }

}
