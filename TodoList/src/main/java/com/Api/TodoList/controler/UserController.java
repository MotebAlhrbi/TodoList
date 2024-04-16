package com.Api.TodoList.controler;

import com.Api.TodoList.dto.UserDto;
import com.Api.TodoList.model.User;
import com.Api.TodoList.service.UserService;
import com.Api.TodoList.swagger.UserApi;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
public class UserController implements UserApi{

    private final UserService userService;

    @PostMapping("/user/create")
    public ResponseEntity<?> createUser( @RequestBody @Valid User user){
        return userService.createUser(user);
    }

    @PatchMapping("/user/update")
    public ResponseEntity<?> updateUser(@RequestBody  @Valid User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id){
        return userService.deleteUserById(id);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getAllUser(){
        return userService.getAllUser();
    }


}
