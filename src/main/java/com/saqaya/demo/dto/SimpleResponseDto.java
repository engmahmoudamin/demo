package com.saqaya.demo.dto;


import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class SimpleResponseDto implements Serializable {
    private String responseMessage;
}
