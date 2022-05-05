package com.goncaloacbs.rest.microservices.currencyexchangeservice.controllers;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sampleApi")
    //@CircuitBreaker(name = "default", fallbackMethod = "fallbackResponse")
    //@RateLimiter(name = "default")
    //@Bulkhead(name = "default")
    public String sampleApi() {

        logger.info("Sending request -> http://localhost:8001/invalid-endpoint");

        //ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost:8001/invalid-endpoint", String.class);

        return "sample api";
    }

    public String fallbackResponse(Exception ex) {
        return "fallback-response: ";
    }
}
