package com.onetoone.error;

import com.onetoone.exception.InstructorNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValid(MethodArgumentNotValidException exception){
        Map<String,String> outcome= new HashMap<>();
        exception.getBindingResult().getFieldErrors().
                forEach(error->{
                    outcome.put(error.getField(),error.getDefaultMessage());
                });

        return  new ResponseEntity<>(outcome,HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponsedError> handleInstructorNotFound(ConstraintViolationException exception) {
        ResponsedError responsedError = new ResponsedError();
        responsedError.setDate(new Date());
        responsedError.setHttpStatus(HttpStatus.NO_CONTENT);
        responsedError.setMessage(exception.getMessage());
        return  new ResponseEntity<>(responsedError,HttpStatus.NO_CONTENT);
    }
}
