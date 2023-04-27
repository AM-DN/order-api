package com.ecommerce.order.api.application.handler.wrapper;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record ErrorResponseVO(String message) {

}