package com.pravin.cloud_gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class myFilter implements GlobalFilter {

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    String method = exchange.getRequest().getMethod() != null
        ? exchange.getRequest().getMethod().name()
        : "UNKNOWN";
    String path = exchange.getRequest().getPath().toString();

    String host = exchange.getRequest().getHeaders().getFirst("Host");
    String connection = exchange.getRequest().getHeaders().getFirst("Connection");
    String cacheControl = exchange.getRequest().getHeaders().getFirst("Cache-Control");
    String userAgent = exchange.getRequest().getHeaders().getFirst("User-Agent");

    log.info("Global Filter Executed:");
    log.info("Method: {}", method);
    log.info("Path: {}", path);
    log.info("Host: {}", host);
    log.info("Connection: {}", connection);
    log.info("Cache-Control: {}", cacheControl);
    log.info("User-Agent: {}", userAgent);

    return chain.filter(exchange);
  }
}
