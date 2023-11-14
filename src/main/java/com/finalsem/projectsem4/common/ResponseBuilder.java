package com.finalsem.projectsem4.common;

import lombok.*;

@Getter
@Setter
public class ResponseBuilder<T> {
    private String code;
    private String message;
    private T data;

    public ResponseBuilder(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseBuilder(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
