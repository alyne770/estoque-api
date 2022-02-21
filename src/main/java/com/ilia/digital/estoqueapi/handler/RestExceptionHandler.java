package com.ilia.digital.estoqueapi.handler;

import com.ilia.digital.estoqueapi.exception.BadRequestException;

import com.ilia.digital.estoqueapi.exception.ExceptionDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDetails> badRequestHandler(BadRequestException badRequestException) {
        return new ResponseEntity<>(ExceptionDetails.builder()
                .developerMessage(badRequestException.getMessage())
                .title(badRequestException.getCause().getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build()
                , HttpStatus.BAD_REQUEST);

    }


    //SOBREESCREVER O RETORNO PREVIAMENTE DEFINIDO PELO SPRING MVC PARA TODAS AS DEMAIS EXCEPTIONS
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute("javax.servlet.error.exception", ex, 0);
        }

        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status((status.value()))
                .title((ex.getCause().getMessage()))
                .developerMessage(ex.getClass().getName())
                .build();

        return new ResponseEntity<>(exceptionDetails, headers, status);

    }
}
