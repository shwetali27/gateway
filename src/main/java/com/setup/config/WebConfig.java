package com.setup.config;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class WebConfig implements WebFluxConfigurer{

	public void addCorsMappings(CorsRegistry reg) {
		reg.addMapping("/**")
		.allowCredentials(true)
		.allowedOriginPatterns("*")
		.allowedHeaders("*")
		.allowedMethods("*")
		.exposedHeaders(HttpHeaders.SET_COOKIE);
	}
	
	public CorsWebFilter corsWebFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		corsConfiguration.addAllowedOriginPattern("*");
		corsConfiguration.addExposedHeader(HttpHeaders.SET_COOKIE);
		UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
		configurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsWebFilter(configurationSource);
	}
}
