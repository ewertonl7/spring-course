package com.ewerton.rod.springcourse.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class ApiError implements Serializable {
    private String backendMessage;
    private String message;
    private String url;
    private String method;
    private LocalDateTime timestamp;
}
