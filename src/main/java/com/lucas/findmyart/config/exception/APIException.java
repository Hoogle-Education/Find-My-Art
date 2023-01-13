package com.lucas.findmyart.config.exception;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter @Setter
public class APIException extends RuntimeException {

    private String reason;
    private HttpStatus httpStatus;
    private LocalDateTime moment = LocalDateTime.now();

    public APIException(String message, @NonNull String reason) {
        super(message);
        this.reason = reason;
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    public APIException(String message, @NonNull String reason, HttpStatus httpStatus) {
        super(message);
        this.reason = reason;
        this.httpStatus = httpStatus;
    }
}
