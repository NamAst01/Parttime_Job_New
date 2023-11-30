package com.vti.Part_time_Job.configuration.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse {
    private String timestamp = LocalDateTime.now().toString();
    private String message ;
    private Object errors  ;
    private int code ;
    private String moreInformation ;
    private String detailMessage ;

    public ErrorResponse( int code, String message, String detailMessage) {
        this.message = message;
        this.code = code;
        this.detailMessage = detailMessage;
        this.moreInformation = "http://localhost:8080/api/v1/errors/" + code ;
    }

    public ErrorResponse(  int code, String message, String detailMessage , Object errors) {
        this(code, message, detailMessage);
        this.errors = errors;
    }
}
