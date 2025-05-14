package com.example.todo.service;

import com.example.todo.model.Task;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoService {
    private final Map<String, Task> tasks = new LinkedHashMap<>();

    public List<Task> findAllTasks()
    {
        return new ArrayList<>(tasks.values());
    }

    public Task findTaskById(String id)
    {
        return tasks.get(id);
    }

    public Task saveTask (Task task){
        String id = UUID.randomUUID().toString();
        task.setId(id);
        tasks.put(id, task);
        return task;
    }

    public Task updateTask (String id, Task task){
        Task taskToBeUpdated = tasks.get(id);

        if(taskToBeUpdated != null) {
            String title = task.getTitle();
            boolean completed = task.isCompleted();
            taskToBeUpdated.setTitle(title);
            taskToBeUpdated.setCompleted(completed);
        }

        return taskToBeUpdated;
    }

    public void deleteTask (String id)
    {
        tasks.remove(id);
    }


}
