package com.Api.TodoList.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskDto{

    @NotNull(message="Task name should not be null")
    @NotEmpty(message="You should write task name")
    private String taskName;
    @NotNull(message="Task Discretion should not be null ")
    private String taskDiscretion;
    private boolean taskCompilation;
    private long userId ;
}
