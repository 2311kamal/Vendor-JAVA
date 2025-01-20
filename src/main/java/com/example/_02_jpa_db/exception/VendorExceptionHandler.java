package com.example._02_jpa_db.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example._02_jpa_db.response.Response;

@ControllerAdvice
public class VendorExceptionHandler {

    @ExceptionHandler(value = { VendorNotFoundException.class })
    public ResponseEntity<Object> handleVendorNotFoundException(VendorNotFoundException ex) {
        VendorException vendorException = new VendorException(ex.getMessage(), ex.getCause(), HttpStatus.NOT_FOUND);

        return new Response.Builder<Object>().status(HttpStatus.NOT_FOUND.value())
                .message(vendorException.getMessage()).build();

    }
}
