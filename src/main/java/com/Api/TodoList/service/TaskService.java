package com.Api.TodoList.service;

import com.Api.TodoList.dto.TaskDto;
import com.Api.TodoList.exceptionhandle.ApiRequestException;
import com.Api.TodoList.model.Task;
import com.Api.TodoList.repo.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class TaskService{

    private final TaskRepo taskRepo;
    private final ModelMapper modelMapper;

    public ResponseEntity<?> createTask(TaskDto newTask){
        try{
            taskRepo.save(modelMapper.map(newTask, Task.class));

            return ResponseEntity.ok(newTask);
        }catch(Exception e){
           throw new ApiRequestException("You cant create Task" ,e);
        }
    }

    public ResponseEntity<?> updateTask(TaskDto taskDto){
        try{
            taskRepo.save(modelMapper.map(taskDto, Task.class));
            return ResponseEntity.ok(taskDto);
        }catch(Exception e){

            throw  new ApiRequestException("You cant update Task"+e);
        }
    }

    public ResponseEntity<?> deleteTaskById(long id){
        try{
            taskRepo.deleteById(id);
            return ResponseEntity.ok().body("Delete successfully");
        }catch(Exception e){
            throw new ApiRequestException("Task Delete Filed", e);
        }
    }

    public ResponseEntity<?> getTaskById(long id){
        try{

            if(!taskRepo.findById(id).isEmpty()){
                return ResponseEntity.ok(taskRepo.findById(id));
            }

            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
            }

        }catch(Exception e){
            throw new ApiRequestException("Task not found",e);
        }
    }

    public ResponseEntity<?> getAllTask(){
        try{
            return ResponseEntity.ok(taskRepo.findAll());
        }catch(Exception e){
            throw new ApiRequestException("Retrieve all the task filed", e);
        }
    }
}
