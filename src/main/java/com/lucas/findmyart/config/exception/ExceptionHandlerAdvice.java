package com.lucas.findmyart.config.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(APIException.class)
    public ResponseEntity<ExceptionDto> exceptionHander(APIException apiException) {
        ExceptionDto exceptionDto = new ExceptionDto(apiException);
        return ResponseEntity.status(apiException.getHttpStatus()).body(exceptionDto);
    }

}
