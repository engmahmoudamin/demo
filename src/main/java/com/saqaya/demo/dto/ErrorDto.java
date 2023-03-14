package com.saqaya.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@AllArgsConstructor
@Setter
@Getter
public class ErrorDto implements Serializable {
    private String errorMessage;
}
