package com.workintech.plant.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class PlantExceptions extends RuntimeException{
    private HttpStatus status;

    public PlantExceptions(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
