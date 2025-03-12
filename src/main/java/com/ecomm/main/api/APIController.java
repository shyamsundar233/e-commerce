package com.ecomm.main.api;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class APIController {

    @Data
    public static class Response {
        private String code;
        private String message;
        private Map<String, Object> data;
    }

    private final Response response = new Response();

    public void addResponse(String code, String message) {
        response.code = code;
        response.message = message;
    }

    public void addResponse(HttpStatus code, String message, Map<String, Object> data) {
        response.code = String.valueOf(code.value());
        response.message = message;
        response.data = data;
    }

    public ResponseEntity<Response> response() {
        return new ResponseEntity<>(response, HttpStatus.valueOf(Integer.parseInt(response.code)));
    }

}
