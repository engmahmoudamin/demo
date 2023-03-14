package com.saqaya.demo.controller;

import com.saqaya.demo.dto.AddUserDto;
import com.saqaya.demo.dto.AddUserResponseDto;
import com.saqaya.demo.dto.UserDto;
import com.saqaya.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     *
     * @param id: id of the user
     * @return ResponseEntity<UserDto> userDto object contains user details
     */
    @Override
    public ResponseEntity<UserDto> getUser(String id) {
        UserDto userDto = this.userService.getUser(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    /**
     *
     * @param addUserDto user data to be added in the db
     * @return ResponseEntity<AddUserResponseDto> addUser response which contain:
     *          id: id of the user
     *          access-token: a bearer token to be used in the GET: /users call
     */
    @Override
    public ResponseEntity<AddUserResponseDto> addUser(AddUserDto addUserDto) {
        AddUserResponseDto addUserResponseDto = this.userService.addUser(addUserDto);
        return new ResponseEntity<>(addUserResponseDto, HttpStatus.OK);
    }
}
