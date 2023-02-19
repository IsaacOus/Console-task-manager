package org.example.infrastructure.service;

import org.example.domain.TaskState;
import org.example.domain.model.Task;
import org.example.domain.model.TaskBuilder;
import org.example.domain.repository.TaskRepository;
import org.example.infrastructure.repository.InMemoryTaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceImplTest {

    private TaskRepository taskRepository;
    private TaskServiceImpl taskService;

    @BeforeEach
    public void setUp() {
        taskRepository = new InMemoryTaskRepository();
        taskService = new TaskServiceImpl(taskRepository);
    }

    @Test
    public void addTaskTest() {
        String description = "Test Task";
        OffsetDateTime creationDate = OffsetDateTime.now();
        OffsetDateTime dueDate = creationDate.plusDays(7);
        OffsetDateTime closeDate = null;
        String tag = "test";
        List<Task> subTasks = Arrays.asList();

        TaskBuilder taskBuilder = new TaskBuilder()
                .setDescription(description)
                .setCreationDate(creationDate)
                .dueDate(dueDate)
                .closeDate(closeDate)
                .tag(tag)
                .subTasks(subTasks);

        Task expectedTask = taskBuilder.getResult();

        Task actualTask = taskService.addTask(description, creationDate, dueDate, closeDate, tag, subTasks);

        assertEquals(expectedTask, actualTask);
    }


    @Test
    public void updateTaskTest() {
        // add a new task
        String description = "My first task";
        OffsetDateTime creationDate = OffsetDateTime.now();
        OffsetDateTime dueDate = OffsetDateTime.now().plusDays(2);
        OffsetDateTime closeDate = null;
        String tag = "personal";
        List<Task> subTasks = new ArrayList<>();

        this.taskService.addTask(description, creationDate, dueDate, closeDate, tag, subTasks);

        // update the task
        String newDescription = "My updated task";
        OffsetDateTime newDueDate = OffsetDateTime.now().plusDays(3);
        String newStatus = TaskState.PROGRESS.getName();

        Task updatedTask = new TaskBuilder()
                .setDescription(newDescription)
                .setCreationDate(creationDate)
                .dueDate(newDueDate)
                .closeDate(closeDate)
                .tag(tag)
                .subTasks(subTasks)
                .state(newStatus)
                .getResult();

        boolean result = this.taskService.updateTask(0, newDescription, newDueDate, newStatus);
        assertTrue(result);

        Task task = this.taskRepository.getTaskByIndex(0, this.taskRepository.getAllTasks());
        assertEquals(updatedTask, task);
    }


    @Test
    public void removeTaskTest() {
        // add a new task
        String description = "My first task";
        OffsetDateTime creationDate = OffsetDateTime.now();
        OffsetDateTime dueDate = OffsetDateTime.now().plusDays(2);
        OffsetDateTime closeDate = null;
        String tag = "personal";
        List<Task> subTasks = new ArrayList<>();

        this.taskService.addTask(description, creationDate, dueDate, closeDate, tag, subTasks);

        // remove the task
        boolean result = this.taskService.removeTask(0);
        assertTrue(result);

        List<Task> tasks = this.taskRepository.getAllTasks();
        assertEquals(0, tasks.size());
    }

    @Test
    public void getTaskTest(){
        // add a new task
        String description = "My first task";
        OffsetDateTime creationDate = OffsetDateTime.now();
        OffsetDateTime dueDate = OffsetDateTime.now().plusDays(2);
        OffsetDateTime closeDate = null;
        String tag = "personal";
        List<Task> subTasks = new ArrayList<>();

        Task addedTask = this.taskService.addTask(description, creationDate, dueDate, closeDate, tag, subTasks);

        // get the task
        Task task = this.taskService.getTask(addedTask);
        assertNotNull(task);
    }

}
