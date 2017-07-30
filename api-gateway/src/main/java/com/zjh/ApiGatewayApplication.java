package com.zjh;

import com.zjh.filter.AccessFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @EnableZuulProxy 开启api 网关
 */
@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}


	/**
	 * 将自定义过滤器加入spring 容器中管理
	 * @return 自定义 zuul 的过滤器
	 */
	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
}
