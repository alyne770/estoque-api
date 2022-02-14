package com.ilia.digital.estoqueapi.handler;

import com.ilia.digital.estoqueapi.exception.BadRequestException;

import com.ilia.digital.estoqueapi.exception.ExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDetails> badRequestHandler(BadRequestException badRequestException) {
        return new ResponseEntity<>(ExceptionDetails.builder()
                .developerMessage(badRequestException.getMessage())
                .title(badRequestException.getCause().getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build()
                , HttpStatus.BAD_REQUEST);

    }
}
