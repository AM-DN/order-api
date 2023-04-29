package com.ecommerce.order.api.infra.feign;

import com.ecommerce.order.api.infra.feign.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "productApi", url = "${spring.cloud.openfeign.client.config.productApi.url}")
public interface ProductFeignClient {

    @GetMapping("/{productId}")
    ProductResponse getByProductId(@PathVariable("productId") UUID productId);
}
