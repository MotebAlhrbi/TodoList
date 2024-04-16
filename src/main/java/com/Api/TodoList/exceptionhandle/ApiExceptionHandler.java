package com.Api.TodoList.exceptionhandle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler{

    @ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){

        HttpStatus badRequest=HttpStatus.BAD_REQUEST;
        ApiException apiException=new ApiException(e.getMessage(), e, badRequest);

        return new ResponseEntity<>(apiException, badRequest);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String , String> handleValidationExcption(MethodArgumentNotValidException apiValidationException){

        Map<String , String> errorMessage =new HashMap();

        apiValidationException.getBindingResult().getFieldErrors().forEach( error->{
            errorMessage.put(error.getField() , error.getDefaultMessage());
        });
        return errorMessage;
    }
}
