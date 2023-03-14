package com.saqaya.demo.mapper;

import com.saqaya.demo.dto.UserDto;
import com.saqaya.demo.entity.UserEntity;

public class UserMapper {

    public UserDto mapToDto(UserEntity entity) {
        return UserDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .accessToken(entity.getAccessToken())
                .marketingConsent(entity.isMarketingConsent())
                .build();
    }

    public UserEntity mapToEntity(UserDto dto) {
        return UserEntity.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .accessToken(dto.getAccessToken())
                .marketingConsent(dto.isMarketingConsent())
                .build();
    }
}
