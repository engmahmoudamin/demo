package com.saqaya.demo.dao;

import com.saqaya.demo.dto.UserDto;
import com.saqaya.demo.exception.ElementAlreadyExistsException;
import com.saqaya.demo.exception.NoElementFoundException;

public interface UserDao {

    /**
     *
     * @param id: id of the user
     * @return UserDto: userDto object contains user details
     *
     * @throws NoElementFoundException : if there is no user with this id
     */
    UserDto getUser(String id) throws NoElementFoundException;

    /**
     *
     * @param userDto user data to be added in the db
     * @return UserDto: user already added to db
     *
     * @throws ElementAlreadyExistsException : if there is already user exists with the same email
     */
    UserDto addUser(UserDto userDto) throws ElementAlreadyExistsException;

    /**
     *
     * @param email: email of the user
     * @return UserDto: userDto object contains user details
     *
     * @throws NoElementFoundException : if there is no user with this email
     */
    UserDto findByEmail(String email) throws NoElementFoundException;
}
