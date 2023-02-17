package org.example.application.io;

import org.example.domain.model.Task;

import java.util.List;

public interface Writer {

    boolean save(List<Task> tasks);

}
