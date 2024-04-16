package com.Api.TodoList.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message="Task name should not be null")
    @NotEmpty(message="You should write task name")
    private String taskName;
    @NotNull(message="Task Discretion should not be null ")
    private String taskDiscretion;
    private boolean taskCompilation;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
