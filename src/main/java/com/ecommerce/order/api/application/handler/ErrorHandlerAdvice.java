package com.ecommerce.order.api.application.handler;

import com.ecommerce.order.api.application.handler.wrapper.ErrorResponseVO;
import com.ecommerce.order.api.application.handler.wrapper.ErrorResponseWrapper;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class ErrorHandlerAdvice {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseWrapper> handleConstraintViolationException(ConstraintViolationException exception) {
        List<ErrorResponseVO> errors = exception.getConstraintViolations()
                .stream()
                .map(item -> new ErrorResponseVO(item.getMessage()))
                .collect(Collectors.toList());
        return buildErrorWrapper(HttpStatus.BAD_REQUEST, errors);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseWrapper> handleMethodArgumentNotValidExceptionValidationErrors(MethodArgumentNotValidException exception) {
        List<ErrorResponseVO> errors = exception.getBindingResult()
                    .getFieldErrors()
                    .stream()
                    .map(item -> new ErrorResponseVO(item.getDefaultMessage()))
                    .collect(Collectors.toList());
        return buildErrorWrapper(HttpStatus.BAD_REQUEST, errors);
    }

    private ResponseEntity<ErrorResponseWrapper> buildErrorWrapper(
            HttpStatus statusCode,
            List<ErrorResponseVO> errors) {
        return ResponseEntity
                .status(statusCode)
                .body(new ErrorResponseWrapper(errors));
    }

}