package com.workintech.plant.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class RestExceptionsHandler {
    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> exceptionsHandler (PlantExceptions exception){
        PlantErrorResponse response = new PlantErrorResponse(exception.getStatus().value(),
                exception.getMessage(),System.currentTimeMillis());
        log.error(exception.getMessage());
        return new ResponseEntity<>(response,exception.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleBindErrors (MethodArgumentNotValidException exception){
        List errors= exception.getBindingResult().getFieldErrors().stream().map(fieldError -> {
            Map<String,String> errorMap = new HashMap<>();
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            return errorMap;
        }).collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errors);
    }
    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> exceptionsHandler (Exception exception){
        PlantErrorResponse response = new PlantErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),System.currentTimeMillis());
        log.error(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
