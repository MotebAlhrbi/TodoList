package com.Api.TodoList.swagger;

import com.Api.TodoList.dto.TaskDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Task", description = "the Task Api")
public interface TaskAPi{


    @Operation(
            summary = "Create Task",
            description = "Create new Task")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    public ResponseEntity<?> createTask(TaskDto taskDto);

    @Operation(
            summary = "Get all Task",
            description = "Get all Task info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    public ResponseEntity<?> getAllTask();


    @Operation(
            summary = "Get task by id",
            description = "Get task info by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    public ResponseEntity<?> getTaskById( long id);

    @Operation(
            summary = "Delete task by id",
            description = "Delete task info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    public ResponseEntity<?> deleteTask(long id);


    @Operation(
            summary = "Update task by id",
            description = "Update task info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    public ResponseEntity<?> updateTask(@RequestBody @Valid TaskDto taskDto);
}
