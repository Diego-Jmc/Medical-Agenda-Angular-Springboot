package com.medical.backend.controllers;


import com.medical.backend.dtos.ErrorDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ErrorHandler {


    @ExceptionHandler(NoSuchElementException.class)
    public ErrorDto elementNotFound(NoSuchElementException e){
        return new ErrorDto("Element not found");
    }



}
