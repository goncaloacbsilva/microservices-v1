package com.goncaloacbs.rest.microservices.apigateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {

    private Function<PredicateSpec, Buildable<Route>> createRedirect(String from, String to, String uri) {
        return req -> req.path(from+"/**").filters(f -> f.rewritePath(from+"/(?<segment>.*)", to+"/${segment}")).uri(uri);
    }

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {


        return builder.routes()
                .route(req -> req.path("/currency-exchange/**").uri("lb://currency-exchange-service"))
                .route(req -> req.path("/currency-conversion/**").uri("lb://currency-conversion-service"))
                .route(this.createRedirect("/conversion-old","/currency-conversion", "lb://currency-conversion-service"))
                .build();
    }

}
