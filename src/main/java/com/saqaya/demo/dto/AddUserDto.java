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
public class AddUserDto implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private boolean marketingConsent;
}
