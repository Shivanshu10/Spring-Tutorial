package com.shivanshu.restdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception err) {
        StudentErrorResponse err_resp = new StudentErrorResponse();

        err_resp.setStatus(HttpStatus.BAD_REQUEST.value());
        err_resp.setMessage(err.getMessage());
        err_resp.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<StudentErrorResponse>(err_resp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFound err) {
        StudentErrorResponse err_resp = new StudentErrorResponse();

        err_resp.setStatus(HttpStatus.NOT_FOUND.value());
        err_resp.setMessage(err.getMessage());
        err_resp.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<StudentErrorResponse>(err_resp, HttpStatus.NOT_FOUND);
    }
}
