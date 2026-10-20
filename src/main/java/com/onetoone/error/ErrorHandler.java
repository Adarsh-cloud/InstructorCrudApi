package com.onetoone.error;

import com.onetoone.exception.InstructorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(InstructorNotFoundException.class)
    public ResponseEntity<ResponsedError> handleInstructorNotFound(InstructorNotFoundException exception) {
        ResponsedError responsedError = new ResponsedError();
        responsedError.setDate(new Date());
        responsedError.setHttpStatus(HttpStatus.NOT_FOUND);
        responsedError.setMessage(exception.getMessage());
        return  new ResponseEntity<>(responsedError,HttpStatus.NOT_FOUND);
    }
}
