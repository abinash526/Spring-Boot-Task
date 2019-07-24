package com.stackroute.springBoot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerClass {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorData> exceptionHandler(Exception e) throws Exception
    {
        ErrorData errorData=new ErrorData();
        errorData.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorData.setMessage(e.getMessage());
        return new ResponseEntity<ErrorData>(errorData,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
