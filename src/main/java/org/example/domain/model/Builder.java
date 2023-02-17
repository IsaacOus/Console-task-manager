package org.example.domain.model;

import org.example.domain.TaskState;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface Builder {

    void setDescription(String description);
    void setCreationDate(LocalDateTime creationDate);

    void creationDate(LocalDateTime creationDate);

    void dueDate(Optional<LocalDateTime> dueDate);

    void closeDate(Optional<LocalDateTime> closeDate);

    void tag(Optional<String> tag);

    void subTasks(List<Task> subTasks);
}
