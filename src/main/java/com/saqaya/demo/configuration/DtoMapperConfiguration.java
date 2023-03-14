package com.saqaya.demo.configuration;

import com.saqaya.demo.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DtoMapperConfiguration {

    /**
     *
     * @return UserMapper: UserMapper bean that map from UserDto to UserEntity and vice versa
     */
    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }
}
