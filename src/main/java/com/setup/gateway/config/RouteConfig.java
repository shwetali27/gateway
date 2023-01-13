//package com.setup.gateway.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RouteConfig {
//
//	// for details service : http://localhost:8076/setup/details/users
//	// for list service: http://localhost:8076/setup/list/users
//	@Bean
//	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route(p -> p.path("/setup/details/**")
//						.uri("lb://details"))
//				.route(p -> p.path("/setup/list/**")
//						.uri("lb://list"))
//				.build();
//				
//	}
//}
