package com.saqaya.demo.controller;

import com.saqaya.demo.dto.AddUserDto;
import com.saqaya.demo.dto.AddUserResponseDto;
import com.saqaya.demo.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
public interface UserApi {

    /**
     *
     * @param id: id of the user
     * @return ResponseEntity<UserDto> userDto object contains user details
     */
    @GetMapping("{id}")
    ResponseEntity<UserDto> getUser(@PathVariable("id") String id);

    /**
     *
     * @param addUserDto user data to be added in the db
     * @return ResponseEntity<AddUserResponseDto> addUser response which contain:
     *          id: id of the user
     *          access-token: a bearer token to be used in the GET: /users call
     */
    @PostMapping
    ResponseEntity<AddUserResponseDto> addUser(@RequestBody AddUserDto addUserDto);
}
