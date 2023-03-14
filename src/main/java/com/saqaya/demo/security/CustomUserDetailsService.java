package com.saqaya.demo.security;

import com.saqaya.demo.dao.UserDao;
import com.saqaya.demo.dto.UserDto;
import com.saqaya.demo.exception.NoElementFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class CustomUserDetailsService implements UserDetailsService {
    private final UserDao userDao;

    @Autowired
    public CustomUserDetailsService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            UserDto userDto = this.userDao.findByEmail(email);
            return UserPrincipal.create(userDto);
        } catch (NoElementFoundException ex) {
            throw new UsernameNotFoundException(ex.getMessage());
        }

    }

}