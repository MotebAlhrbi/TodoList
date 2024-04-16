package com.Api.TodoList.swagger;

import com.Api.TodoList.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "User", description = "the User Api")
public interface UserApi{

    @Operation(
            summary = "Create User",
            description = "Create new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    public ResponseEntity<?> createUser( User user);


    @Operation(summary="Update user" ,
            description="Update user info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    public ResponseEntity<?> updateUser( User user);

    @Operation(summary="Delete user" ,
            description="Delete user info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    public ResponseEntity<?> deleteUser( long id);


    @Operation(summary="get all user" ,
            description="get all user info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    public ResponseEntity<?> getAllUser();

}
