package com.Api.TodoList.controler;

import com.Api.TodoList.dto.TaskDto;
import com.Api.TodoList.service.TaskService;
import com.Api.TodoList.swagger.TaskAPi;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;


@RestController
@RequiredArgsConstructor
public class TaskController implements TaskAPi{

    private final TaskService taskService;

    @PostMapping("task/create")
    public ResponseEntity<?> createTask(@Valid @RequestBody TaskDto taskDto){

        return taskService.createTask(taskDto);
    }

    @GetMapping("/task")
    public ResponseEntity<?> getAllTask(){

        return taskService.getAllTask();
    }

    @GetMapping("task/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable long id){

        return taskService.getTaskById(id);
    }

    @DeleteMapping("task/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable long id){
        return taskService.deleteTaskById(id);
    }

    @PatchMapping("task/update")
    public ResponseEntity<?> updateTask(@RequestBody @Valid TaskDto taskDto){
        return taskService.updateTask(taskDto);
    }
}
