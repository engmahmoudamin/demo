package com.saqaya.demo.controller;

import com.saqaya.demo.dto.SimpleResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
public interface TestApi {

    /**
     * endpoint to test that the project is running
     * @return ResponseEntity<SimpleResponseDto> simple response contain a test message
     */
    @GetMapping
    ResponseEntity<SimpleResponseDto> test();
}
