package com.saqaya.demo.controller;

import com.saqaya.demo.dto.SimpleResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController implements TestApi{

    /**
     * endpoint to test that the project is running
     * @return ResponseEntity<SimpleResponseDto> simple response contain a test message
     */
    @Override
    public ResponseEntity<SimpleResponseDto> test(){
        return new ResponseEntity<>(new SimpleResponseDto("Saqaya Demo App is Running"), HttpStatus.OK);
    }
}
