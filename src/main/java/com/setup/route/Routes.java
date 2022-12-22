//package com.setup.route;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class Routes {
//	String gatewayPath = "/test/api";
//	String detailsServiceurl = "http://localhost:8077/";
//	String listServiceurl = "http://localhost:8078/";
//	
//	private RouteLocator myRoutes(RouteLocatorBuilder builder) {
//		System.out.println("0-------------------------od");
//		return builder.routes()
//				.route(r -> r
//						.path(gatewayPath + "/setup/details/user")
////						.filters(f -> f.stripPrefix(2))
//						.uri(detailsServiceurl + "/setup/details/user"))
//				.route(r -> r
//						.path(gatewayPath + "/setup/list/users")
//						.filters(f -> f.stripPrefix(2))
//						.uri(listServiceurl + "/setup/list/users"))
//				.build();
//
//	}
//}
