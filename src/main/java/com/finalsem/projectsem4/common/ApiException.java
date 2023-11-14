package com.finalsem.projectsem4.common;

import lombok.Getter;

import java.util.List;

@Getter
public class ApiException extends RuntimeException {
    private static final long serialVersionUID = -4165174023978038335L;
    private final String status;
    private final String code;
    private final List<String> listParams;

    public ApiException() {
        this.status = null;
        this.code = null;
        this.listParams = null;
    }
    public ApiException(String status, String code, String message) {
        super(message);
        this.status = status;
        this.code = code;
        this.listParams = null;
    }
    public ApiException(String status, String code, String message, List<String> listParams) {
        super(message);
        this.status = status;
        this.code = code;
        this.listParams = listParams;
    }
}
