package com.easybank.apigateway.filter;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Order(1)
@Component
@RequiredArgsConstructor
public class TraceFilter implements GlobalFilter {

    private static final Logger log = LoggerFactory.getLogger(TraceFilter.class);

    private final FilterUtility filterUtility;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders requestHeader = exchange.getRequest().getHeaders();
        if (isCorrelationIdPresent(requestHeader)) {
            log.debug("EazyBank-correlation-id found in tracing filter: {}.",
                      filterUtility.getCorrelationId(requestHeader));
        } else {
            String correlationID = generateCorrelationId();
            exchange = filterUtility.setCorrelationId(exchange, correlationID);
            log.debug("EazyBank-correlation-id generated in tracing filter: {}.", correlationID);
        }
        return chain.filter(exchange);
    }

    private boolean isCorrelationIdPresent(HttpHeaders requestHeaders) {
        return filterUtility.getCorrelationId(requestHeaders) != null;
    }

    private String generateCorrelationId() {
        return java.util.UUID.randomUUID().toString();
    }
}
