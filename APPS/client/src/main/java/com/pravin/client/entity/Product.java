package com.pravin.client.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Product {
  private Long id;
  private String name;
  private Double price;

  @Override
  public String toString() {
    return "Product{id=" + id + ", name='" + name + "', price=" + price + "}";
  }
}
