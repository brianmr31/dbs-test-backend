package com.example.dbstest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ValidationExceptionHandler {
    // {
    //     "timestamp": "2024-04-02T04:37:02.926+00:00",
    //     "status": 400,
    //     "error": "Bad Request",
    //     "path": "/employees"
    // }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> notValid(MethodArgumentNotValidException ex, HttpServletRequest request) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    List<String> errors = new ArrayList<>();

    ex.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));

    Map<String, Object> result = new HashMap<>();

    result.put("path", request.getRequestURI() );
    // result.put("error", "Bad Request");
    result.put("status", 400 );
    result.put("timestamp", sdf.format( new Date() ));
    result.put("error", errors);

    return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
  }
}