package com.example.todo.service;

import com.example.todo.model.Task;
import com.example.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class TodoService {
    private final TaskRepository taskRepository;

    public TodoService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAllTasks()
    {
        return taskRepository.findAll();
    }

    public Optional<Task> findTaskById(String id)
    {
        return taskRepository.findById(id);
    }

    public Task saveTask (Task task){
        return taskRepository.save(task);
    }

    public Task updateTask (String id, Task updatedTask){
        Optional<Task> existing = taskRepository.findById(id);

        if(existing.isPresent())
        {
            Task task = existing.get();
            task.setTitle(updatedTask.getTitle());
            task.setCompleted(updatedTask.isCompleted());

            return taskRepository.save(task);
        }
        return null;
    }

    public void deleteTask (String id)
    {
        taskRepository.deleteById(id);
    }
}
