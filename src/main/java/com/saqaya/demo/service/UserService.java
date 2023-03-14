package com.saqaya.demo.service;

import com.saqaya.demo.dto.AddUserDto;
import com.saqaya.demo.dto.AddUserResponseDto;
import com.saqaya.demo.dto.UserDto;
import com.saqaya.demo.exception.InvalidDataException;

public interface UserService {
    /**
     *
     * @param id: id of the user
     * @return UserDto: userDto object contains user details
     */
    UserDto getUser(String id);

    /**
     * 1- validate the addUserDto is containing valid data
     * 2- create access-token
     * 3- build userDto and send it to userDao to be added in db
     *
     * @param addUserDto user data to be added in the db
     * @return AddUserResponseDto: addUser response which contain:
     *          id: id of the user
     *          access-token: a bearer token to be used in the getUser authentication
     *
     * @throws InvalidDataException : if there is invalid data in the request
     */
    AddUserResponseDto addUser(AddUserDto addUserDto);
}
