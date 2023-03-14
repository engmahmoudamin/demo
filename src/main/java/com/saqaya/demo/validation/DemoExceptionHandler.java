package com.saqaya.demo.validation;

import com.saqaya.demo.DemoApplication;
import com.saqaya.demo.dto.SimpleResponseDto;
import com.saqaya.demo.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class DemoExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoElementFoundException.class)
    public ResponseEntity<SimpleResponseDto> handleNoElementFoundException(NoElementFoundException noElementFoundException) {
        return new ResponseEntity<>(new SimpleResponseDto(noElementFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<SimpleResponseDto> handleInvalidDataException(InvalidDataException invalidDataException) {
        return new ResponseEntity<>(new SimpleResponseDto(invalidDataException.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ElementAlreadyExistsException.class)
    public ResponseEntity<SimpleResponseDto> handleElementAlreadyExistsException(ElementAlreadyExistsException elementAlreadyExistsException) {
        return new ResponseEntity<>(new SimpleResponseDto(elementAlreadyExistsException.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<SimpleResponseDto> handleInvalidTokenException(InvalidTokenException invalidTokenException) {
        return new ResponseEntity<>(new SimpleResponseDto(invalidTokenException.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<SimpleResponseDto> handleUsernameNotFoundException(UsernameNotFoundException usernameNotFoundException) {
        return new ResponseEntity<>(new SimpleResponseDto(usernameNotFoundException.getMessage()), HttpStatus.FORBIDDEN);
    }

}
