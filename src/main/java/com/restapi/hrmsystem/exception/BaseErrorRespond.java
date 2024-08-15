package com.restapi.hrmsystem.exception;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseErrorRespond {
    // POJO
    // The custom Java class to sent back to client as JSON
    private int status;
    private String message;
    private long time;

    // Constructors

    // Getter, Setter
}
