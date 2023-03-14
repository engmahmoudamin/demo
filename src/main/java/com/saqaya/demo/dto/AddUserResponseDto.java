package com.saqaya.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class AddUserResponseDto implements Serializable {
    private String id;
    private String accessToken;
}
