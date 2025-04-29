package com.admin.configuration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Global exception handler for handling application-specific and general exceptions.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles ConfigurationValidationException and returns a detailed error response.
     * 
     * @param ex the thrown ConfigurationValidationException
     * @return ResponseEntity with ErrorResponse and HTTP status
     */
    @ExceptionHandler(ConfigurationValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(ConfigurationValidationException ex) {
        ErrorResponse error = new ErrorResponse("Validation Error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Generic exception handler for handling all other exceptions.
     * This provides a fallback error response with a generic message.
     * 
     * @param ex the exception thrown
     * @return ResponseEntity with ErrorResponse and HTTP status
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // default 500 status
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse error = new ErrorResponse("Internal Server Error", "An unexpected error occurred.");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // You can add more handlers for other specific exceptions as needed
}
