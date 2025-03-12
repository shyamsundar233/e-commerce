package com.ecomm.main.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class ServiceException extends RuntimeException {

    public HttpStatus code;
    public Map<String, Object> details;

    public ServiceException(HttpStatus code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(HttpStatus code, Map<String, Object> map, String message) {
        super(message);
        this.code = code;
        this.details = map;
    }
}
