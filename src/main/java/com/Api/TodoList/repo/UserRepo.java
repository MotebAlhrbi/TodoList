package com.Api.TodoList.repo;

import com.Api.TodoList.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User , Long> {
}
