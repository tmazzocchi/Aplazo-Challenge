package com.mazzocchitomas.simpleinterestmicroservice.controller;

import com.mazzocchitomas.simpleinterestmicroservice.exception.ValidatorException;
import com.mazzocchitomas.simpleinterestmicroservice.model.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

/**
 * @since V2
 */
@ControllerAdvice
public class MainExceptionHandler {
    @ExceptionHandler(ValidatorException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(ValidatorException ex) {
        HttpStatus httpStatus = UNPROCESSABLE_ENTITY;
        ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), ex.getMessage());
        errorResponse.putExtra("violations", ex.getViolationMessages());
        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
