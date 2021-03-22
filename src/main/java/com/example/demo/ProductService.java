package com.example.demo;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;


@Component
public class ProductService {

    public Flux<String> getAllProducts() {
        return Flux.just("Book", "Car", "pen", "Apple").delayElements(Duration.ofSeconds(5));
    }

    public Mono<String> getAllProduct() {
        return Mono.just("Cycle");
    }
}
