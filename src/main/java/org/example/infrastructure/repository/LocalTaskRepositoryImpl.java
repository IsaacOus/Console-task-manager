package org.example.infrastructure.repository;

import com.google.gson.GsonBuilder;
import org.example.application.io.Reader;
import org.example.domain.model.Task;
import org.example.domain.repository.TaskRepository;
import org.example.infrastructure.io.JsonFileReader;

import java.util.List;

public class LocalTaskRepositoryImpl implements TaskRepository {

    Reader jsonFileReader = new JsonFileReader();

    @Override
    public Task addTask(Task task) {
        return null;
    }

    @Override
    public Task updateTask(Task task) {
        return null;
    }

    @Override
    public boolean removeTask(Task task) {
        return false;
    }

    @Override
    public Task getTask(Task task) {
        return jsonFileReader.read().stream()
                .filter(t -> t.equals(task))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Task> getAllTasks() {
        return jsonFileReader.read();
    }

}
