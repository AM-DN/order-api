package com.ecommerce.order.api.application.handler.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record ErrorResponseWrapper(List<ErrorResponseVO> errors) {

}