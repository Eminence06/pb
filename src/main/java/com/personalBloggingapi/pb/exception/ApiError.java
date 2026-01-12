package com.personalBloggingapi.pb.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ApiError {

    private final String message;
    private final LocalDateTime timeStamp;

    public ApiError(String message){
        this.message = message;
        this.timeStamp = LocalDateTime.now();
    }
}
