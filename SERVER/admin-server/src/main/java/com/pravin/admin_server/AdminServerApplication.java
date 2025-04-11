package com.pravin.admin_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.util.retry.Retry;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

import java.time.Duration;

@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class AdminServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(AdminServerApplication.class, args);
  }

  @Bean
  public WebClient webClient(WebClient.Builder builder) {
    return builder
        .baseUrl("http://localhost:8081") // Replace with the correct base URL
        .filter((request, next) -> next.exchange(request)
            .retryWhen(Retry.backoff(3, Duration.ofSeconds(2)))) // Retry logic
        .build();
  }
}
