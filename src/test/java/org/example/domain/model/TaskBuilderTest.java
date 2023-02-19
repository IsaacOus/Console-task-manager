package org.example.domain.model;

import org.example.domain.TaskState;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class TaskBuilderTest {

    @Test
    void testBuildTask() {
        // arrange
        String description = "test description";
        OffsetDateTime creationDate = OffsetDateTime.now();
        OffsetDateTime dueDate = OffsetDateTime.now().plusDays(1);
        OffsetDateTime closeDate = OffsetDateTime.now().plusDays(2);
        // A task should be initialized with a state of "todo" by default
        String tag = "test tag";
        Task subTask = new TaskBuilder().setDescription("sub-task").getResult();
        TaskBuilder taskBuilder = new TaskBuilder();

        // act
        Task task = taskBuilder
                .setDescription(description)
                .setCreationDate(creationDate)
                .dueDate(dueDate)
                .closeDate(closeDate)
                .state("todo")
                .tag(tag)
                .subTasks(Collections.singletonList(subTask))
                .getResult();

        // assert
        assertEquals(description, task.getDescription());
        assertEquals(creationDate, task.getCreationDate());
        assertEquals(dueDate, task.getDueDate());
        assertEquals(closeDate, task.getCloseDate());
        assertEquals(TaskState.TODO, task.getState());
        assertEquals(tag, task.getTag());
        assertEquals(Collections.singletonList(subTask), task.getSubTasks());
    }

}
