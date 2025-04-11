package com.pravin.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pravin.client.entity.Product;
import com.pravin.client.service.SomeService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {

  private final SomeService service;

  @GetMapping
  public List<Product> getProduct() {
    return service.displayAllProducts();
  }
  

}
