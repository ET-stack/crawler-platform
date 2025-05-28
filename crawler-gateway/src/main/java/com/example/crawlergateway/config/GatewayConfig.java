//package com.example.crawlergateway.config;
//
//
//import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
//import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
//import org.springframework.cloud.gateway.route.RouteLocator;
//
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @className: GatewayConfig
// * @description: TODO 类描述
// * @date: 2025/5/23
// **/
//@Configuration
//public class GatewayConfig {
//
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("crawler-core", r -> r.path("/crawler-core/**")
//                        .filters(f -> f.stripPrefix(1)
//                                .requestRateLimiter(c -> c.setRateLimiter(new RedisRateLimiter(5, 10)))
//                        )
//                        .uri("lb://crawler-core")
//                )
//                .build();
//    }
//
//}
