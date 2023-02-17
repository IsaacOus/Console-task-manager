package org.example.infrastructure.io;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.application.io.Reader;
import org.example.domain.model.Task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class JsonFileReader implements Reader {

    private final Gson gson = new Gson();

    @Override
    public List<Task> read() {
        StringBuilder json = new StringBuilder();
        String homeDirectory = System.getProperty("user.home");
        String filePath = homeDirectory + File.separator + ".consoleagenda" + File.separator + "log.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
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
