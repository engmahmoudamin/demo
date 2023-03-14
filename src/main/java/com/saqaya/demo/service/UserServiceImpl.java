package com.saqaya.demo.service;

import com.saqaya.demo.dao.UserDao;
import com.saqaya.demo.dto.AddUserDto;
import com.saqaya.demo.dto.AddUserResponseDto;
import com.saqaya.demo.dto.UserDto;
import com.saqaya.demo.exception.InvalidDataException;
import com.saqaya.demo.security.JwtTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(JwtTokenProvider jwtTokenProvider, UserDao userDao) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userDao = userDao;
    }

    /**
     *
     * @param id: id of the user
     * @return UserDto: userDto object contains user details
     */
    @Override
    public UserDto getUser(String id) {
        UserDto userDto = userDao.getUser(id);
        if (!userDto.isMarketingConsent()) {
            userDto.setEmail(null);
        }
        return userDto;
    }

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
     * @throws InvalidDataException: if there is invalid data in the request
     */
    @Override
    public AddUserResponseDto addUser(AddUserDto addUserDto) throws InvalidDataException {
        if(addUserDto == null) {
            throw new InvalidDataException("Invalid Data - User with no data");
        }

        if(addUserDto.getFirstName() == null || addUserDto.getFirstName().isEmpty()) {
            throw new InvalidDataException("Invalid Data - First Name can't be empty");
        }

        if(addUserDto.getLastName() == null || addUserDto.getLastName().isEmpty()) {
            throw new InvalidDataException("Invalid Data - Last Name can't be empty");
        }

        if(addUserDto.getEmail() == null || addUserDto.getEmail().isEmpty()) {
            throw new InvalidDataException("Invalid Data - Email can't be empty");
        }


        String accessToken = jwtTokenProvider.createToken(addUserDto.getEmail());

        UserDto newUserDto = UserDto.builder()
                .firstName(addUserDto.getFirstName())
                .lastName(addUserDto.getLastName())
                .email(addUserDto.getEmail())
                .accessToken(accessToken)
                .marketingConsent(addUserDto.isMarketingConsent())
                .build();

        UserDto createdUserDto = userDao.addUser(newUserDto);

        return AddUserResponseDto.builder()
                .id(createdUserDto.getId())
                .accessToken(accessToken)
                .build();
    }
}
