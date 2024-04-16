package com.Api.TodoList.service;

import com.Api.TodoList.dto.UserDto;
import com.Api.TodoList.exceptionhandle.ApiRequestException;
import com.Api.TodoList.exceptionhandle.ApiValidationException;
import com.Api.TodoList.model.User;
import com.Api.TodoList.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    public ResponseEntity<?> createUser(User user){

        try{
            userRepo.save(user);

            return ResponseEntity.ok(modelMapper.map(user, UserDto.class));
        }catch(Exception e){
            throw new ApiRequestException("You cant create user "+e);
        }
    }

    public ResponseEntity<?> updateUser(User user){
        try{
            userRepo.save(user);
            return ResponseEntity.ok(modelMapper.map(user, UserDto.class));
        }catch(Exception e){
            throw new ApiRequestException("You cant update this user", e);
        }
    }

    public ResponseEntity<?> deleteUserById(long id){
        try{
            userRepo.deleteById(id);
            return ResponseEntity.ok().body("Delete successfully");
        }catch(Exception e){
            throw new ApiRequestException("Delete user filed:", e);
        }
    }

    public ResponseEntity<?> getAllUser(){
        try{
            return ResponseEntity.ok(userRepo.findAll());
        }catch(Exception e){
            throw new ApiRequestException("Filed to retrieve all users", e);
        }
    }
}
