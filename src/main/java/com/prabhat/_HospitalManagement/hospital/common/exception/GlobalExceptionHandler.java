package com.prabhat._HospitalManagement.hospital.common.exception;

import com.prabhat._HospitalManagement.hospital.common.response.ApiError;
import com.prabhat._HospitalManagement.hospital.common.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<Object>> handleRuntime(RuntimeException ex) {

        ApiResponse<Object> response = ApiResponse.builder()
                .message(ex.getMessage())
                .data(new Object())
                .error(ApiError.builder()
                        .code("BAD_REQUEST")
                        .details(ex.getMessage())
                        .build())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
