package com.pravin.client.dto;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.pravin.client.entity.Product;

@FeignClient(name = "ecommerce", url = "http://127.0.0.1:8081/api/get") // Base URL for the Feign client

public interface getClient {
  @GetMapping // Maps to the base URL directly
  List<Product> getAllProducts();
}
