package com.easybank.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain springSecurityWebFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/accounts/**").authenticated()
                        .pathMatchers("/cards/**").authenticated()
                        .pathMatchers("/loans/**").permitAll()
                        .pathMatchers("/**").permitAll())
                .oauth2Login(Customizer.withDefaults());
        http.csrf(ServerHttpSecurity.CsrfSpec::disable);
        return http.build();
    }
}
