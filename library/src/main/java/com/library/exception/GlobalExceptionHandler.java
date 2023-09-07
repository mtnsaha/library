package com.library.exception;

import com.library.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException exception) {

        String message = exception.getMessage();

        ApiResponse apiResponse = new ApiResponse(message, false);

        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){

Map<String,String> resp = new HashMap<>();

ex.getBindingResult().getAllErrors().forEach(error -> {
    String fieldName = ((FieldError)error).getField();
    String defaultMessage =error.getDefaultMessage();
    resp.put(fieldName,defaultMessage);
});

return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);

    }


}