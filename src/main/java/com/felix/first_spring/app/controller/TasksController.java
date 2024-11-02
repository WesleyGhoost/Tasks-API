package com.felix.first_spring.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.felix.first_spring.app.domain.Task;
import com.felix.first_spring.app.services.TasksServices;

@RestController
@RequestMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
public class TasksController {

    @Autowired
    private TasksServices tasksServices;

    @GetMapping
    @ResponseBody
    public List<Task> getAll() {
        return tasksServices.getAll();
    }

    @PostMapping
    @ResponseBody
    public Task create(@RequestBody Task task) {
        return tasksServices.create(task);
    }

    @PutMapping("/{taskId}")
    @ResponseBody
    public Task update(@PathVariable("taskId") Long taskId, @RequestBody Task task) {
        return tasksServices.update(task, taskId);
    }

    @DeleteMapping("/{taskId}")
    @ResponseBody
    public String delete(@PathVariable("taskId") Long taskId) {
        return tasksServices.delete(taskId);
    }
}
