package com.easybank.apigateway;

import com.easybank.apigateway.trace.logging.ObservationContextSnapshotLifter;
import io.micrometer.context.ContextSnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.factory.TokenRelayGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Operators;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@ConditionalOnClass({ContextSnapshot.class, Hooks.class})
	@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
	@Bean
	public ApplicationListener<ContextRefreshedEvent> reactiveObservableHook() {
		return event -> Hooks.onEachOperator(
				ObservationContextSnapshotLifter.class.getSimpleName(),
				Operators.lift(ObservationContextSnapshotLifter.lifter()));
	}
}
