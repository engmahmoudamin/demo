package com.saqaya.demo.dao;

import com.saqaya.demo.dto.UserDto;
import com.saqaya.demo.entity.UserEntity;
import com.saqaya.demo.exception.ElementAlreadyExistsException;
import com.saqaya.demo.exception.NoElementFoundException;
import com.saqaya.demo.mapper.UserMapper;
import com.saqaya.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Autowired
    public UserDaoImpl(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     *
     * @param id: id of the user
     * @return UserDto: userDto object contains user details
     *
     * @throws NoElementFoundException : if there is no user with this id
     */
    @Override
    public UserDto getUser(String id) throws NoElementFoundException {
        Optional<UserEntity> optionalUserEntity = repository.findById(id);
        if (optionalUserEntity.isPresent()) {
            return mapper.mapToDto(optionalUserEntity.get());
        } else {
            throw new NoElementFoundException("No User Found By Id: " + id);
        }
    }

    /**
     *
     * @param userDto user data to be added in the db
     * @return UserDto: user already added to db
     *
     * @throws ElementAlreadyExistsException : if there is already user exists with the same email
     */
    @Override
    public UserDto addUser(UserDto userDto) throws ElementAlreadyExistsException {
        Optional<UserEntity> optionalUserEntity = repository.findByEmail(userDto.getEmail());
        if (optionalUserEntity.isPresent()) {
            throw new ElementAlreadyExistsException("User Already Exists With The Same Email");
        }

        UserEntity userEntity = mapper.mapToEntity(userDto);
        UserEntity addedUserEntity = repository.save(userEntity);
        return mapper.mapToDto(addedUserEntity);
    }

    /**
     *
     * @param email: email of the user
     * @return UserDto: userDto object contains user details
     *
     * @throws NoElementFoundException : if there is no user with this email
     */
    @Override
    public UserDto findByEmail(String email) throws NoElementFoundException {
        Optional<UserEntity> optionalUserEntity = repository.findByEmail(email);
        if (optionalUserEntity.isPresent()) {
            return mapper.mapToDto(optionalUserEntity.get());
        } else {
            throw new NoElementFoundException("User With Email " + email + " Not Found");
        }
    }
}
