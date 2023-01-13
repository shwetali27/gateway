/*package com.setup.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

	// for details service : http://localhost:8076/test/api2/setup/details/users
	// if we want direct path without /test/api2 remove this from path and remove filter path rewrite
	//rewritePath method: ?<segment>.  --> replace /test/api2 only and keep the path after that as same.
	// for list service: http://localhost:8076/setup/list/users
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/test/api2/setup/details/**")
						.filters(f -> f.rewritePath("/test/api2(?<segment>.*)", "${segment}"))
						.uri("lb://details"))
				.route(p -> p.path("/setup/list/**")
						.uri("lb://list"))
				.build();
				
	}
}
*/
