package com.finalsem.projectsem4.common;

import org.apache.commons.lang3.StringUtils;

public enum ErrorProvider {

    //COMMON
    INTERNAL_SERVER_ERROR("000", "errors.common.internal-server-error", "Internal server error"),
    VALIDATION_ERROR("001", "errors.common.validation-error", "Validation error"),
    SQL_ERROR("002", "errors.common.sql-error", "SQL error"),
    REQUIRED_ERROR("003", "errors.common.required-error", "Required information"),
    RECORD_DUPLICATED("004", "errors.common.record-duplicated", "Record is duplicated"),
    RECORD_EXISTED("005", "errors.common.record-existed", "Record is existed");


    private final String status;
    private final String code;
    private final String message;

    ErrorProvider(String status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ErrorProvider getByCode(String code) {
        for (ErrorProvider interestRateError : ErrorProvider.values()) {
            if (StringUtils.equals(code, interestRateError.getCode())) {
                return interestRateError;
            }
        }
        return null;
    }

    public ApiException toException() {
        return new ApiException(this.getStatus(), this.getCode(), this.getMessage());
    }

    public ApiException toExceptionWithCustomMessage(String message) {
        return new ApiException(this.getStatus(), null, message);
    }
}