package com.example.crawlergateway.filter;



import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * @className: AuthFilter
 * @description: TODO 类描述
 * @date: 2025/5/23
 **/
@Component
public class AuthFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
//
//        if (authHeader == null || !authHeader.equals("Bearer my-token")) {
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            return exchange.getResponse().setComplete();
//        }

        // 通过校验，放行
        return chain.filter(exchange);
    }

    // 优先级越低越先执行
    @Override
    public int getOrder() {
        return -1;
    }
}
