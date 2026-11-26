package kh.edu.istad.m2restapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleResponseStatus(ResponseStatusException e) {
        Map<String, Object> body = new HashMap<>();

        body.put("Message", e.getReason());
        body.put("Status", e.getStatusCode().value());
        body.put("Timestamp", System.currentTimeMillis());

        return ResponseEntity.status(e.getStatusCode())
                .body(body);
    }

}
