package com.salim.cascadetype.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ApiResponse {

    @Schema(description = "Indicates if the request was successful")
    private boolean success;
    private String message;
    private Object data;
}

