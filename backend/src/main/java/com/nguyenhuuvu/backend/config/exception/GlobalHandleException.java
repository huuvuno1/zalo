package com.nguyenhuuvu.backend.config.exception;

import com.nguyenhuuvu.backend.dto.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandleException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(
            new BaseResponse<Map<String, String>>().builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Validate exception!")
                .timeStamp(new Date())
                .data(errors)
                .build()
            ,HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> allException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<> (
            new BaseResponse<Exception>().builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Tam ban ra exception")
                .timeStamp(new Date())
                .data(e)
                .build(),
            HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MyException.class)
    public ResponseEntity<?> myException(MyException e) {
        e.printStackTrace();
        return new ResponseEntity<> (
                new BaseResponse<Exception>().builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message(e.getMessage())
                        .timeStamp(new Date())
                        .data(e.getUser())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }


    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> notFound(UsernameNotFoundException e) {
        return new ResponseEntity<>(
                new BaseResponse<Exception>().builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message("Not found user")
                        .timeStamp(new Date())
                        .data(e)
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<?> userDisabled(DisabledException e) {
        return new ResponseEntity<>(
                new BaseResponse<Exception>().builder()
                        .status(HttpStatus.NOT_ACCEPTABLE.value())
                        .message("User is disabled")
                        .timeStamp(new Date())
                        .build(),
                HttpStatus.NOT_ACCEPTABLE
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> bodyNull(HttpMessageNotReadableException e) {
        return new ResponseEntity<>(
                new BaseResponse<Exception>().builder()
                        .status(HttpStatus.NOT_ACCEPTABLE.value())
                        .message("Missing body!")
                        .timeStamp(new Date())
                        .build(),
                HttpStatus.NOT_ACCEPTABLE
        );
    }
}
