package com.pravin.client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pravin.client.dto.getClient;
import com.pravin.client.entity.Product;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
@AllArgsConstructor
public class SomeService {

  private final getClient productFeignClient;

  public List<Product> displayAllProducts() {

    List<Product> products = new ArrayList<>();
    products = productFeignClient.getAllProducts();
    return products;
  }
  
}