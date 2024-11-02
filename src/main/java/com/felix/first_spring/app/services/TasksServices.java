package com.felix.first_spring.app.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.felix.first_spring.app.domain.Task;

@Service
public class TasksServices {

    private Map<Long, Task> tasks = new HashMap<>();

    public Task create(Task task) {
        Long nextId = tasks.keySet().size() + 1L;
        task.setId(nextId);
        tasks.put(nextId, task);
        return task;
    }

    public Task update(Task task, Long taskId) {
        tasks.put(taskId, task);
        return task;
    }

    public Task getById(Long taskId) {
        return tasks.get(taskId);
    }

    public List<Task> getAll() {
        return new ArrayList<>(tasks.values());
    }

    public String delete(Long taskId) {
        tasks.remove(taskId);
        return "DELETED";
    }
}
