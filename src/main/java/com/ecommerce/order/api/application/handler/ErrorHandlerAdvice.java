package com.ecommerce.order.api.application.handler;

import com.ecommerce.order.api.application.handler.wrapper.ErrorResponseVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.util.Optional;


@RestControllerAdvice
public class ErrorHandlerAdvice {


    @Autowired
    private ObjectMapper objectMapper;

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseVO> handleConstraintViolationException(ConstraintViolationException exception) {
        Optional<ErrorResponseVO> responseVO = exception.getConstraintViolations()
                .stream()
                .map(item -> ErrorResponseVO.builder().status(HttpStatus.BAD_REQUEST)
                        .timeStamp(LocalDateTime.now())
                        .message(item.getMessage())
                        .build())
                .findFirst();
        return responseVO.map(this::buildErrorWrapper).orElseGet(() -> buildErrorWrapper(buildInternalServerError()));
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<?> handleFeignException(FeignException exception) throws JsonProcessingException {
        ByteBuffer byteBuffer = exception.responseBody().get();
        String errorMessage = new String(byteBuffer.array());
        ErrorResponseVO errorResponseVO = objectMapper.readValue(errorMessage, ErrorResponseVO.class);
        return buildErrorWrapper(errorResponseVO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseVO> handleMethodArgumentNotValidExceptionValidationErrors(MethodArgumentNotValidException exception) {
        Optional<ErrorResponseVO> responseVO = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(item -> ErrorResponseVO.builder().status(HttpStatus.BAD_REQUEST)
                        .timeStamp(LocalDateTime.now())
                        .message(item.getDefaultMessage())
                        .build())
                .findFirst();
        return responseVO.map(this::buildErrorWrapper).orElseGet(() -> buildErrorWrapper(buildInternalServerError()));
    }

    private ResponseEntity<ErrorResponseVO> buildErrorWrapper(ErrorResponseVO errorResponseVO) {
        return ResponseEntity
                .status(errorResponseVO.status())
                .body(errorResponseVO);
    }

    private static ErrorResponseVO buildInternalServerError() {
        return new ErrorResponseVO(HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

}