package com.Api.TodoList.repo;

import com.Api.TodoList.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task , Long> {
}
