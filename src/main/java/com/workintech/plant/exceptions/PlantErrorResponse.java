package com.workintech.plant.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlantErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
