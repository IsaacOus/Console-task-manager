package org.example.infrastructure.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonFile {

    private final String homeDirectory = System.getProperty("user.home");
    private final String filePath = homeDirectory + File.separator + ".consoleagenda" + File.separator + "data.json";

    public BufferedReader openReader() throws FileNotFoundException {
        return new BufferedReader(new FileReader(filePath));
    }

    public String getFilePath() {
        return filePath;
    }

}
