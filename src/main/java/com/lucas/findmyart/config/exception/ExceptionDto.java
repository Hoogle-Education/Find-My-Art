package com.lucas.findmyart.config.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor
public class ExceptionDto {
    private String reason;
    private LocalDateTime moment;
    private String status;
    private String path;
    public ExceptionDto(APIException apiException) {
        this.reason = apiException.getReason();
        this.moment = apiException.getMoment();
        this.status = apiException.getHttpStatus().getReasonPhrase();
    }

}
