package com.Api.TodoList.exceptionhandle;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
@Setter
public class ApiException{

    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

}
