package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class ProductRouter {

    @Bean
    public RouterFunction<ServerResponse> productsRoute(ProductHandler productHandler){
        return RouterFunctions
                .route(GET("/products").and(accept(MediaType.APPLICATION_JSON))
                        ,productHandler::getAllProducts)
                .andRoute(GET("/product/{id}").and(accept(MediaType.APPLICATION_JSON))
                        ,productHandler::getProduct);
    }
}
