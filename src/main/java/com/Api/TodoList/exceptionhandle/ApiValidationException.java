package com.Api.TodoList.exceptionhandle;

import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ValidationException;

public class ApiValidationException extends MethodArgumentNotValidException{

    public ApiValidationException(MethodParameter parameter, BindingResult bindingResult){
        super(parameter, bindingResult);
    }


}
