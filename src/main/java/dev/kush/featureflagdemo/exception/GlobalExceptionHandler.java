package dev.kush.featureflagdemo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FlagException.class)
    public ErrorMessage handleFlagException(FlagException e) {
        return new ErrorMessage(e.getMessage());
    }
}
