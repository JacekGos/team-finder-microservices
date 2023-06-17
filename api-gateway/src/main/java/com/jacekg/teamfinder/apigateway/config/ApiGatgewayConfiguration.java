package com.jacekg.teamfinder.apigateway.config;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatgewayConfiguration {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		
		Function<PredicateSpec, Buildable<Route>> eventCoreRouteFunction
			= p -> p.path("/event-core/**")
				.uri("lb://event-core-service");
		Function<PredicateSpec, Buildable<Route>> eventRouteFunction
			= p -> p.path("/event/**")
				.uri("lb://event-service");
		Function<PredicateSpec, Buildable<Route>> userRouteFunction
			= p -> p.path("/user/**")
				.uri("lb://user-service");
		Function<PredicateSpec, Buildable<Route>> venueRouteFunction
			= p -> p.path("/venue/**")
				.uri("lb://venue-service");
			
		return builder.routes()
				.route(eventCoreRouteFunction)
				.route(eventRouteFunction)
				.route(userRouteFunction)
				.route(venueRouteFunction)
				.build();
	}

}
