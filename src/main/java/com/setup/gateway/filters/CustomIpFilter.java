package com.setup.gateway.filters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class CustomIpFilter implements GlobalFilter {

	@Value("${ip.filter.enabled}")
	private boolean filterEnabled;

	@Value("#{'${ip.filter.trusted-hosts}'.split(',')}")
	private List<String> trustedHosts;

	@PostConstruct
	private void init() {
		if (null != trustedHosts) {
			trustedHosts = trustedHosts.stream()
					.map(String::trim)
					.collect(Collectors.toList());
		}
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("ip enabled: {}, trusted ips: {}", filterEnabled, trustedHosts);
		
		ServerHttpRequest request = exchange.getRequest();
		String requestPath = request.getPath().pathWithinApplication().value();
		String requsstIp = request.getRemoteAddress().getAddress().getHostAddress();
		log.info("request path: {}", requestPath);
		log.info("request ip: {}", requsstIp);
		if(filterEnabled && !trustedHosts.contains(requsstIp)) {
			log.info("Invalid Request ip");
			ServerHttpResponse resp = exchange.getResponse();
			resp.setStatusCode(HttpStatus.UNAUTHORIZED);
			return resp.setComplete();
		}
		return chain.filter(exchange);
	}

}
