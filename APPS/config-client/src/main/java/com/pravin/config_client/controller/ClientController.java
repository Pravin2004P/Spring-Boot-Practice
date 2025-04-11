package com.pravin.config_client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RefreshScope
public class ClientController {
  @Value("${msg::cant get an message}")
  private String msg;

  @GetMapping("/")
  public String gitMessage() {
      return msg;
  }
  
}
