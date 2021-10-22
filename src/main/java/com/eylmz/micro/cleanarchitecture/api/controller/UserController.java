package com.eylmz.micro.cleanarchitecture.api.controller;

import com.eylmz.micro.cleanarchitecture.CleanArchitectureApplication;
import com.eylmz.micro.cleanarchitecture.api.request.UserRequest;
import com.eylmz.micro.cleanarchitecture.api.response.UserResponse;
import com.eylmz.micro.cleanarchitecture.mapper.UserMapper;
import com.eylmz.micro.cleanarchitecture.service.IUserService;
import com.eylmz.micro.cleanarchitecture.service.dto.UserInputDTO;
import com.eylmz.micro.cleanarchitecture.service.dto.UserOutputDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/users")
public class UserController {

    private IUserService userService;
    private UserMapper userMapper;

    @Operation(summary = "Create user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created a user"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PostMapping(path = "")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userRequest) {
        UserInputDTO userInputDTO = userMapper.mapRequestToInputDTO(userRequest);
        UserOutputDTO userOutputDTO = userService.addUser(userInputDTO);
        UserResponse userResponse = userMapper.mapOutputDTOToResponse(userOutputDTO);
        log.info("new user added to system.");
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable(value = "id") int id, @RequestBody UserRequest userRequest) {
        UserInputDTO userInputDTO = userMapper.mapRequestToInputDTO(userRequest);
        UserOutputDTO userOutputDTO = userService.updateUser(id, userInputDTO);
        UserResponse userResponse = userMapper.mapOutputDTOToResponse(userOutputDTO);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable(value = "id") int id) {
        UserOutputDTO userOutputDTO = userService.deleteUser(id);
        UserResponse userResponse = userMapper.mapOutputDTOToResponse(userOutputDTO);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable(value = "id") int id) {
        UserOutputDTO userOutputDTO = userService.getUserById(id);
        UserResponse userResponse = userMapper.mapOutputDTOToResponse(userOutputDTO);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @GetMapping(path = "")
    public ResponseEntity<List<UserResponse>> getUsers() {
        List<UserOutputDTO> userOutputDTOList = userService.listUsers();
        List<UserResponse> userResponseList = userMapper.mapOutputDTOListToResponseList(userOutputDTOList);
        return new ResponseEntity<>(userResponseList, HttpStatus.OK);
    }

}
